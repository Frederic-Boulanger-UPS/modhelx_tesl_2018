package fr.supelec.tesl.lang.ui.run

import java.util.HashMap
import java.util.LinkedList
import java.util.List
import java.util.Set

//* A clipping window for the output of ticks
class TickWindow {
    @Property double from
    @Property double to

    new(double from, double to) {
        this.from = from;
        this.to = to;
    }
}

//* Interface of all output format handlers
interface OutputFormatHandler {
    //* Write the spec according to format fmt
    def void write(TESLSpec spec, OutputFormat fmt)
}

//* Output format for TESL simulations
class OutputFormat {
    //* Map from format names to format handlers
    static val handlers = new HashMap<String, OutputFormatHandler>()
    //* Name of the output format
    val String name
    //* Selected clocks to display (display all clocks if empty)
    val selection = new LinkedList<String>()
    //* Map from clock names to the names to display in the output
    val renames = new HashMap<String, String>()
    //* Display window (lower/upper bound of tags)
    var TickWindow window = null
    //* List of clock names which trigger a label when they have a tick
    val labelIf = new LinkedList<String>()
    @Property double xscale = 1.0
    @Property boolean standalone = false
    @Property boolean overwrite = false
    @Property boolean nodefcss = false
    @Property String borders = null
    @Property String css = null
    @Property String jvs = null

    new (String name) {
        this.name = name.toLowerCase
        xscale = switch (this.name) {
            case "tikz": 1.0
            case "svg" : 50.0
            default: 1.0
        }
    }

    //* Register a handler for a format name
    static def register(String fmtName, OutputFormatHandler handler) {
        handlers.put(fmtName.toLowerCase(), handler)
    }
    //* Get the handler for a format name
    static def getHandler(String fmtName) {
        handlers.get(fmtName.toLowerCase())
    }
    def getName() {
        this.name
    }
    //* Clear the list of clocks selected for display
    def clearSelection() {
        selection.clear()
    }
    //* Add a clock to the selection of clocks to display
    def addToSelection(String name) {
        selection.add(name)
    }
    //* Get the list of clocks to display
    def getSelection() {
        return selection
    }
    //* Rename a clock for display
    def renameClock(String oldName, String newName) {
        renames.put(oldName, newName)
    }
    //* Tell if a clock is renamed for display
    def isRenamed(String name) {
        renames.containsKey(name)
    }
    //* Get the display name of a clock (either its name or its new display name)
    def newName(String name) {
        val newName = renames.get(name)
        if (newName == null) {
            name
        } else {
            newName
        }
    }
    //* Set the display window for ticks
    def setTickWindow(double from, double to) {
        window = new TickWindow(from , to)
    }
    //* Get the display window for ticks
    def getTickWindow() {
        this.window
    }
    //* Put the ticks and tags to display according to spec in the ticks and tags lists
    def clipToWindow(TESLSpec spec, List<Set<String>> ticks, List<Double> tags) {
        var minTag = Double::NEGATIVE_INFINITY
        var maxTag = Double::POSITIVE_INFINITY
        if (tickWindow != null) {
            minTag = tickWindow.from
            maxTag = tickWindow.to
        }

        for (i : 0..< spec.ticks.size) {
            val tag = spec.tags.get(i)
            if (tag >= minTag && tag <= maxTag) {
                ticks.add(spec.ticks.get(i))
                tags.add(tag)
            }
        }
    }
    //* Add a clock to the list of label triggering clocks
    def addLabelIf(String name) {
        labelIf.add(name)
    }
    //* Get the list of label triggering clocks
    def getLabelIf() {
        this.labelIf
    }
}
