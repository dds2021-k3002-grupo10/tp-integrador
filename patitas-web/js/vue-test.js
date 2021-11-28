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

const datosPersona = new Vue({
    el:'#datosPersona',
    data:{
        persona: 'hola'
    },
    created(){
        fetch('http://localhost:8080/personas/1')
        .then(response => response.json())
        .then(data =>{
            this.persona = data
        })
    }
})