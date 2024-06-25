window.addEventListener('load', function () {
  //Buscamos y obtenemos el formulario donde estan
  //los datos que el usuario pudo haber modificado de la pelicula
  const formulario = document.querySelector('#update_paciente_form');

  formulario.addEventListener('submit', function (event) {
    let pacienteId = document.querySelector('#paciente_id').value;

    //creamos un JSON que tendrá los datos del paciente
    //a diferencia de un paciente nuevo en este caso enviamos el id
    //para poder identificarlo y modificarlo para no cargarlo como nuevo
    const formData = {
      id: document.querySelector('#paciente_id').value,
      nombre: document.querySelector('#nombre').value,
      apellido: document.querySelector('#apellido').value,
      cedula: document.querySelector('#cedula').value,
      fechaIngreso: document.querySelector('#fechaIngreso').value,
      domicilio: {
        id: document.querySelector('#domicilio_id').value,
        calle: document.querySelector('#calle').value,
        numero: document.querySelector('#numero').value,
        localidad: document.querySelector('#localidad').value,
        provincia: document.querySelector('#provincia').value,
      },
      email: document.querySelector('#email').value,
    };
    //invocamos utilizando la función fetch la API pacientes con el método PUT que modificará
    //el paciente que enviaremos en formato JSON
    const url = '/pacientes';
    const settings = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    };
    fetch(url, settings)
      .then((response) => response.json())
      .then(localStorage.setItem('isShow', JSON.stringify(false)));
  });
});

//Es la funcion que se invoca cuando se hace click sobre el id de una paciente del listado
//se encarga de llenar el formulario con los datos del paciente
//que se desea modificar
function findBy(id) {
  const url = '/pacientes' + '/' + id;
  const settings = {
    method: 'GET',
  };
  fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
      let paciente = data;
      // localStorage.setItem('isShow', JSON.stringify(true));
      document.querySelector('#paciente_id').value = paciente.id;
      document.querySelector('#nombre').value = paciente.nombre;
      document.querySelector('#apellido').value = paciente.apellido;
      document.querySelector('#cedula').value = paciente.cedula;
      document.querySelector('#fechaIngreso').value = paciente.fechaIngreso;
      document.querySelector('#domicilio_id').value = paciente.domicilio.id;
      document.querySelector('#calle').value = paciente.domicilio.calle;
      document.querySelector('#numero').value = paciente.domicilio.numero;
      document.querySelector('#localidad').value = paciente.domicilio.localidad;
      document.querySelector('#provincia').value = paciente.domicilio.provincia;
      document.querySelector('#email').value = paciente.email;
      //el formulario por default esta oculto y al editar se habilita
      document.querySelector('#div_paciente_updating').style.display = 'block';
    })
    .catch((error) => {
      alert('Error: ' + error);
    });
}

function deleteBy(id) {
  const url = '/pacientes' + '/' + id;
  const settings = {
    method: 'DELETE',
  };
  fetch(url, settings)
    .then((response) => {
    response.json();
    window.location.href = './get_pacientes.html'
  })

    .catch((error) => {
    alert('Mensaje de la Operacion: ' + error.message);
  });
}

