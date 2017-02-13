// Create the tooltips only when document ready
$(document).ready(function() {
  $('.not-active').mouseover(function() {
    var searchTerm = document.getElementById(this.id).innerHTML;

		var obj = this.id;
    var content="";
    //  var searchTerm = "president";
    if(document.getElementById(obj).title=="")
      document.getElementById(obj).title = "Loading...";
    $.ajax({
      type: "GET",
      url: "http://en.wikipedia.org/w/api.php?action=parse&format=json&prop=text&section=0&page=" + searchTerm + "&callback=?",
      contentType: "application/json; charset=utf-8",
      async: false,
      dataType: "json",
      success: function(data, textStatus, jqXHR) {

        var markup = data.parse.text["*"];

        var blurb = $('<div></div>').html(markup);
        //		alert(blurb);
        // remove links as they will not work
        blurb.find('a').each(function() {
          $(this).replaceWith($(this).html());
        });

        // remove any references
        blurb.find('sup').remove();

        // remove cite error
   //     blurb.find('.mw-ext-cite-error').remove();
				 content = $(blurb).find('p').text();
    //    $('#article').html($(blurb).find('p'));
        if(content.localeCompare("Redirect to:")==0)
          content = "Description not available now.";
				document.getElementById(obj).title = content;
    		$('a[title]').qtip();
      },
      error: function(errorMessage) {
      	document.getElementById(obj).title = "Non Found";
    		$('a[title]').qtip();
      }
    });
  });
});

