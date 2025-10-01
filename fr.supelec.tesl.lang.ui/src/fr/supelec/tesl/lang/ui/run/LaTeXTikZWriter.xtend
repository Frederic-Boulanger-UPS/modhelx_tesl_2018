package fr.supelec.tesl.lang.ui.run;

import java.io.PrintWriter
import java.util.HashMap
import java.util.HashSet
import java.util.Locale
import java.util.Set
import java.util.LinkedList
import java.io.File
import java.text.NumberFormat

// Output handler for TikZ pictures in LaTeX
class LaTeXTikZWriter implements OutputFormatHandler {
    // Need to use the US locale so that the decimal separator is '.'
    private static val locale = Locale.US;
    private static val numberFormat = NumberFormat.getInstance(locale)
    static val fileExtension = ".tikz"
    static val texFileExtension = ".tex"
    static val tickMarkHeight = 0.2  // height of a tick mark on the time line
    static val clockTickHeight = 0.6 // height of a tick mark on the clock lines
    static val xOffsetFromTimeOrigin = -1  // start of time lines offset from time origin
    static val extraClockLenth = 1         // extra length of time lines after last time
    static val extraTimelineLenth = 0.3    // extra length for the global time line
    
    override void write(TESLSpec spec, OutputFormat fmt) {
        val w = new PrintWriter(spec.baseName + fileExtension)
        
        numberFormat.setMaximumFractionDigits(2)
        numberFormat.setGroupingUsed(false)
        spec.console(spec.out, "## Writing " + fmt.name + " output")
        
        // Sanity check        
        if(spec.getTicks().size() != spec.getTags().size()) {
            w.println("% Bug : ticks.size()=" + spec.getTicks().size()
                                              + ", tags.size()=" + spec.getTags().size()
            );
        }
        
        val theTicks = new LinkedList<Set<String>>()
        val theTags = new LinkedList<Double>()
        
        fmt.clipToWindow(spec, theTicks, theTags)
        
        if(theTicks.size() == 0) {
            w.println("% No output tick");
            w.close()
            spec.console(spec.out, "## No output tick");
            spec.console(spec.out, "## Done");
            return;
        }
        w.println('''
		\pgfkeysifdefined{/tikz/tesl clock name/.@cmd}{}{%
		  \tikzstyle{tesl clock name}=[node font=\sffamily, above left, inner ysep=0pt]
		}
		\pgfkeysifdefined{/tikz/tesl time line/.@cmd}{}{%
		  \tikzstyle{tesl time line}=[->,shorten >=1pt,auto,semithick]
		}
		\pgfkeysifdefined{/tikz/tesl tick helper/.@cmd}{}{%
		  \tikzstyle{tesl tick helper}=[loosely dotted]
		}
		\pgfkeysifdefined{/tikz/tesl clock tick mark/.@cmd}{}{%
		  \tikzstyle{tesl clock tick mark}=[thick]
		}
		\pgfkeysifdefined{/tikz/tesl tick mark/.@cmd}{}{%
		  \tikzstyle{tesl tick mark}=[]
		}
		\pgfkeysifdefined{/tikz/tesl tick label/.@cmd}{}{%
		  \tikzstyle{tesl tick label}=[below, node font={\sffamily\scriptsize}]
		}
		\pgfkeysifdefined{/tikz/tesl clock line/.@cmd}{}{%
		  \tikzstyle{tesl clock line}=[]
		}
		\expandafter\ifx\csname teslclocktickheight\endcsname\relax
		  \def\teslclocktickheight{«clockTickHeight»}%
		\fi
		\expandafter\ifx\csname tesltimetickheight\endcsname\relax
		  \def\tesltimetickheight{«tickMarkHeight»}%
		\fi
		\expandafter\ifx\csname teslxoffsetfromtimeorigin\endcsname\relax
		  \def\teslxoffsetfromtimeorigin{«xOffsetFromTimeOrigin»}%
		\fi
		\expandafter\ifx\csname teslextraclocklength\endcsname\relax
		  \def\teslextraclocklength{«extraClockLenth»}%
		\fi
		\expandafter\ifx\csname teslextratimelinelength\endcsname\relax
		  \def\teslextratimelinelength{«extraTimelineLenth»}%
		\fi
		\expandafter\ifx\csname teslpicid\endcsname\relax
		  \def\teslpicid{}%
		\fi
        ''')
        val double xscale = fmt.xscale
          
        val double xMax = theTags.get(theTags.size()-1) * xscale;
        val double xMin = theTags.get(0) * xscale;
        
        var double y = 0;
        
        val yClocks = new HashMap<String, Double>();
        
        // Clocks to display
        val clocks = if (fmt.selection.size == 0) {
            spec.orderedClockNames
        } else {
            fmt.selection
        }
        for(String c : clocks) {
        	w.print('''
        	  \path («format(xMin)», «format(-y)») ++(\teslxoffsetfromtimeorigin, 0) coordinate (\teslpicid c_«format(y as int)») ;
        	  \path («format(xMin)», «format(-y)») ++(«format(xMax - xMin)», 0) ++(\teslextraclocklength, 0) coordinate (\teslpicid c_«format(y as int)»_end) ;
        	  \draw[tesl clock line] (\teslpicid c_«format(y as int)») node[tesl clock name] {«escape(fmt.newName(c))»} -- (\teslpicid c_«format(y as int)»_end) ;
        	''')
//        	  \draw  («format(xMin - 1)», «format(-y)») node[tesl clock name] (c_«format(y as int)») {«escape(fmt.newName(c))»} -- +(«format(xMax - xMin + 2)», 0) ;
//            w.printf(locale,
//                    "  \\draw (%.2f, %.2f) node[tesl clock name] (c_%d) {%s} -- (%.2f, %.2f);\n",
//                    xMin - 1, -y, (y as int), escape(fmt.newName(c)), xMax + 1, -y);
            yClocks.put(c, y);
            y = y + 1;
        }
        w.print('''
          \path («format(xMin)», «format(-y)») ++(\teslxoffsetfromtimeorigin, 0) coordinate (\teslpicid timeline) ;
          \path («format(xMin)», «format(-y)») ++(«format(xMax - xMin)», 0) ++(\teslextraclocklength, 0) ++(\teslextratimelinelength, 0) coordinate (\teslpicid timeline_end) ;
          \draw[tesl time line] (\teslpicid timeline) -- (\teslpicid timeline_end) ;
        ''')
//        w.printf(locale,
//                "  \\draw[tesl time line] (%.2f, %.2f) -- (%.2f, %.2f);\n",
//                xMin - 1, -y, xMax + 1.3, -y);
        
        for(i : 0..< theTicks.size()) {
            val Set<String> currentTicks = theTicks.get(i);
            val double date = theTags.get(i);
            val double x = date * xscale

			w.print('''
			  \draw[tesl tick helper] («format(x)», 0) -- +(0, «format(-y)») ;
			''')
//            w.printf(locale, "  \\draw[tesl tick helper] (%.2f, %.2f) -- (%.2f, %.2f);\n", x, 0.0, x, -y);
            
            // no decimal part if we have an "integer" number
            //System.out.println(date + "  diff=" + Math.abs(date - Math.floor(date)) + " -> " + (Math.abs(date - Math.floor(date)) < 1e2));
            val labelDate = if(Math.abs(date - Math.floor(date)) < 1e-2) {
            	format(date as int)
//                Integer.toString(date as int);
            } else {
            	format(date)
//                String.format(locale, "%.2f", date);
            }
            
            // print label, only if one of the current ticks is in the labelIf set
            var printLabel = true;
            if (fmt.getLabelIf().size() > 0) {
                val inter = new HashSet<String>(currentTicks);
                inter.retainAll(fmt.getLabelIf());
                if(inter.isEmpty()) {
                    printLabel = false;
                }
            }
            
            if (printLabel) {
            	w.print('''
            	  \draw[tesl tick mark] («format(x)», «format(-y)») -- +(0, \tesltimetickheight) ;
            	''')
//                w.printf(locale, "  \\draw[tesl tick mark] (%.2f, %.2f) -- (%.2f, %.2f);\n", x, -y, x, -y + 0.2);
				w.print('''
				  \node[tesl tick label] (\teslpicid d_«labelDate.replace('.', '_')») at («format(x)», «format(-y)») {«labelDate»} ;
				''')
//                w.printf(locale, "  \\draw (%.2f, %.2f) node[tesl tick label] (d_%s) {%s};\n", x, -y, labelDate.replace('.', '_'), labelDate);
            }
            
            for (String c : currentTicks) {
                if (clocks.contains(c)) {
                    val Double yOfClock = yClocks.get(c);
                    if (yOfClock != null) {
                        //System.out.println("Looking for " + c + " in " + yClocks + "  //  clocks=" + clocks);
                        drawTick(w, x, yOfClock, fmt.newName(c) + "_" + i);
                    }
                }
            }
        }

        w.close()
        
        if (fmt.standalone) {
            if (fmt.borders == null) {
                fmt.borders = "1mm"
            }
            val texfile = new File(spec.baseName + texFileExtension)
            if (!texfile.exists || fmt.overwrite) {
                val tw = new PrintWriter(spec.baseName + texFileExtension)
            
                tw.println('''
                  \documentclass[crop, border=«fmt.borders»]{standalone}
                  \usepackage{tikz}
                  \begin{document}
                    \begin{tikzpicture}
                      \input{«new File(spec.baseName).name»«fileExtension»}
                    \end{tikzpicture}
                  \end{document}
                ''')

                tw.close()
            } else {
                spec.console(spec.out, "** Not overwriting existing standalone file \"" + texfile.name + "\"")
            }
        }
        
        spec.console(spec.out, "## Done");
    }
    
    def format(double d) {
        numberFormat.format(d)
    }
    
    def format(long l) {
        numberFormat.format(l)
    }
    
    def escape(String s) {
        s.replaceAll("_", "\\\\_").replaceAll("&", "\\\\&").replaceAll("#", "\\\\#");
    }

    def void drawTick(PrintWriter w, double x, double y, String id) {
    	w.print('''
    	  \draw[tesl clock tick mark] («format(x)», «format(-y)») -- +(0, \teslclocktickheight) ; % «id»
    	''')
//        w.printf(locale, "  \\draw[tesl clock tick mark] (%.2f, %.2f) -- (%.2f, %.2f);\t\t%%%s\n", x, -y, x, -y + 0.6, id);
        
        /* Provision for labeling ticks
        String label = labeler.getLabel(id);
        if(label != null) {
            w.printf(locale, "  \\coordinate (%s) at (%.2f, %.2f);\n", label, x, -y);
        }
        */
    }
}
