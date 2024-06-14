document.addEventListener("DOMContentLoaded", function() {
    const navbarHTML = `
    <nav class="navbar navbar-dark bg-primary navbar-expand-lg sticky-top">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index.html">Inicio</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            Pacientes
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="post_pacientes.html">Guardar</a></li>
                            <li><a class="dropdown-item" href="get_pacientes.html">Listar</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            Odontologos
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="post_odontologos.html">Guardar</a></li>
                            <li><a class="dropdown-item" href="get_odontologos.html">Listar</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            Turnos
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="post_turnos.html">Guardar</a></li>
                            <li><a class="dropdown-item" href="get_turnos.html">Listar</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    `;

    document.body.insertAdjacentHTML("afterbegin", navbarHTML);
});