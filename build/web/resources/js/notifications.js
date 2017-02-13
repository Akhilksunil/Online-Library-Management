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