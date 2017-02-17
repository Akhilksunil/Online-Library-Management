$(document).ready(function() {
    $("#regTitle").html("Hello World");

    $('.editTags').click(function() {
        // document.getElementById("editIsbn").value = this.id;
        modal.style.display = "block";
        //fill data to edit
        var Row = document.getElementById(this.id).parentElement.parentElement;
        document.getElementById("isbn").value = Row.cells[0].innerHTML;
        document.getElementById("name").value = Row.cells[1].getElementsByTagName('a')[0].innerHTML;
        document.getElementById("author").value = Row.cells[2].innerHTML;
        document.getElementById("publisher").value = Row.cells[3].innerHTML;
        document.getElementById("price").value = Row.cells[4].innerHTML;
        document.getElementById("edition").value = Row.cells[5].innerHTML;
        document.getElementById("subject").value = Row.cells[6].innerHTML;
        document.getElementById("copies").value = Row.cells[7].innerHTML;
    });
    // Get the modal
    var modal = document.getElementById('myModal');


    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
});
