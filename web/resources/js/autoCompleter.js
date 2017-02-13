$(document).ready(function() {
    $(function() {
        var input = document.getElementById("search");
        var nameList = document.getElementById("bookNames").innerHTML;
        var result = nameList.slice(1, -1);
        new Awesomplete(input, {
            list: result
        });
        Awesomplete.$.bind(input, {
            "awesomplete-selectcomplete": function(evt) {
                document.getElementById("searchButton").click()
                // alert(evt.text); // String {label: "Java", value: "Java", valueOf: function, toString: function}
            }
        });
    });
});
