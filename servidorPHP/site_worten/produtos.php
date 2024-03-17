<?php include('includes/head.php') ?>
<?php include('includes/header.php') ?>

<main class="m-2 p-3 shadow rounded">
    <div class="container">
        <div class="row">
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card mx-auto" style="width: 18rem;">
                    <img src="img/produtos/ASUS_E1504FA.webp" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Asus E1504FA <span class="badge ms-2">Novo</span></h5>
                        <p class="card-text">599€</p>
                        <a href="#" class="btn" id="liveToastBtn">Comprar</a>
                    </div>
                    </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card mx-auto" style="width: 18rem;">
                    <img src="img/produtos/HP_15s-eq2100np.webp" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">HP 15S-EQ2100NP</h5>
                        <p class="card-text">659€ <span class="badge ms-2">Promoção</span></p>
                        <a href="#" class="btn">Comprar</a>
                    </div>
                    </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card mx-auto" style="width: 18rem;">
                    <img src="img/produtos/LENOVO_IdeaPad_1_15ALC7-621.webp" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">LENOVO IdeaPad 1 15ALC7-621</h5>
                        <p class="card-text">269€.</p>
                        <a href="#" class="btn">Comprar</a>
                    </div>
                    </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card mx-auto" style="width: 18rem;">
                    <img src="img/produtos/LENOVO_1_15IGL7.webp" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">LENOVO 1 15IGL7</h5>
                        <p class="card-text">159.99€</p>
                        <a href="#" class="btn">Comprar</a>
                    </div>
                    </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card mx-auto" style="width: 18rem;">
                    <img src="img/produtos/HP_Victus_16-S0002NP.webp" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">HP Victus 16 S0002NP</h5>
                        <p class="card-text">1299€.</p>
                        <a href="#" class="btn">Comprar</a>
                    </div>
                    </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card mx-auto" style="width: 18rem;">
                    <img src="img/produtos/LENOVO_YOGA_7_16IRL8-511.webp" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">LENOVO YOGA 7 16IRL8-511</h5>
                        <p class="card-text">1359€</p>
                        <a href="#" class="btn">Comprar</a>
                    </div>
                    </div>
            </div>
        </div>
    </div>

    <!-- Toast-->
    <div class="toast-container position-fixed bottom-0 end-0 p-3">
    <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
        <img src="img/success.svg" class="rounded me-2 w-25" alt="...">
        <strong class="me-auto">Sucesso</strong>
        <small>Agora mesmo</small>
        <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
        Adicionado ao carrinho!
        </div>
    </div>
    </div>
    <!-- / Toast-->

</main>

<?php include('includes/footer.php') ?>