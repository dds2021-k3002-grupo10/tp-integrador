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
function registrarAltaSoloMascota() {

    $.ajax({
        url: "view/modaRegistrar/registrar-solo-mascotas.html",
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
