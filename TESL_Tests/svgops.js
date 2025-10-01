$(function() {
  $("object").each(function() {
    console.log("Hello")
    console.log($(this))
    $(this).css("font-size", "25%")
  })
});