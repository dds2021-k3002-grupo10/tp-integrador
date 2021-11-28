const mascotas-persona = new Vue({
    el:'#mascotas-persona',
    data:{
        mascotas: []
    },
    created(){
        fetch('http://localhost:8080/mascota/all')
            .then(response => response.json())
            .then(data =>{
                this.mascotas = data
            })
    }
})