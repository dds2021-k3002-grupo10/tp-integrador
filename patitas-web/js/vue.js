const app = new Vue({
    el:'#idCajaOrganizacion',
    data:{
        organizaciones: [],
        nombre:'alex'
    },
    created(){
        fetch('http://localhost:8080/organizacion/all')
            .then(response => response.json())
            .then(data =>{
                this.organizaciones = data
            })
    },
    methods: {

        saludar:function (id){
            localStorage.setItem("IDORGANIZACION", id) //guarda ID
            $(location).attr('href','principal-nav.html')
           /* $.ajax({
                url: "principal.html",
                async: true,
                dataType: "html",
                type: "GET",
                complete: function () {
                },
                success: function (html) {

                 $('#navegacionAjax').html("");
                 $('#navegacionAjax').html(html);

                }
            });*/
        }
    }
})