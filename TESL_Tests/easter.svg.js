(function() {
  var svgns = "http://www.w3.org/2000/svg";
  
  // Add 15 pixel to the height of the viewBox to make the new labels visible
  function updateViewBox(svg) {
    var vbox = svg.getAttribute("viewBox");
    if (vbox != null) {
      var dims = vbox.split(" ");
      var h = parseFloat(dims[3]);
      h = h + 15
      svg.setAttribute("viewBox", dims[0] + " " + dims[1] + " " + dims[2] + " " + h);
    }
  };
  
  // Add some text below a date tag on the time line
  function addTextLabel(tag, text) {
    // Create a new text SVG element
    var label = document.createElementNS(svgns, "text");
    // Set it to the same horizontal position as the tag label
    label.setAttribute("x", tag.getAttribute("x"));
    // Put it 15 pixels below the tag label
    label.setAttribute("y", parseFloat(tag.getAttribute("y")) + 15);
    // Give it the same class as the tag label
    label.setAttribute("class", tag.getAttribute("class"));
    // Make it display in bold with a 70% font size
    label.setAttribute("font-weight", "bold");
    label.setAttribute("style", "font-size:70%");
    // Create a text node with the given text and add it as a child of the text SVG element
    label.appendChild(document.createTextNode(text));
    // Add the text element to the parent of the tag (so it is a sibling of the tag)
    tag.parentNode.appendChild(label);
  };
  
  // When the document is loaded, add text to show the date under the 
  // two occurrences of Easter in the model
  window.addEventListener("load", function(evt) {
    // Get the root SVG element of the document
    var svg = document.documentElement;
    // Label for Easter on April 20 2014
    addTextLabel(svg.getElementById("d_110"), "April 20 2014");
    // Label for Easter on April 5 2015
    addTextLabel(svg.getElementById("d_460"), "April 5 2015");
    // Update viewBox for added height
    updateViewBox(svg);
  });
}());
