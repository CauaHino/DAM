document.addEventListener('DOMContentLoaded', function() {
    const formulario = document.querySelector('form');
    const divAlertas = document.getElementById('mensajeAlerta');

    function mostrarAlerta(mensaje, tipo) {
        divAlertas.innerHTML = ''; 

        const alerta = document.createElement('div');
        alerta.textContent = mensaje;
        alerta.style.padding = '12px';
        alerta.style.borderRadius = '5px';
        alerta.style.marginBottom = '10px';
        alerta.style.textAlign = 'center';

        if (tipo === 'error') {
            alerta.style.backgroundColor = '#f8d7da';
            alerta.style.color = '#721c24';
            alerta.style.border = '1px solid #f5c6cb';
        } else {
            alerta.style.backgroundColor = '#d4edda';
            alerta.style.color = '#155724';
            alerta.style.border = '1px solid #c3e6cb';
        }

        divAlertas.appendChild(alerta);
    }

    function validarFormulario() {
        const nombre = document.getElementById('nombre').value.trim();
        const email = document.getElementById('email').value.trim();
        const asunto = document.getElementById('asunto').value.trim();
        const mensaje = document.getElementById('mensaje').value.trim();
        const telefono = document.getElementById('telefono').value.trim();

        if (nombre === '') {
            mostrarAlerta('ERROR: el nombre es obligatorio', 'error');
            return false;
        } else if (email === '') {
            mostrarAlerta('ERROR: el email es obligatorio', 'error');
            return false;
        } else if (!email.includes('@') || !email.includes('.')) {
            mostrarAlerta('ERROR: el email debe contener @ y .', 'error');
            return false;
        } else if (asunto === '') {
            mostrarAlerta('ERROR: el asunto es obligatorio', 'error');
            return false;
        } else if (mensaje === '') {
            mostrarAlerta('ERROR: el mensaje es obligatorio', 'error');
            return false;
        } else if (telefono === '') {
            mostrarAlerta('ERROR: el telefono es obligatorio', 'error');
            return false;
        } else if (mensaje.length < 5) {
            mostrarAlerta('ERROR: el mensaje es muy corto', 'error');
            return false;
        }

        if (isNaN(telefono)) {
            mostrarAlerta('ERROR: el telefono no es válido', 'error');
            return false;
        }

        return true;
    }

    function enviarFormulario(evento) {
        evento.preventDefault();

        if (validarFormulario()) {
            mostrarAlerta('Enviando mensaje...', 'exito');
            
            console.log("Formulario válido. Enviando...");
            formulario.submit(); // Descomenta esta línea si tienes un action en el HTML
        }
    }

    formulario.addEventListener('submit', enviarFormulario);
    mostrarAlerta('Bienvenido - completa todos los campos', 'exito');
});