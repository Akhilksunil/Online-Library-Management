function error(err) {
    var notyf = new Notyf({
        delay: 1500
    })
    notyf.alert(err);
}

function success(msg) {
    var notyf = new Notyf({
        delay: 1500
    })
    notyf.confirm(msg);
}
function deleteRequest(id, isbn)
{
	message();
    $("#cancel").click(function() {
        hide();
    });
    $("#delete").click(function() {
        hide();
        window.location="DeleteRequest?memberId=" + id + "&isbn=" + isbn ;
    });
}
function deleteBook(isbn)
{
	console.log(isbn)
	message();
    $("#cancel").click(function() {
        hide();
    });
    $("#delete").click(function() {
        hide();
        window.location="DeleteBook?isbn=" + isbn ;
    });
}
function deleteMember(id)
{
	console.log(id)
	message();
    $("#cancel").click(function() {
        hide();
    });
    $("#delete").click(function() {
        hide();
        window.location="DeleteMember?id=" + id ;
    });
}
function returnBook(id, isbn)
{
	console.log("hello")
	message();
    $("#cancel_confirm").click(function() {
        hide();
    });
    $("#confirm").click(function() {
        hide();
        window.location="ReturnBook?memberId=" + id + "&isbn=" + isbn ;
    });
}
function message() {
    $("#confirm_message").slideDown();

    $("#delete_message").slideDown();
}

function hide() {
    $("#confirm_message").slideUp();

    $("#delete_message").slideUp();
}
