  $(document).tooltip();
  $(document).ready(function() {
      //string
      var nameList = document.getElementById("bookNames").innerHTML;
      // remove preceeding spaces
      nameList = nameList.replace(/^[,\s]+|[,\s]+$/g, '');
      nameList = nameList.replace(/\s*,\s*/g, ',');
      var names = nameList.slice(1, -1).split(',');
      console.log(names);
      var jsonData = createJson(names);
      console.log("on load ");
      console.log(jsonData);

      $('.not-active').mouseover(function() {
          var name = document.getElementById(this.id).innerHTML;
          console.log(this.id);
          document.getElementById(this.id).title = jsonData[name];
      });
  });

  function createJson(names) {
      var jsonData = {};
      names.forEach(function(name) {
          getContent(name).done(function(a) {
              // console.log(name + "--->" + refineText(a));
              jsonData[name] = refineText(a)
          });
      });
      // for logging
      //    console.log("inside create");
      //    console.log(jsonData);

      return jsonData;
  }

  function getContent(searchTerm) {
      return $.ajax({
          type: "GET",
          url: "https://en.wikipedia.org/w/api.php?action=parse&format=json&prop=text&section=0&page=" + searchTerm + "&callback=?",
          contentType: "application/json; charset=utf-8",
          async: false,
          dataType: "json",
          success: function(data, textStatus, jqXHR) {},
          error: function(errorMessage) {}
      });
      // return content;
  }

  function refineText(data) {
      var markup = data.parse.text["*"];
      var blurb = $('<div></div>').html(markup);
      // remove links as they will not work
      blurb.find('a').each(function() {
          $(this).replaceWith($(this).html());
      });
      // remove any references
      blurb.find('sup').remove();
      // remove cite error
      //     blurb.find('.mw-ext-cite-error').remove();
      var content = $(blurb).find('p').text();
      //    $('#article').html($(blurb).find('p'));
      if (content.localeCompare("Redirect to:") == 0)
          content = "Description not available now.";
      return content;
  }
