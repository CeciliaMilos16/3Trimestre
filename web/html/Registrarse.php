<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrarse Fit-Track</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@600&family=Open+Sans&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="../css/Login.css" />
    <link rel="icon" href="../imagenes/Variaciones del logo FitTrack (2).png" type="image/png">
</head>
<body class="body-1 d-flex justify-content-center align-items-center min-vh-100">

  <div class="container container_3 shadow-lg">
    <div class="row align-items-center">
      <!-- Columna izquierda con imagen y texto -->
      <div class="col-lg-4 text-center mb-3 mb-lg-0">
        <img src="../imagenes/Variaciones del logo FitTrack.png" alt="Logo FitTrack" class="img-fluid" style="max-width: 200px;">
        <h2 class="mt-3 ">Fit-Track</h2>
      </div>

      <!-- Columna derecha con formulario -->
      <div class="col-lg-7">
        <div class="d-flex justify-content-center">
            <h1 class="text-center">Crear una nueva cuenta</h1>
        </div>
            <form action="../php/Resgistro.php" method="post">
            <!-- Campo de correo a ancho completo -->
            <div class="mb-3">
                <label for="email" class="form-label">Correo Electrónico</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Ingrese su correo electrónico" required>
            </div>

            <!-- Agrupación en dos columnas -->
            <div class="row">
                <div class="col-md-6 mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" name="nombre" id="nombre" class="form-control" placeholder="Ingrese su nombre" required maxlength="20">
                </div>

                <div class="col-md-6 mb-3">
                <label for="apellido" class="form-label">Apellido</label>
                <input type="text" name="apellido" id="apellido" class="form-control" placeholder="Ingrese su apellido" required maxlength="20">
                </div>

                <div class="col-md-6 mb-3">
                <label for="contraseña" class="form-label">Contraseña</label>
                <input type="password" class="form-control" id="contraseña" name="contraseña" placeholder="Ingrese su contraseña" required>
                </div>

                <div class="col-md-6 mb-3">
                <label for="sexo" class="form-label">Sexo</label>
                <select id="sexo" name="sexo" class="form-select" required>
                    <option value="" disabled selected>Seleccione su sexo</option>
                    <option value="Masculino">Masculino</option>
                    <option value="Femenino">Femenino</option>
                    <option value="Otro">Otro</option>
                </select>
                </div>

                <div class="col-md-6 mb-3">
                <label for="edad" class="form-label">Edad</label>
                <input type="number" name="edad" id="edad" class="form-control" placeholder="Ingrese su edad" >
                </div>

                <div class="col-md-6 mb-3">
                <label for="altura" class="form-label">Altura (en cm)</label>
                <input type="number" step="0.01" class="form-control" id="altura" name="altura" placeholder="Ej. 170.50" required>
                </div>

                <div class="col-md-6 mb-3">
                <label for="peso" class="form-label">Peso (en kg)</label>
                <input type="number" step="0.01" class="form-control" id="peso" name="peso" placeholder="Ej. 65.80" required>
                </div>

                <div class="col-md-6 mb-3" id="pesoObjetivoContainer" style="display:none;">
                  <label for="peso_objetivo" class="form-label">Peso objetivo (elige dentro del rango)</label>
                  <input type="number" step="0.01" class="form-control" id="peso_objetivo" name="peso_objetivo" placeholder="Selecciona tu peso objetivo" required>
                  <small id="rangoPesoObjetivo" class="form-text text-muted"></small>
                </div>
            </div>
                

            <div class="mb-3">
              <label for="factor" class="form-label">Factor de actividad</label>
              
              <select id="factor" name="factor" class="form-select" required>
              <option value="" disabled selected>Seleccione su factor de actividad</option>
              <option value="1.2">Sedentario</option>
              <option value="1.375">Ligero (1-3 días/semana)</option>
              <option value="1.55">Moderado (3-5 días/semana)</option>
              <option value="1.725">Intenso (6-7 días/semana)</option>
              <option value="1.9">Muy intenso (trabajo físico pesado)</option>
            </select> 
            </div>

            <!-- BOTON CENTRADO -->
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-custom mb-3">Registrar</button>
            </div>
            </form>

      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
  <script>
  const alturaInput = document.getElementById('altura');
  const pesoObjetivoContainer = document.getElementById('pesoObjetivoContainer');
  const pesoObjetivoInput = document.getElementById('peso_objetivo');
  const rangoTexto = document.getElementById('rangoPesoObjetivo');

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
    } else {
      pesoObjetivoInput.setCustomValidity('');
    }
  });
</script>

</body>
</html>