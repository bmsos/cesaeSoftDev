<?php include('includes/head.php') ?>
<?php include('includes/header.php') ?>

<main class="m-2 p-3 shadow rounded">
    <div class="container">
        <div class="row">
            <div class="col-12 col-md-6">
                <iframe id="gmaps" class="w-100" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d12011.625277089572!2d-8.67404401302336!3d41.180210442566924!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd2465f41da3e0fd%3A0xf4dfb56e4460e634!2sWorten!5e0!3m2!1spt-PT!2spt!4v1709828819602!5m2!1spt-PT!2spt" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
            <div class="col-12 col-md-6 text-center my-auto">
                <div class="row">
                    <div class="col">
                        <i class="bi bi-geo-alt-fill"></i>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <span>Rua Sara Afonso - Norte Shopping Loja 112</span>
                        <br>
                        <span>4460-841 Senhora da Hora - Matosinhos</span>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        <i class="bi bi-clock-fill"></i>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <span>2ª a domingo:</span>
                        <span>10:00 - 23:00</span>
                    </div>
                </div>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col text-center">
                    <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Fale connosco
                </button>
                
                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Contacto</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Email</label>
                                <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="Insira o seu email">
                            </div>
                            <div class="mb-3">
                                <label for="exampleFormControlTextarea1" class="form-label">Mensagem</label>
                                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                            </div>
                        </div>
                        <div class="modal-footer">
                        <button type="button" class="btn" data-bs-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn">Enviar</button>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<?php include('includes/footer.php') ?>