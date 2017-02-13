$(function(){
    document.getElementById("risposta").onchange = function(e) {
       $.growl({
        message: 'Test.'
    }, {
        position: {
            from: "bottom",
            align: "left"
        },
        delay: 1000000
    });
    };
});

function validateMemberForm() {
    if (document.addMemberForm.name.value === "") {
        alert("Please provide your name!");
        document.addMemberForm.name.focus();
        return false;
    }
    if (document.addMemberForm.password.value === "" || document.addMemberForm.password.value.length < 8) {
        alert("Please provide password of atleast 8 characters!");
        document.addMemberForm.password.focus();
        return false;
    }
    if (document.addMemberForm.dob.value === "") {
        alert("Please provide your date of birth!");
        document.addMemberForm.dob.focus();
        return false;
    }
    if (document.addMemberForm.address.value === "") {
        alert("Please provide your address!");
        document.addMemberForm.address.focus();
        return false;
    }
    if (document.addMemberForm.contact.value === "" || isNaN(document.addMemberForm.contact.value) || document.addMemberForm.contact.value.length < 10) {
        alert("Please provide valid contact!");
        document.addMemberForm.contact.focus();
        return false;
    }
    // alert("Member Added Successfully");
}

function validateBookForm() {
	if (document.addBookForm.isbn.value === "") {
        alert("Please provide book isbn!");
        document.addBookForm.isbn.focus();
        return false;
    }
	if (document.addBookForm.name.value === "") {
        alert("Please provide book name!");
        document.addBookForm.name.focus();
        return false;
    }
    if (document.addBookForm.author.value === "") {
        alert("Please provide book author!");
        document.addBookForm.author.focus();
        return false;
    }
    if (document.addBookForm.publisher.value === "") {
        alert("Please provide book publisher!");
        document.addBookForm.publisher.focus();
        return false;
    }
    if (document.addBookForm.price.value === "" || isNaN(document.addBookForm.price.value) || document.addBookForm.price.value < 0) {
        alert("Please provide valid price!");
        document.addBookForm.price.focus();
        return false;
    }
    if (document.addBookForm.edition.value === "") {
        alert("Please provide book edition!");
        document.addBookForm.edition.focus();
        return false;
    }
    
    if (document.addBookForm.subject.value === "") {
        alert("Please provide book subject!");
        document.addBookForm.subject.focus();
        return false;
    }
    
    if (document.addBookForm.copies.value === "" || isNaN(document.addBookForm.copies.value) || document.addBookForm.copies.value < 0) {
        alert("Please provide valid copies!");
        document.addBookForm.copies.focus();
        return false;
    }
    alert("Book Added Successfully");
}
function validateGrantForm() {
    if (document.addGrantForm.issue_date.value === "") {
        alert("Please provide book Issue Date!");
        document.addGrantForm.issue_date.focus();
        return false;
    }
    if (document.addGrantForm.return_date.value === "") {
        alert("Please provide book Return Date!");
        document.addGrantForm.return_date.focus();
        return false;
    }
    if (document.addGrantForm.expiry_date.value === "") {
        alert("Please provide book Expiry Date!");
        document.addGrantForm.expiry_date.focus();
        return false;
    }
    alert("Book Granted Successfully");

}