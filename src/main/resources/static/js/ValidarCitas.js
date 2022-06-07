const fecha=document.getElementById("fecha");
const hora=document.getElementById("hora");
const plataforma=document.getElementById("plataforma");
const form = document.getElementById("formulario");
const parrafo = document.getElementById("warnings");

form.addEventListener("submit", e=>{
    e.preventDefault();
    let warnings = "";
    let entrar = false;
    parrafo.innerHTML = "";
    
    if(fecha.value.length<=0){
        warnings += `El campo de fecha no puede estar vacio <br>`;
        entrar = true;
    }

    if(hora.value.length<=0){
        warnings += `El campo de hora no puede estar vacio <br>`;
        entrar = true;
    }

    if(plataforma.value.length<=0){
        warnings += `El campo de plataforma no puede estar vacio <br>`;
        entrar = true;
    }
    
    if(entrar){
        parrafo.innerHTML = warnings
    }else{
        e.currentTarget.submit();
    }
})

