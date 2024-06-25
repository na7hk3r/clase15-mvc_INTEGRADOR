window.addEventListener('load', function () {

  const formulario = document.querySelector('#update_paciente_form');

  formulario.addEventListener('submit', function (event) {
    let pacienteId = document.querySelector('#paciente_id').value;


    const formData = {
      id: document.querySelector('#paciente_id').value,
      cedula: document.querySelector('#cedula').value,
      nombre: document.querySelector('#nombre').value,
      apellido: document.querySelector('#apellido').value,
    };

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


function findBy(id) {
  const url = '/pacientes' + '/' + id;
  const settings = {
    method: 'GET',
  };
  fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
      let paciente = data;
      localStorage.setItem('isShow', JSON.stringify(true));
      document.querySelector('#paciente_id').value = paciente.id;
      document.querySelector('#cedula').value = paciente.cedula;
      document.querySelector('#nombre').value = paciente.nombre;
      document.querySelector('#apellido').value = paciente.apellido;
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

