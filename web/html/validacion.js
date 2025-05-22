document.addEventListener("DOMContentLoaded", function () {
  const emailInput = document.getElementById("email");
  const nombreInput = document.getElementById("nombre");
  const apellidoInput = document.getElementById("apellido");
  const contrasenaInput = document.getElementById("contrasena");
  const sexoInput = document.getElementById("sexo");
  const edadInput = document.getElementById("edad");
  const alturaInput = document.getElementById("altura");
  const pesoInput = document.getElementById("peso");
  const pesoObjetivoContainer = document.getElementById('pesoObjetivoContainer');
  const pesoObjetivoInput = document.getElementById('peso_objetivo');
  const rangoTexto = document.getElementById('rangoPesoObjetivo');

  const mensajeCorreo = document.getElementById("mensaje-correo");
  const mensajeNombre = document.getElementById("mensaje-nombre");
  const mensajeApellido = document.getElementById("mensaje-apellido");
  const mensajeContrasena = document.getElementById("mensaje-contrasena");
  const mensajeSexo = document.getElementById("mensaje-sexo");
  const mensajeEdad = document.getElementById("mensaje-edad");
  const mensajeAltura = document.getElementById("mensaje-altura");
  const mensajePeso = document.getElementById("mensaje-peso");
  const mensajePesoObjetivo = document.getElementById("mensaje-peso-objetivo");



  const soloLetras = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/;
  const patronContrasena = /^(?=.*[A-Z]).{8,}$/;

  // Validar email
  emailInput.addEventListener("input", function () {
    const email = emailInput.value.trim();
    const dominiosValidos = ["gmail.com", "hotmail.com", "outlook.com", "yahoo.com"];
    
    if (!email.includes("@")) {
      emailInput.classList.add("is-invalid");
      mensajeCorreo.textContent = "El correo debe contener '@'.";
    } else {
      const dominio = email.split("@")[1] || "";
      if (!dominiosValidos.includes(dominio.toLowerCase())) {
        emailInput.classList.add("is-invalid");
        mensajeCorreo.textContent = "Solo se permiten correos de gmail, hotmail, outlook o yahoo.";
      } else {
        emailInput.classList.remove("is-invalid");
        emailInput.classList.add("is-valid");
        mensajeCorreo.textContent = "";
      }
    }
  });

  // Validar nombre
  nombreInput.addEventListener("input", function () {
    const nombre = nombreInput.value.trim();
    if (!soloLetras.test(nombre)) {
      nombreInput.classList.add("is-invalid");
      mensajeNombre.textContent = "El nombre solo debe contener letras.";
    } else {
      nombreInput.classList.remove("is-invalid");
      nombreInput.classList.add("is-valid");
      mensajeNombre.textContent = "";
    }
  });

  // Validar apellido
  apellidoInput.addEventListener("input", function () {
    const apellido = apellidoInput.value.trim();
    if (!soloLetras.test(apellido)) {
      apellidoInput.classList.add("is-invalid");
      mensajeApellido.textContent = "El apellido solo debe contener letras.";
    } else {
      apellidoInput.classList.remove("is-invalid");
      apellidoInput.classList.add("is-valid");
      mensajeApellido.textContent = "";
    }
  });

  // Validar contraseña
  contrasenaInput.addEventListener("input", function () {
    const contrasena = contrasenaInput.value.trim();
    if (!patronContrasena.test(contrasena)) {
      contrasenaInput.classList.add("is-invalid");
      mensajeContrasena.textContent = "La contraseña debe tener al menos 8 caracteres y una mayúscula.";
    } else {
      contrasenaInput.classList.remove("is-invalid");
      contrasenaInput.classList.add("is-valid");
      mensajeContrasena.textContent = "";
    }
  });

        //VALIDAR SEXO 
  sexoInput.addEventListener("change", function () {
  const valorSeleccionado = sexoInput.value;

  if (valorSeleccionado === "") {
    sexoInput.classList.add("is-invalid");
    mensajeSexo.textContent = "Debe seleccionar una opción.";
  } else {
    sexoInput.classList.remove("is-invalid");
    sexoInput.classList.add("is-valid");
    mensajeSexo.textContent = "";
  }
});

        //VALIDAR EDAD 
edadInput.addEventListener("input", function () {
    const edad = parseInt(edadInput.value, 10);

    if (isNaN(edad)) {
      edadInput.classList.add("is-invalid");
      edadInput.classList.remove("is-valid");
      mensajeEdad.textContent = "Ingrese un número válido.";
    } else if (edad < 0) {
      edadInput.classList.add("is-invalid");
      edadInput.classList.remove("is-valid");
      mensajeEdad.textContent = "Ingrese un número positivo.";
    } else if (edad < 12 || edad > 90) {
      edadInput.classList.add("is-invalid");
      edadInput.classList.remove("is-valid");
      mensajeEdad.textContent = "La edad debe estar entre 12 y 90 años.";
    } else {
      edadInput.classList.remove("is-invalid");
      edadInput.classList.add("is-valid");
      mensajeEdad.textContent = "";
    }
  });

        //Validar altura 
    alturaInput.addEventListener("input", function () {
    const altura = parseInt(alturaInput.value, 10);

    if (isNaN(altura)) {
        alturaInput.classList.add("is-invalid");
        alturaInput.classList.remove("is-valid");
        mensajeAltura.textContent = "Ingrese un número válido.";
    } else if (altura <= 0) {
        alturaInput.classList.add("is-invalid");
        alturaInput.classList.remove("is-valid");
        mensajeAltura.textContent = "Ingrese un número positivo.";
    } else if (altura < 120 || altura > 200) {
        alturaInput.classList.add("is-invalid");
        alturaInput.classList.remove("is-valid");
        mensajeAltura.textContent = "La altura debe estar entre 120 y 200 cm.";
    } else {
        alturaInput.classList.remove("is-invalid");
        alturaInput.classList.add("is-valid");
        mensajeAltura.textContent = "";
    }
    });

        //VALIDAR PESO 
        pesoInput.addEventListener("input", function () {
  const peso = parseInt(pesoInput.value, 10);

  if (isNaN(peso)) {
    pesoInput.classList.add("is-invalid");
    pesoInput.classList.remove("is-valid");
    mensajePeso.textContent = "Ingrese un número válido.";
  } else if (peso <= 0) {
    pesoInput.classList.add("is-invalid");
    pesoInput.classList.remove("is-valid");
    mensajePeso.textContent = "Ingrese un número positivo.";
  } else if (peso < 30 || peso > 250) {
    pesoInput.classList.add("is-invalid");
    pesoInput.classList.remove("is-valid");
    mensajePeso.textContent = "El peso debe estar entre 30 y 250 kg.";
  } else {
    pesoInput.classList.remove("is-invalid");
    pesoInput.classList.add("is-valid");
    mensajePeso.textContent = "";
  }
});

                //CALCULAR PESO OBJETIVO 

     alturaInput.addEventListener('input', () => {
    const alturaCm = parseFloat(alturaInput.value);
    if (alturaCm > 0) {
      const alturaM = alturaCm / 100;
      const pesoMin = (18.5 * alturaM * alturaM).toFixed(2);
      const pesoMax = (24.9 * alturaM * alturaM).toFixed(2);

      rangoTexto.textContent = `Rango saludable: ${pesoMin} kg - ${pesoMax} kg`;
      pesoObjetivoInput.min = pesoMin;
      pesoObjetivoInput.max = pesoMax;
      pesoObjetivoInput.value = '';  // Limpiar campo peso objetivo
      pesoObjetivoContainer.style.display = 'block';
    } else {
      pesoObjetivoContainer.style.display = 'none';
      pesoObjetivoInput.value = '';
      rangoTexto.textContent = '';
    }
  });

  // Opcional: validar que peso objetivo esté dentro del rango al cambiar el valor
  pesoObjetivoInput.addEventListener('input', () => {
    const peso = parseFloat(pesoObjetivoInput.value);
    const min = parseFloat(pesoObjetivoInput.min);
    const max = parseFloat(pesoObjetivoInput.max);

    if (peso < min || peso > max) {
      pesoObjetivoInput.setCustomValidity(`El peso debe estar entre ${min} y ${max} kg`);
      mensajePesoObjetivo.textContent = `El peso debe estar entre ${min} kg y ${max} kg.`;s
    } else {
      pesoObjetivoInput.setCustomValidity('');
    }

});

});

