function soloNumeros(evt) {
    if(window.event) {
        keynum = evt.keyCode;
    } else {
        keynum = evt.which;
    }
    
    if(keynum > 47 && keynum < 58 || keynum == 8 || keynum == 13) {
        return true;
    } else {
        alert("Digitar solo numeros, por favor");
        return false;
    }
}


const nombre = document.getElementById("name");
const email = document.getElementById("email");
const usuario=document.getElementById("usuario");
const pass = document.getElementById("clave");
const tipoDocumento = document.getElementById("tipoDocumento");
const numeroDocumento = document.getElementById("numeroDocumento");
const form = document.getElementById("form");
const parrafo = document.getElementById("warnings");

form.addEventListener("submit", e=>{
    e.preventDefault();
    let warnings = "";
    let entrar = false;
    let regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/
    parrafo.innerHTML = "";
    if(!regexEmail.test(email.value)){
        warnings += `El email no es valido <br>`;
        entrar = true;
    }
    if(usuario.value.length<8){
        warnings += `El usuario no puede tener menos de 8 caracteres <br>`;
        entrar = true;
    }
    if(pass.value.length < 8){
        warnings += `La contraseña no puede tener menos de 8 caracteres <br>`
        entrar = true
    }
    
    if(tipoDocumento.value.length <= 0) {
        warnings += 'No puede estar vacio el campo tipo de documento sin valor';
        entrar = true;
    }
    
    if(numeroDocumento.value.length <=0 ) {
        warnings += 'No puede estar vacio el campo de numero de documento';
        entrar = true;
    }

    if(entrar){
        parrafo.innerHTML = warnings;
    }else{
        e.currentTarget.submit();
    }
})

const nombreP = document.getElementById("nameP");
const emailP = document.getElementById("emailP");
const usuarioP = document.getElementById("usuarioP");
const passP = document.getElementById("claveP");
const tipoDocumentoP = document.getElementById("tipoDocumentoP");
const numeroDocumentoP = document.getElementById("numeroDocumentoP");
const formP = document.getElementById("formP");
const parrafoP = document.getElementById("warningsP");
formP.addEventListener("submit", e=>{
    e.preventDefault();
    let warnings = "";
    let entrar = false;
    let regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/
    parrafo.innerHTML = "";
    if(!regexEmail.test(emailP.value)){
        warnings += `El email no es valido <br>`;
        entrar = true;
    }
    if(usuarioP.value.length<8){
        warnings += `El usuario no puede tener menos de 8 caracteres <br>`;
        entrar = true;
    }
    if(passP.value.length < 8){
        warnings += `La contraseña no puede tener menos de 8 caracteres <br>`
        entrar = true
    }
    
    if(tipoDocumentoP.value.length <= 0) {
        warnings += 'No puede estar vacio el campo tipo de documento sin valor';
        entrar = true;
    }
    
    if(numeroDocumentoP.value.length <=0 ) {
        warnings += 'No puede estar vacio el campo de numero de documento';
        entrar = true;
    }

    if(entrar){
        parrafoP.innerHTML = warnings;
    }else{
        e.currentTarget.submit();
    }
})