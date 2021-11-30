function registrarAltaMascota(ss) {
    /*inicializo variable global*/
    tipoDocumentoAlta = "";
    nroDocumentoAlta = "";
    /*fin de inicializar variable global*/
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