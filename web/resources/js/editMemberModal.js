var jj = jQuery.noConflict();
jj(document).ready(function() {
    jj('.memberEditTags').click(function() {
        jj('#dialog').dialogBox({
            width: 900,
            height: 500,
            hasClose: true,
            effect: 'flip-vertical',
            title: 'Edit Member',
            content: '<div class="container"><form name="addMemberForm" id="addMemberForm" onsubmit="return(validateEditMemberForm());" action="EditMember" method="post"><table><tr><td><input type="hidden" id="id" name="id"/></td></tr><tr><td>Name:</td><td><input type="text" id="name" name="name" /></td></tr><tr><tr><td><input type="hidden" id="password" name="password"/></td></tr><tr><td><input type="hidden" id="gender" name="gender"/></td></tr><td>DOB:</td><td><input type="text" id="dob" name="dob" /></td></tr><tr><td>Address:</td><td><textarea id="address" name="address" style="width:300px; height:100px;"></textarea></td></tr><tr><td>Contact:</td><td><input type="text" id="contact" name="contact" /></td></tr><tr><td hidden>copies<td><td><input  class="btn btn-default" type="submit" value="Update Member" /></td></tr></table></form></div>'
        });
        // set date for dob
        new JsDatePick({
            useMode: 2,
            target: "dob",
            dateFormat: "%Y-%m-%d"
        });
        // fill already existing data
        var Row = document.getElementById(this.id).parentElement.parentElement;
        document.getElementById("id").value = Row.cells[0].innerHTML;
        document.getElementById("name").value = Row.cells[1].innerHTML;
        document.getElementById("password").value = Row.cells[2].innerHTML;
        document.getElementById("gender").value = Row.cells[3].innerHTML;
        document.getElementById("dob").value = Row.cells[4].innerHTML;
        document.getElementById("address").value = Row.cells[5].innerHTML;
        document.getElementById("contact").value = Row.cells[6].innerHTML;
    })

});



