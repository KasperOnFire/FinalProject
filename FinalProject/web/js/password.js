$('#password1, #password2').on('keyup', function () {
    if ($('#password1').val() == $('#password2').val() && $('#password1').val().length > 5) {
        $('#bt1').attr('disabled', false);
    } else 
        $("#bt1").attr("disabled", true);
});