var mensajeError = '<div class="alert alert-danger"><strong>!</strong> Ocurrio un error en la busqueda.</div>';
var mensajeSinDatos = '<div class="alert alert-info"> No se encontr&oacute datos en la busqueda.</div>'
var mensajeFormVacio = '<div class="alert alert-white">Ingrese datos en el formulario para hacer una busqueda.</div>'

function buscarConEnter(e) {
    var enter = e.keyCode || e.which;
    if (enter == 13) {
        busquedaPersona();
    }
}

$('.solo-numero').keyup(function () {
    this.value = (this.value + '').replace(/[^0-9]/g, '');
});

function resetformBusqueda() {
    $("#formBuscaPersonaGrupo select").each(function () {
        this.selectedIndex = 0
    });
    $("form input[type=text]").each(function () {
        this.value = ''
    });
}

function formEstaVacio() {
    var cont = 0
    $("#formBuscaPersonaGrupo input").each(function (index, element) {
        if ($(element).val().length > 0) {
            cont = cont + 1;
        }
    });

    $("#formBuscaPersonaGrupo select").each(function (index, element) {
        if ($(element).val().length > 0) {
            cont = cont + 1;
        }
    });
    if (cont > 0) {
        return false;
    } else {
        return true;
    }
    ;
}


function mostrarGrupoPersona() {

    if ($("#grupoSelect").val() != "") {
        $.ajax({
            url: "./view/admin/persona/ajax/ajaxTablaPersonaInstitucional.php",
            data: "idGrupoSelect=" + $("#grupoSelect").val(),
            dataType: "html",
            type: 'post',
            beforeSend: function () {
                $("#tablaPersonaInstitucional").html('');
            },
            success: function (response) {
                $("#tablaPersonaInstitucional").html(response);
            }

        });

    } else {

        alert("Seleccione un grupo")
    }

}


function altaGrupoPersona() {
    if ($("#grupoSelect").val() !== "") {

        $.ajax({
            url: "./view/admin/persona/ajax/ajaxBuscaPersona.php",
            data: "idGrupoSelect=" + $("#grupoSelect").val() + "&textSelected=" + $("#grupoSelect option:selected").text(),
            dataType: "html",
            type: 'post',
            beforeSend: function () {
                $('#modal-buscaPersona .modal-content').html("");
                $('#modal-buscaPersona').modal('show', {backdrop: 'static'});
            },
            success: function (response) {
                $('#modal-buscaPersona .modal-content').html(response);
            }

        });

    } else {

        alert("Seleccione un grupo")
    }
}


function busquedaPersona() {
    var ckblike = "false";
    if ($('#ckbpersonalike').prop('checked')) {
        ckblike = "true";
    }
    if (formEstaVacio() === false) {
        $.ajax({
            url: "./view/admin/persona/ajax/ajaxListadoPersona.php",
            data: "nombre=" + $('#nombre').val() + "&otroNombre=" + $('#otroNombre').val() + "&apellido=" + $('#apellido').val() + "&otroApellido=" + $('#otroApellido').val() + "&tipoDocumento=" + $('#tipoDocumento').val() + "&numeroDocumento=" + $('#numeroDocumento').val() + "&idGrupoSelect=" + $("#grupoSelect").val() + "&ckblike=" + ckblike,
            async: true,
            dataType: "html",
            timeout: 60000,
            type: "GET",
            beforeSend: function () {
                $('#listaPersona').html("");
                $('#flotDiv').fadeIn("slow");
            },
            error: function () {
                $('#listaPersona').html(mensajeError);
                $('#flotDiv').fadeOut("slow");
            },
            complete: function () {
            },
            success: function (html) {
                $('#flotDiv').fadeOut("slow");
                var texto = $.trim($(html).text());

                if (texto == "") {
                    $('#listaPersona').html(mensajeSinDatos);
                } else {
                    resetformBusqueda();
                    $('#listaPersona').append('<div id="tablaVirtual"></div>');
                    $('#tablaVirtual').append($(html));
                }
            }

        });
    } else {
        $('#tablaPersona').html(mensajeFormVacio);
    }
}

function altaPersonaPorGrupo(idPersona, idGrupo) {

    $.ajax({
        url: "./view/admin/persona/ajax/ajaxAltaPersonaInstitucional.php",
        data: "idPersona=" + idPersona + "&idGrupo=" + idGrupo,
        dataType: "html",
        type: 'post',
        beforeSend: function () {
        },
        success: function (response) {

            $(".close").click();
            mostrarGrupoPersona();
        }

    });

}