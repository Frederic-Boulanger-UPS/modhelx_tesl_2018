package fr.supelec.tesl.lang.ui.run;

import com.google.common.base.Objects;
import fr.supelec.tesl.core.Clock;
import fr.supelec.tesl.core.ClockSet;
import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.Let;
import fr.supelec.tesl.lang.tesl.Pragma;
import fr.supelec.tesl.lang.tesl.Relation;
import fr.supelec.tesl.lang.tesl.Specification;
import fr.supelec.tesl.lang.ui.run.ConsoleLogHandler;
import fr.supelec.tesl.lang.ui.run.OutputFormat;
import fr.supelec.tesl.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class TESLSpec {
  private final XtextResourceSet resourceSet;
  
  private final String fileName;
  
  private final URI uri;
  
  private final String osfile;
  
  private final String baseName;
  
  private final Resource resource;
  
  private final Specification specification;
  
  private final HashMap<String, Expression> letValues = new HashMap<String, Expression>();
  
  private final ClockSet clockSet = new ClockSet();
  
  private final HashMap<String, Clock<?>> clocks = new HashMap<String, Clock<?>>();
  
  private final LinkedList<String> orderedClockNames = new LinkedList<String>();
  
  private final HashMap<String, OutputFormat> outputFormats = new HashMap<String, OutputFormat>();
  
  private final ArrayList<Set<String>> ticks = new ArrayList<Set<String>>();
  
  private final ArrayList<Double> tags = new ArrayList<Double>();
  
  private Logger clockLogger = this.clockSet.getLogger();
  
  private MessageConsoleStream out;
  
  private MessageConsoleStream err;
  
  private MessageConsoleStream header;
  
  private final String CONSOLE_NAME = "TESL Console";
  
  private PrintStream logStream;
  
  @Accessors
  private IFile infile;
  
  @Accessors
  private File logFile;
  
  @Accessors
  private int maxSimSteps;
  
  @Accessors
  private MessageConsole console;
  
  @Accessors
  private Clock<?> tagRefClock = null;
  
  @Accessors
  private Clock<?> stopClock = null;
  
  @Accessors
  private boolean dumpResult = false;
  
  public TESLSpec(final XtextResourceSet resourceSet, final String fileName, final int maxSteps) {
    try {
      this.resourceSet = resourceSet;
      this.fileName = fileName;
      this.maxSimSteps = maxSteps;
      this.uri = URI.createURI(fileName);
      IWorkspaceRoot _root = ResourcesPlugin.getWorkspace().getRoot();
      Path _path = new Path(fileName);
      this.infile = _root.getFile(_path);
      this.resource = resourceSet.getResource(this.uri, true);
      EList<EObject> _contents = null;
      if (this.resource!=null) {
        _contents=this.resource.getContents();
      }
      EObject _get = _contents.get(0);
      this.specification = ((Specification) _get);
      this.osfile = this.infile.getRawLocation().toOSString();
      String _xifexpression = null;
      boolean _endsWith = this.osfile.endsWith(".tesl");
      if (_endsWith) {
        int _length = this.osfile.length();
        int _minus = (_length - 5);
        _xifexpression = this.osfile.substring(0, _minus);
      } else {
        _xifexpression = new String(this.osfile);
      }
      this.baseName = _xifexpression;
      File _file = new File((this.baseName + ".tlog"));
      this.logFile = _file;
      this.infile.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      this.setupConsole();
      this.setupLogger();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public PrintStream unload() {
    PrintStream _xifexpression = null;
    boolean _notEquals = (!Objects.equal(this.resource, null));
    if (_notEquals) {
      this.resource.unload();
    } else {
      _xifexpression = this.consoleOnly(this.err, "Could not unload resource, changes may not be taken into account.");
    }
    return _xifexpression;
  }
  
  public String getBaseName() {
    return this.baseName;
  }
  
  public OutputFormat outputFormat(final String name) {
    OutputFormat _xifexpression = null;
    boolean _containsKey = this.outputFormats.containsKey(name);
    if (_containsKey) {
      _xifexpression = this.outputFormats.get(name);
    } else {
      final OutputFormat fmt = new OutputFormat(name);
      this.outputFormats.put(name, fmt);
      return fmt;
    }
    return _xifexpression;
  }
  
  public Set<String> getOutputFormats() {
    return this.outputFormats.keySet();
  }
  
  public EList<Let> getLetDecls() {
    return this.specification.getLet();
  }
  
  public EList<fr.supelec.tesl.lang.tesl.Clock> getClockDecls() {
    return this.specification.getDecl();
  }
  
  public EList<Relation> getRelDecls() {
    return this.specification.getRel();
  }
  
  public EList<Pragma> getPragmaDecls() {
    return this.specification.getPragmas();
  }
  
  public String getOsfile() {
    return this.osfile;
  }
  
  public Set<String> getLetValueNames() {
    return this.letValues.keySet();
  }
  
  public Expression getLetValue(final String name) {
    return this.letValues.get(name);
  }
  
  public Expression setLetValue(final String name, final Expression e) {
    return this.letValues.put(name, e);
  }
  
  public boolean addClock(final String name, final Clock<?> clock) {
    boolean _xblockexpression = false;
    {
      this.clockSet.addClock_erased(clock);
      this.clocks.put(name, clock);
      _xblockexpression = this.orderedClockNames.add(name);
    }
    return _xblockexpression;
  }
  
  public HashMap<String, Clock<?>> getClocks() {
    return this.clocks;
  }
  
  public LinkedList<String> getOrderedClockNames() {
    return this.orderedClockNames;
  }
  
  public ClockSet getClockSet() {
    return this.clockSet;
  }
  
  public Clock<?> getClock(final String name) {
    return this.clocks.get(name);
  }
  
  public boolean addTicks(final Set<String> tickSet) {
    return this.ticks.add(tickSet);
  }
  
  public ArrayList<Set<String>> getTicks() {
    return this.ticks;
  }
  
  public boolean addTag(final double t) {
    return this.tags.add(Double.valueOf(t));
  }
  
  public ArrayList<Double> getTags() {
    return this.tags;
  }
  
  public void setupLogger() {
    try {
      this.clockLogger.getHandlers().clear();
      PrintStream _printStream = new PrintStream(this.logFile);
      this.logStream = _printStream;
      final ConsoleLogHandler logHandler = new ConsoleLogHandler(this);
      this.getLogger().addHandler(logHandler);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void log(final String msg) {
    this.logStream.println(msg);
  }
  
  public PrintStream closeLog() {
    PrintStream _xblockexpression = null;
    {
      this.logStream.close();
      _xblockexpression = this.logStream = null;
    }
    return _xblockexpression;
  }
  
  public Logger getLogger() {
    return this.clockLogger;
  }
  
  public void setupConsole() {
    this.console = this.findConsole();
    this.console.clearConsole();
    this.out = this.console.newMessageStream();
    this.err = this.console.newMessageStream();
    this.header = this.console.newMessageStream();
    final IWorkbench wb = PlatformUI.getWorkbench();
    final Display display = wb.getDisplay();
    final Runnable _function = new Runnable() {
      public void run() {
        Color _color = new Color(display, 220, 0, 0);
        TESLSpec.this.err.setColor(_color);
        Color _color_1 = new Color(display, 40, 0, 200);
        TESLSpec.this.header.setColor(_color_1);
        TESLSpec.this.header.setFontStyle(SWT.BOLD);
      }
    };
    display.syncExec(_function);
  }
  
  public MessageConsoleStream getOut() {
    return this.out;
  }
  
  public MessageConsoleStream getErr() {
    return this.err;
  }
  
  public MessageConsoleStream getHeader() {
    return this.header;
  }
  
  private MessageConsole findConsole() {
    final String name = this.CONSOLE_NAME;
    final ConsolePlugin plugin = ConsolePlugin.getDefault();
    final IConsoleManager conMan = plugin.getConsoleManager();
    IConsole[] _consoles = conMan.getConsoles();
    for (final IConsole iconsole : _consoles) {
      String _name = iconsole.getName();
      boolean _equals = Objects.equal(name, _name);
      if (_equals) {
        return ((MessageConsole) iconsole);
      }
    }
    final MessageConsole myConsole = new MessageConsole(name, null);
    conMan.addConsoles(new IConsole[] { myConsole });
    final Runnable _function = new Runnable() {
      public void run() {
        final IWorkbenchWindow win = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        final IWorkbenchPage page = win.getActivePage();
        boolean _notEquals = (!Objects.equal(page, null));
        if (_notEquals) {
          final String id = IConsoleConstants.ID_CONSOLE_VIEW;
          try {
            IViewPart _showView = page.showView(id);
            final IConsoleView view = ((IConsoleView) _showView);
            view.display(myConsole);
          } catch (final Throwable _t) {
            if (_t instanceof PartInitException) {
              final PartInitException e = (PartInitException)_t;
              e.printStackTrace();
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
    };
    Display.getDefault().syncExec(_function);
    return myConsole;
  }
  
  public PrintStream consoleOnly(final MessageConsoleStream s, final String msg) {
    PrintStream _xblockexpression = null;
    {
      final PrintStream oldLog = this.logStream;
      this.logStream = null;
      this.console(s, msg);
      _xblockexpression = this.logStream = oldLog;
    }
    return _xblockexpression;
  }
  
  public void console(final MessageConsoleStream s, final String msg) {
    s.println(msg);
    try {
      s.flush();
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    boolean _notEquals = (!Objects.equal(this.logStream, null));
    if (_notEquals) {
      this.logStream.println(msg);
    }
  }
  
  public void reportError(final int line, final String msg) throws CoreException {
    final IMarker m = this.infile.createMarker(IMarker.PROBLEM);
    m.setAttribute(IMarker.LINE_NUMBER, line);
    m.setAttribute(IMarker.MESSAGE, msg);
    m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
    m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
    this.console(this.err, ((("# Error at line " + Integer.valueOf(line)) + ": ") + msg));
  }
  
  public void reportError(final EObject faultyASTNode, final String msg) throws CoreException {
    this.reportError(NodeModelUtils.getNode(faultyASTNode).getStartLine(), msg);
  }
  
  @Pure
  public IFile getInfile() {
    return this.infile;
  }
  
  public void setInfile(final IFile infile) {
    this.infile = infile;
  }
  
  @Pure
  public File getLogFile() {
    return this.logFile;
  }
  
  public void setLogFile(final File logFile) {
    this.logFile = logFile;
  }
  
  @Pure
  public int getMaxSimSteps() {
    return this.maxSimSteps;
  }
  
  public void setMaxSimSteps(final int maxSimSteps) {
    this.maxSimSteps = maxSimSteps;
  }
  
  @Pure
  public MessageConsole getConsole() {
    return this.console;
  }
  
  public void setConsole(final MessageConsole console) {
    this.console = console;
  }
  
  @Pure
  public Clock<?> getTagRefClock() {
    return this.tagRefClock;
  }
  
  public void setTagRefClock(final Clock<?> tagRefClock) {
    this.tagRefClock = tagRefClock;
  }
  
  @Pure
  public Clock<?> getStopClock() {
    return this.stopClock;
  }
  
  public void setStopClock(final Clock<?> stopClock) {
    this.stopClock = stopClock;
  }
  
  @Pure
  public boolean isDumpResult() {
    return this.dumpResult;
  }
  
  public void setDumpResult(final boolean dumpResult) {
    this.dumpResult = dumpResult;
  }
}
