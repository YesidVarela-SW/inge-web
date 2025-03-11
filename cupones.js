let cupones = [];

function generarCupon() {
    const caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789$#!¡&%¿?=/*-|°¬^[](){};:";
    let cupon = "";

    for (let i = 0; i < 10; i++) {
        cupon += caracteres.charAt(Math.floor(Math.random() * caracteres.length));
    }

    cupon += "#"; // Agrega el "#" al final
    cupones.push(cupon);
    
    document.getElementById("cuponGenerado").innerText = "Cupón generado: " + cupon;
    let mensaje = document.getElementById("mensaje");
    mensaje.style.display = "none"; // Oculta el mensaje al generar un nuevo cupón

    console.log("Cupón generado:", cupon);
    console.log("Cupones almacenados:", cupones);
}

function validarCupon() {
    let codigoIngresado = document.getElementById("codigoIngresado").value;
    let mensaje = document.getElementById("mensaje");
    mensaje.style.display = "block"; // Muestra el mensaje

    if (cupones.includes(codigoIngresado)) {
        mensaje.innerText = "✅ Cupón válido";
        mensaje.className = "valido";
        cupones = cupones.filter(cupon => cupon !== codigoIngresado); // Elimina el cupón validado
        console.log("✅ Cupón válido:", codigoIngresado);
    } else {
        mensaje.innerText = "❌ Cupón inválido";
        mensaje.className = "invalido";
        console.log("❌ Cupón inválido:", codigoIngresado);
    }

    console.log("Cupones restantes:", cupones);
}
