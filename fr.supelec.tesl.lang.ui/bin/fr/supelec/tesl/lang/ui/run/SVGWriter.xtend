package fr.supelec.tesl.lang.ui.run;

import java.io.PrintWriter
import java.util.HashMap
import java.util.HashSet
import java.util.Locale
import java.util.Set
import java.util.LinkedList
import java.io.File
import java.util.StringTokenizer
import java.io.FileNotFoundException
import java.io.UnsupportedEncodingException
import java.text.NumberFormat

// Output handler for TikZ pictures in LaTeX
class SVGWriter implements OutputFormatHandler {
    // Need to use the US locale so that the decimal separator is '.'
    private static val locale = Locale.US;
    private static val numberFormat = NumberFormat.getInstance(locale)
    static val fileExtension = ".svg"
    static val htmlFileExtension = ".html"
    
    override void write(TESLSpec spec, OutputFormat fmt) {
        numberFormat.setMaximumFractionDigits(2)
        numberFormat.setGroupingUsed(false)
        val w = try {
            new PrintWriter(spec.baseName + fileExtension, "UTF-8")
        } catch (FileNotFoundException e) {
            spec.console(spec.err, "## Error: could not open \"" + spec.baseName + fileExtension + "\" for writing.")
            null as PrintWriter
        } catch (UnsupportedEncodingException e) {
            spec.console(spec.err, "## Error: UTF-8 encoding not supported.")
            null as PrintWriter
        }
        if (w == null) {
            spec.console(spec.err, "## Error: No SVG file written.")
            return            
        }
        spec.console(spec.out, "## Writing " + fmt.name + " output")
        
        // Sanity check        
        if(spec.getTicks().size() != spec.getTags().size()) {
            w.println("% Bug : ticks.size()=" + spec.getTicks().size()
                                              + ", tags.size()=" + spec.getTags().size()
            );
        }
        
        val theTicks = new LinkedList<Set<String>>()
        val theTags = new LinkedList<Double>()
        var width = 200
        var height = 50
        
        fmt.clipToWindow(spec, theTicks, theTags)
        
        if(theTicks.size() == 0) {
            w.println('''
            <svg xmlns='http://www.w3.org/2000/svg' width='«width»' height='«height»'>
              <text x='10' y='20' fill='red'>No output tick</text>
            </svg>
            ''')
            w.close()
            spec.console(spec.out, "## No output tick");
            spec.console(spec.out, "## Done");
            return;
        }
        
        val double xscale = fmt.xscale
        val double yscale = 20
          
        val double xMax = theTags.get(theTags.size()-1) * xscale
        val double xMin = theTags.get(0) * xscale
        val double dateOffset = 50.0
        
        val yClocks = new HashMap<String, Double>();
        
        // Clocks to display
        val clocks = if (fmt.selection.size == 0) {
            spec.orderedClockNames
        } else {
            fmt.selection
        }
        var maxlen = 0
        var nclocks = 0
        for (String c : clocks) {
            val len = escape(fmt.newName(c)).length
            nclocks = nclocks + 1
            if (len > maxlen) {
                maxlen = len
            }
        }
        val double namesOffset = 7.5 * maxlen  // 7.5 is an empirical value, depends on the font
        var double border_left = 0;
        var double border_right = 0;
        var double border_bottom = 0;
        var double border_top = 0;
        if (fmt.borders != null) {
            // "border", or "border_left-right border_bottom-top", or "border_left border_right border_bottom border_top"
            var borders = new StringTokenizer(fmt.borders, "{} ")
            try {
                switch (borders.countTokens) {
                    case 1: {
                        val tok = borders.nextToken
                        if (tok != "auto") {
                            border_left = Double.parseDouble(tok)
                            border_right = border_left
                            border_bottom = border_left
                            border_top = border_left
                        }
                    }
                    case 2: {
                        border_left = Double.parseDouble(borders.nextToken)
                        border_right = border_left
                        border_bottom = Double.parseDouble(borders.nextToken)
                        border_top = border_bottom
                    }
                    case 4: {
                        border_left = Double.parseDouble(borders.nextToken)
                        border_right = Double.parseDouble(borders.nextToken)
                        border_bottom = Double.parseDouble(borders.nextToken)
                        border_top = Double.parseDouble(borders.nextToken)
                    }
                    default:
                        spec.console(spec.err, "## Error: invalid format for borders in svg output pragma.")
                }
            } catch (Exception e) {
                spec.console(spec.err, "## Error: invalid number for borders in svg output pragma")
            }
        }
        width = (namesOffset + 10 + xMax - xMin + 1.5 * dateOffset + 6 /* arrow width */+ border_left + border_right) as int
        height = (yscale * (nclocks + 2) + border_top + border_bottom) as int

        var jscriptLayout = '''
        <script type='text/javascript'>
        <![CDATA[
          function moveGroup(group, offset) {
            group.setAttribute("x", offset);
          }
          document.documentElement.addEventListener("load", function() {
            var clocknames = document.documentElement.getElementById("clocknames");
            var chrono = document.documentElement.getElementById("chrono");
            var clockbbox = clocknames.getBBox();
            var chronobbox = chrono.getBBox();
            var xnames = clockbbox.x;
            // Move clock names flush left
            moveGroup(clocknames, -xnames);
            origin = clockbbox.width + 10;
            offset = chrono.getBBox().x - origin;
            // Move chronogram to the right of the clock names
            moveGroup(chrono, -offset);
            var maxh = clockbbox.height;
            if (chronobbox.height > maxh) {
              maxh = chronobbox.height
            }
            // Set view box to bounding box
            document.documentElement.setAttribute(
              "viewBox", 
              "0 0 " + (clockbbox.width + chronobbox.width + 16) + " " + maxh
            );
          })
        ]]>
        </script>
        '''
        w.println('''<?xml version="1.0" encoding="UTF-8"?>''')
        if (fmt.css != null) {
            w.println('''
              <?xml-stylesheet type="text/css" href="«fmt.css»" ?>''')
        }
        w.println('''
          <svg xmlns='http://www.w3.org/2000/svg'
          «IF (fmt.jvs != null)»
              «"     "»xmlns:xlink='http://www.w3.org/1999/xlink'
          «ENDIF»
               viewBox='0 0 «width» «height»'>
            «IF (fmt.jvs != null) »
              <script type="text/ecmascript" xlink:href="«fmt.jvs»"/>
            «ENDIF»
            <defs>
              <marker id='arrow-head' orient='auto' markerWidth='6' markerHeight='6' refX='0' refY='3'>
                <path d='M0,0 V6 L6,3 Z' fill='black'/>
              </marker>
            </defs>
            «IF ((fmt.borders != null) && (fmt.borders == "auto"))»
              «jscriptLayout»
            «ENDIF»
            «IF (!fmt.nodefcss)»
            <style type='text/css'>
            <![CDATA[
              .clockline {
                stroke-width: 1px;
                stroke: black;
              }
              .timeline {
                stroke-width: 1px;
                stroke: black;
                marker-end: url(#arrow-head);
              }
              .clockname {
                font-family: sans-serif;
                font-size:80%;
                text-anchor: end;
              }
              .ticklabel {
                font-family: sans-serif;
                font-size:60%;
                text-anchor: middle;
                /* 2014-05: baseline-shift does not work in Firefox (OK in Chrome and Safari) */
                /* baseline-shift: -1em; */
                transform: translate(0px, 1em);  /* For Firefox */
                -webkit-transform: translate(0px, 1em); /* For Chrome, Safari */
              }
              .tickmark {
                stroke: black;
                stroke-width: 2px;
              }
              .clktickmark {
                stroke: black;
                stroke-width: 2px;
              }
              .tickhelper {
                stroke: black;
                stroke-width: 1px;
                stroke-dasharray: 2 5;
              }
            ]]>
            </style>
            «ENDIF»
        ''')
        w.println("  <svg id='clocknames' x='0' y='" + format(border_top) + "'>")
        var double y = 1;
        
        for (String c : clocks) {
            val len = escape(fmt.newName(c)).length
            if (len > maxlen) {
                maxlen = len
            }
            w.println(
            '''    <text class='clockname' id='c_«format(y as int)»' x='«format(namesOffset + border_left)»' y='«format(y * yscale)»'>«escape(fmt.newName(c))»</text>'''
            )
            y = y + 1;
        }
        w.println("  </svg>")
        w.println("  <svg id='chrono' x='" + format(namesOffset + border_left + 10) + "' y='" + format(border_top) + "'>")
        
        y = 1
        for(String c : clocks) {
            w.println(
            '''    <line class='clockline' id='l_«format(y as int)»' x1='0' y1='«format(y * yscale)»' x2='«format(xMax - xMin + 1.5 * dateOffset)»' y2='«format(y * yscale)»'/>'''
            )
            yClocks.put(c, y);
            y = y + 1;
        }
        w.println(
        '''    <line class='timeline' id='timeline' x1='0' y1='«format(y * yscale)»' x2='«format(xMax - xMin + 1.5 * dateOffset)»' y2='«format(y * yscale)»'/>'''
        )
        
        for(i : 0..< theTicks.size()) {
            val Set<String> currentTicks = theTicks.get(i);
            val double date = theTags.get(i)
            val double x = date * xscale - xMin  + dateOffset

            // no decimal part if we have an "integer" number
            //System.out.println(date + "  diff=" + Math.abs(date - Math.floor(date)) + " -> " + (Math.abs(date - Math.floor(date)) < 1e2));
            val labelDate = if(Math.abs(date - Math.floor(date)) < 1e-2) {
                format(date as int);
            } else {
                format(date);
            }
            
            w.println(
            '''    <line class='tickhelper' id='h_«labelDate.replace('.', '_')»' x1='«format(x)»' y1='0.0' x2='«format(x)»' y2='«format(y * yscale)»'/>'''
            )
            
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
                w.println(
                '''    <line class='tickmark' id='m_«labelDate.replace('.', '_')»' x1='«format(x)»' y1='«format(y * yscale)»' x2='«format(x)»' y2='«format((y - 0.3) * yscale)»'/>'''
                )
                w.println(
                '''    <text class='ticklabel' id='d_«labelDate.replace('.', '_')»' x='«format(x)»' y='«format((y + 0.2) * yscale)»'>«labelDate»</text>'''
                )
            }
            
            // Print tick mark at this date on each clock timeline
            for (String c : currentTicks) {
                if (clocks.contains(c)) {
                    val Double yOfClock = yClocks.get(c);
                    if (yOfClock != null) {
                        //System.out.println("Looking for " + c + " in " + yClocks + "  //  clocks=" + clocks);
                        w.println(
                        '''    <line class='clktickmark' id='cm_«format(yOfClock.intValue())»_«labelDate.replace('.', '_')»' x1='«format(x)»' y1='«format(yOfClock * yscale)»' x2='«format(x)»' y2='«format(yOfClock * yscale - 10)»'/>'''
                        )
                    }
                }
            }
        }
        w.println("  </svg>")
        w.println("</svg>")

        w.close()
        
        if (fmt.standalone) {
            val htmlfile = new File(spec.baseName + htmlFileExtension)
            val svgFile = new File(spec.baseName)
            
            if (!htmlfile.exists || fmt.overwrite) {
                val hw = try {
                    new PrintWriter(spec.baseName + htmlFileExtension, "UTF-8")
                } catch (FileNotFoundException e) {
                    spec.console(spec.err, "## Error: could not open \"" + spec.baseName + htmlFileExtension + "\" for writing.")
                    null as PrintWriter
                } catch (UnsupportedEncodingException e) {
                    spec.console(spec.err, "## Error: UTF-8 encoding not supported.")
                    null as PrintWriter
                }
                if (hw == null) {
                    spec.console(spec.err, "## Error: No HTML standalone file written.")
                    return            
                }
            
                hw.println('''
                  <!doctype html>
                  <html>
                  <head>
                    <meta charset="utf-8">
                    <title>«svgFile.name + fileExtension»</title>
                  </head>
                  <body>
                  <object data="«svgFile.name + fileExtension»" type="image/svg+xml">
                    <p>SVG viewer needed.</p>
                  </object>
                  </body>
                  </html>
                ''')

                hw.close()
            } else {
                spec.console(spec.out, "** Not overwriting existing standalone file \"" + htmlfile.name + "\"")
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
        s.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    def void drawTick(PrintWriter w, double x, double y, String id) {
        w.println(
        '''    <line class='tickmark' id='cm_«format(x).replace('.', '_')»' x1='«format(x)»' y1='«format(y)»' x2='«format(x)»' y2='«format(y - 10)»'/>'''
        )
        
        /* Provision for labeling ticks
        String label = labeler.getLabel(id);
        if(label != null) {
            w.printf(locale, "  \\coordinate (%s) at (%.2f, %.2f);\n", label, x, -y);
        }
        */
    }
}
