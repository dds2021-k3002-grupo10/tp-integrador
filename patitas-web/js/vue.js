const app = new Vue({
    el:'#idCajaOrganizacion',
    data:{
        organizaciones: []
    },
    created(){
        fetch('http://localhost:8080/organizacion/all')
            .then(response => response.json())
            .then(data =>{
                this.organizaciones = data
            })
    }
})