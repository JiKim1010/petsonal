/*ESERCIZIO:
Creare un hamburger menu con l’utilizzo di Html, Css e JavaScript.*/


$(document).ready(function(){
  $(".nav-menu > a").click(function() {
    $(".hamburger-menu").addClass("active");
  });

  // cliccando sulla X si chiude il menù
  $(".close").click(function() {
    $(".hamburger-menu").removeClass("active");
  });

});


