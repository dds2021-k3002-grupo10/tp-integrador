function registrarAltaMascota(ss) {

    $.ajax({
        url: "view/modaRegistrar/registrar-mascota.html",
        async: true,
        dataType: "html",
        type: "GET",
        complete: function () {
        },
        success: function (html) {
            $('#navegacionAjax').html("");
            $('#navegacionAjax').html(html);

        }
    });
}