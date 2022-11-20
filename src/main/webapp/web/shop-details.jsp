<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
   <meta charset="UTF-8">
   <meta name="description" content="Male_Fashion Template">
   <meta name="keywords" content="Male_Fashion, unica, creative, html">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <title>Somore | Thông tin sản phẩm</title>

   <!-- Google Font -->
   <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
         rel="stylesheet">

   <!-- Css Styles -->
   <link rel="stylesheet" href="./assets/css/bootstrap.min.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/font-awesome.min.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/elegant-icons.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/magnific-popup.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/nice-select.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/owl.carousel.min.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/slicknav.min.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/style.css" type="text/css">
</head>

<body>
<!-- Header Section Begin-->
<jsp:include page="header.jsp" />
<!-- Header Section End -->

<!-- Shop Details Section Begin -->
<section class="shop-details">
   <div class="product__details__pic">
      <div class="container">
         <div class="row">
            <div class="col-lg-12">
               <div class="product__details__breadcrumb">
                  <a href="index.jsp">Trang chủ</a>
                  <a href="shop.jsp">Shop</a>
                  <span>Thông tin sản phẩm</span>
               </div>
            </div>
         </div>
         <div class="row">
            <div class="col-lg-3 col-md-3">
               <ul class="nav nav-tabs" role="tablist">
                  <li class="nav-item">
                     <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">
                        <div class="product__thumb__pic set-bg" data-setbg="./assets/img/shop-details/thumb-1.png">
                        </div>
                     </a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">
                        <div class="product__thumb__pic set-bg" data-setbg="./assets/img/shop-details/thumb-2.png">
                        </div>
                     </a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">
                        <div class="product__thumb__pic set-bg" data-setbg="./assets/img/shop-details/thumb-3.png">
                        </div>
                     </a>
                  </li>
               </ul>
            </div>
            <div class="col-lg-6 col-md-9">
               <div class="tab-content">
                  <div class="tab-pane active" id="tabs-1" role="tabpanel">
                     <div class="product__details__pic__item">
                        <img src="./assets/img/shop-details/product-big-2.png" alt="">
                     </div>
                  </div>
                  <div class="tab-pane" id="tabs-2" role="tabpanel">
                     <div class="product__details__pic__item">
                        <img src="./assets/img/shop-details/product-big-3.png" alt="">
                     </div>
                  </div>
                  <div class="tab-pane" id="tabs-3" role="tabpanel">
                     <div class="product__details__pic__item">
                        <img src="./assets/img/shop-details/product-big.png" alt="">
                     </div>
                  </div>
                  <div class="tab-pane" id="tabs-4" role="tabpanel">
                     <div class="product__details__pic__item">
                        <img src="./assets/img/shop-details/product-big-4.png" alt="">
                        <a href="https://www.youtube.com/watch?v=8PJ3_p7VqHw&list=RD8PJ3_p7VqHw&start_radio=1" class="video-popup"><i class="fa fa-play"></i></a>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <div class="product__details__content">
      <div class="container">
         <div class="row d-flex justify-content-center">
            <div class="col-lg-8">
               <div class="product__details__text">
                  <h4>Hooded thermal anorak</h4>
                  <h3>$270.00 <span>70.00</span></h3>
                  <p>Coat with quilted lining and an adjustable hood. Featuring long sleeves with adjustable
                     cuff tabs, adjustable asymmetric hem with elastic side tabs and a front zip fastening
                     with placket.</p>
                  <div class="product__details__option">
                     <div class="product__details__option__size">
                        <span>Size:</span>
                        <label for="xxl">xxl
                           <input type="radio" id="xxl">
                        </label>
                     </div>
                     <div class="product__details__option__color">
                        <span>Color:</span>
                        <label class="c-1" for="sp-1">
                           <input type="radio" id="sp-1">
                        </label>
                     </div>
                  </div>
                  <div class="product__details__cart__option">
                     <div class="quantity">
                        <div class="pro-qty">
                           <input type="text" value="1">
                        </div>
                     </div>
                     <a href="#" class="primary-btn">Thêm vào giỏ hàng</a>
                  </div>
                  <div class="product__details__btns__option">
                     <p><i class="fa fa-heart"></i> Niềm tin khách hàng</p>
                     <p><i class="fa fa-exchange"></i> Chất lượng sản phẩm</p>
                  </div>
                  <div class="product__details__last__option">
                     <h5><span>Guaranteed Safe Checkout</span></h5>
                     <img src="./assets/img/shop-details/details-payment.png" alt="">
                     <ul>
                        <li><span>Mã sản phẩm:</span> 3812912</li>
                        <li><span>Danh mục:</span> Clothes</li>
                     </ul>
                  </div>
               </div>
            </div>
         </div>
   </div>
</section>
<!-- Shop Details Section End -->

<!-- Footer Section Begin -->
<jsp:include page="footer.jsp" />
<!-- Footer Section End -->

<!-- Search Begin -->
<div class="search-model">
   <div class="h-100 d-flex align-items-center justify-content-center">
      <div class="search-close-switch">+</div>
      <form class="search-model-form">
         <input type="text" id="search-input" placeholder="Search here.....">
      </form>
   </div>
</div>
<!-- Search End -->

<!-- Active menu -->
<script>
    document.getElementById('menu-shop').classList.add('active')
</script>

<!-- Js Plugins -->
<script src="./assets/js/jquery-3.3.1.min.js"></script>
<script src="./assets/js/bootstrap.min.js"></script>
<script src="./assets/js/jquery.nice-select.min.js"></script>
<script src="./assets/js/jquery.nicescroll.min.js"></script>
<script src="./assets/js/jquery.magnific-popup.min.js"></script>
<script src="./assets/js/jquery.countdown.min.js"></script>
<script src="./assets/js/jquery.slicknav.js"></script>
<script src="./assets/js/mixitup.min.js"></script>
<script src="./assets/js/owl.carousel.min.js"></script>
<script src="./assets/js/main.js"></script>
</body>

</html>