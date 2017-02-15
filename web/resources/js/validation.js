
function validateMemberForm() {
    if (document.addMemberForm.name.value === "") {
        error("Invalid name");
        document.addMemberForm.name.focus();
        return false;
    }
    if (document.addMemberForm.password.value === "" || document.addMemberForm.password.value.length < 8) {
        error("Invalid password, 8 characters needed");
        document.addMemberForm.password.focus();
        return false;
    }
    if (document.addMemberForm.dob.value === "" || isInvalidDate(document.addMemberForm.dob.value)) {
        error("Invalid date of birth");
        document.addMemberForm.dob.focus();
        return false;
    }
    if (document.addMemberForm.address.value === "") {
        error("Invalid address");
        document.addMemberForm.address.focus();
        return false;
    }
    if (document.addMemberForm.contact.value === "" || isNaN(document.addMemberForm.contact.value) || document.addMemberForm.contact.value.length < 10) {
        error("Invalid contact");
        document.addMemberForm.contact.focus();
        return false;
    }
}

function validateBookForm() {
    if (document.addBookForm.isbn.value === "") {
        error("Invalid book isbn");
        document.addBookForm.isbn.focus();
        return false;
    }
    if (document.addBookForm.name.value === "") {
        error("Invalid book name!");
        document.addBookForm.name.focus();
        return false;
    }
    if (document.addBookForm.author.value === "") {
        error("Invalid book author!");
        document.addBookForm.author.focus();
        return false;
    }
    if (document.addBookForm.publisher.value === "") {
        error("Invalid book publisher!");
        document.addBookForm.publisher.focus();
        return false;
    }
    if (document.addBookForm.price.value === "" || isNaN(document.addBookForm.price.value) || document.addBookForm.price.value < 0) {
        error("Invalid valid price!");
        document.addBookForm.price.focus();
        return false;
    }
    if (document.addBookForm.edition.value === "") {
        error("Invalid book edition!");
        document.addBookForm.edition.focus();
        return false;
    }

    if (document.addBookForm.subject.value === "") {
        error("Invalid book subject!");
        document.addBookForm.subject.focus();
        return false;
    }

    if (document.addBookForm.copies.value === "" || isNaN(document.addBookForm.copies.value) || document.addBookForm.copies.value < 0) {
        error("Invalid copy count!");
        document.addBookForm.copies.focus();
        return false;
    }
}

function validateGrantForm() {
    if (document.addGrantForm.issue_date.value === "" || isInvalidDate(document.addGrantForm.issue_date.value)) {
        error("Invalid book Issue Date!");
        document.addGrantForm.issue_date.focus();
        return false;
    }
    if (document.addGrantForm.return_date.value === "" || isInvalidDate(document.addGrantForm.return_date.value)) {
        error("Invalid book Return Date!");
        document.addGrantForm.return_date.focus();
        return false;
    }
    if (document.addGrantForm.expiry_date.value === "" || isInvalidDate(document.addGrantForm.expiry_date.value)) {
        error("Invalid book Expiry Date!");
        document.addGrantForm.expiry_date.focus();
        return false;
    }
}
function isInvalidDate(dateString) {
  var regEx = /^\d{4}-\d{2}-\d{2}$/;
  return dateString.match(regEx) == null;
}

