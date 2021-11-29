function funcNoCopy() {
    $('.panelNoCopy').bind('copy paste', function (e) {
        e.preventDefault();
        return false;
    });
}

function home() {

    $.ajax({
        url: "view/home.html",
        async: true,
        dataType: "html",
        type: "GET",
        complete: function () {
            $('#main-menu').removeClass("mobile-is-visible");
            $('#home').addClass("active");
            $('#navegacionAjax').addClass("colorBordeLeft");
            var d = new Date();
            var strDate = d.getFullYear() + "/" + (d.getMonth() + 1) + "/" + d.getDate();
            $('.anio').html(strDate);
        },
        success: function (html) {

            $('#navegacionAjax').html("");
            $('#navegacionAjax').html(html);
            $('.abierto').removeClass("active");
            //elimina borde
            $('#navegacionAjax').removeClass("colorBordeLeftCyQ");
            $('#navegacionAjax').removeClass("colorBordeLeftEyL");
            $('#navegacionAjax').removeClass("colorBordeLeftPyC");

        }
    });
}


function registrar() {

    $.ajax({
        url: "view/registrar.html",
        async: true,
        dataType: "html",
        type: "GET",
        error: function () {
            alert("Se a producido un error");
        },
        complete: function () {
            $('#main-menu').removeClass("mobile-is-visible");

            $('#institucional').addClass("active");

            funcNoCopy();
        },
        success: function (html) {
            $('#navegacionAjax').html("");
            $('#navegacionAjax').html(html);
            $('.abierto').removeClass("active");

        }
    });
}

function adopcion() {
    $.ajax({
        url: "view/adopcion.html",
        async: true,
        dataType: "html",
        type: "GET",
        error: function () {
            alert("Se a producido un error");
        },
        complete: function () {
            $('#main-menu').removeClass("mobile-is-visible");
            $('#seccionCursos').addClass("active");

            $('#navegacionAjax').addClass("colorBordeLeftCyQ");

            funcNoCopy();
        },
        success: function (html) {
            $('#navegacionAjax').html("");
            $('#navegacionAjax').html(html);
            $('.abierto').removeClass("active");
        }
    });
}


function usuario() {
    $.ajax({
        url: "view/usuario.html",
        async: true,
        dataType: "html",
        type: "GET",
        error: function () {
            alert("Se a producido un error");
        },
        complete: function () {
            $('#main-menu').removeClass("mobile-is-visible");
            $('#formacion').addClass("active");

            $('#navegacionAjax').addClass("colorBordeLeftEyL");

            funcNoCopy();
        },
        success: function (html) {
            $('#navegacionAjax').html("");
            $('#navegacionAjax').html(html);
            $('.abierto').removeClass("active");

            $('#navegacionAjax').removeClass("colorBordeLeftCyQ");
            $('#navegacionAjax').removeClass("colorBordeLeftEyL");
            $('#navegacionAjax').removeClass("colorBordeLeftPyC");
        }
    });
}

function publicacion() {
    $.ajax({
        url: "view/publicacion.html",
        async: true,
        dataType: "html",
        type: "GET",
        error: function () {
            alert("Se a producido un error");
        },
        complete: function () {
            $('#main-menu').removeClass("mobile-is-visible");
            $('#actividades').addClass("active");

            funcNoCopy();
        },
        success: function (html) {
            $('#navegacionAjax').html("");
            $('#navegacionAjax').html(html);
        }
    });
}



function mapa() {
    jQuery('#modal-mapa .modal-content').html("");
    // $('#modal-estetica .modal-content').append('<span class = "fa fa-spin fa-circle-o-notch" >< /span>');
    jQuery('#modal-mapa').modal('show', {backdrop: 'static'});

    jQuery.ajax({
        url: "view/mapa.html",
        success: function (response)
        {

            jQuery('#modal-mapa .modal-content').html(response);
        }
    });

function auth(){
    $.ajax()

}
}





