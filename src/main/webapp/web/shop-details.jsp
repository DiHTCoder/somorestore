<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
   <meta charset="UTF-8">
   <meta name="description" content="Male_Fashion Template">
   <meta name="keywords" content="Male_Fashion, unica, creative, html">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <title>Male-Fashion | Template</title>

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
                  <a href="./index.html">Home</a>
                  <a href="shop.jsp">Shop</a>
                  <span>Product Details</span>
               </div>
            </div>
         </div>
         <!-- <div class="row">
            <div class="col-lg-3 col-md-3">
               <ul class="nav nav-tabs" role="tablist">
                  <c:forEach items="imgs" var="img">
                  <li class="nav-item">
                     <a class="nav-link active" data-toggle="tab" href="#tabs-${img.id}" role="tab">
                        <div class="product__thumb__pic set-bg" data-setbg="${img.url}">
                        </div>
                     </a>
                  </li>
                  </c:forEach>

               </ul>
            </div>
            <div class="col-lg-6 col-md-9">
               <div class="tab-content">
                  <c:forEach items="imgs" var="img">
                     <li class="nav-item">
                        <div class="tab-pane active" id="tabs-${img.id}" role="tabpanel">
                           <div class="product__details__pic__item">
                              <img src="${img.url}" alt="">
                           </div>
                        </div>
                     </li>
                  </c:forEach>

               </div>
            </div>
         </div> -->
      </div>
   </div>
   <div class="product__details__content">
      <div class="container">
         <div class="row d-flex justify-content-center">
            <div class="col-lg-8">
               <div class="product__details__text">
                  <h4>${product.name}</h4>
                  <div class="rating">
                     <i class="fa fa-star"></i>
                     <i class="fa fa-star"></i>
                     <i class="fa fa-star"></i>
                     <i class="fa fa-star"></i>
                     <i class="fa fa-star-o"></i>
                  </div>
                  <h3>${product.price}</h3>
                  <p>${product.description}</p>
                  <div class="product__details__option">
                     <div class="product__details__option__size">
                        <span>Size: ${product.size}</span>
                     </div>
                     <div class="product__details__option__color">
                        <span>${product.size}</span>
                     </div>
                  </div>
                  <div class="product__details__cart__option">
                     <div class="quantity">
                        <div class="pro-qty">
                           <input type="text" value="1">
                        </div>
                     </div>
                     <a href="#" class="primary-btn">add to cart</a>
                  </div>

                  <div class="product__details__last__option">
                     <h5><span>Guaranteed Safe Checkout</span></h5>
                     <img src="img/shop-details/details-payment.png" alt="">
                  </div>
               </div>
            </div>
         </div>

      </div>
   </div>
</section>
<!-- Shop Details Section End -->

<!-- Related Section Begin -->
<section class="related spad">
   <div class="container">
      <div class="row">
         <div class="col-lg-12">
            <h3 class="related-title">Related Product</h3>
         </div>
      </div>
      <div class="row">
         <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
            <div class="product__item">
               <div class="product__item__pic set-bg" data-setbg="./assets/img/product/product-1.jpg">
                  <span class="label">New</span>
                  <ul class="product__hover">
                     <li><a href="#"><img src="./assets/img/icon/heart.png" alt=""></a></li>
                     <li><a href="#"><img src="./assets/img/icon/compare.png" alt=""> <span>Compare</span></a></li>
                     <li><a href="#"><img src="./assets/img/icon/search.png" alt=""></a></li>
                  </ul>
               </div>
               <div class="product__item__text">
                  <h6>Piqué Biker Jacket</h6>
                  <a href="#" class="add-cart">+ Add To Cart</a>
                  <div class="rating">
                     <i class="fa fa-star-o"></i>
                     <i class="fa fa-star-o"></i>
                     <i class="fa fa-star-o"></i>
                     <i class="fa fa-star-o"></i>
                     <i class="fa fa-star-o"></i>
                  </div>
                  <h5>$67.24</h5>
                  <div class="product__color__select">
                     <label for="pc-1">
                        <input type="radio" id="pc-1">
                     </label>
                     <label class="active black" for="pc-2">
                        <input type="radio" id="pc-2">
                     </label>
                     <label class="grey" for="pc-3">
                        <input type="radio" id="pc-3">
                     </label>
                  </div>
               </div>
            </div>
         </div>
         <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
            <div class="product__item">
               <div class="product__item__pic set-bg" data-setbg="./assets/img/product/product-2.jpg">
                  <ul class="product__hover">
                     <li><a href="#"><img src="./assets/img/icon/heart.png" alt=""></a></li>
                     <li><a href="#"><img src="./assets/img/icon/compare.png" alt=""> <span>Compare</span></a></li>
                     <li><a href="#"><img src="./assets/img/icon/search.png" alt=""></a></li>
                  </ul>
               </div>
               <div class="product__item__text">
                  <h6>Piqué Biker Jacket</h6>
                  <a href="#" class="add-cart">+ Add To Cart</a>
                  <div class="rating">
                     <i class="fa fa-star-o"></i>
                     <i class="fa fa-star-o"></i>
                     <i class="fa fa-star-o"></i>
                     <i class="fa fa-star-o"></i>
                     <i class="fa fa-star-o"></i>
                  </div>
                  <h5>$67.24</h5>
                  <div class="product__color__select">
                     <label for="pc-4">
                        <input type="radio" id="pc-4">
                     </label>
                     <label class="active black" for="pc-5">
                        <input type="radio" id="pc-5">
                     </label>
                     <label class="grey" for="pc-6">
                        <input type="radio" id="pc-6">
                     </label>
                  </div>
               </div>
            </div>
         </div>
         <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
            <div class="product__item sale">
               <div class="product__item__pic set-bg" data-setbg="./assets/img/product/product-3.jpg">
                  <span class="label">Sale</span>
                  <ul class="product__hover">
                     <li><a href="#"><img src="./assets/img/icon/heart.png" alt=""></a></li>
                     <li><a href="#"><img src="./assets/img/icon/compare.png" alt=""> <span>Compare</span></a></li>
                     <li><a href="#"><img src="./assets/img/icon/search.png" alt=""></a></li>
                  </ul>
               </div>
               <div class="product__item__text">
                  <h6>Multi-pocket Chest Bag</h6>
                  <a href="#" class="add-cart">+ Add To Cart</a>
                  <div class="rating">
                     <i class="fa fa-star"></i>
                     <i class="fa fa-star"></i>
                     <i class="fa fa-star"></i>
                     <i class="fa fa-star"></i>
                     <i class="fa fa-star-o"></i>
                  </div>
                  <h5>$43.48</h5>
                  <div class="product__color__select">
                     <label for="pc-7">
                        <input type="radio" id="pc-7">
                     </label>
                     <label class="active black" for="pc-8">
                        <input type="radio" id="pc-8">
                     </label>
                     <label class="grey" for="pc-9">
                        <input type="radio" id="pc-9">
                     </label>
                  </div>
               </div>
            </div>
         </div>
         <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
            <div class="product__item">
               <div class="product__item__pic set-bg" data-setbg="./assets/img/product/product-4.jpg">
                  <ul class="product__hover">
                     <li><a href="#"><img src="./assets/img/icon/heart.png" alt=""></a></li>
                     <li><a href="#"><img src="./assets/img/icon/compare.png" alt=""> <span>Compare</span></a></li>
                     <li><a href="#"><img src="./assets/img/icon/search.png" alt=""></a></li>
                  </ul>
               </div>
               <div class="product__item__text">
                  <h6>Diagonal Textured Cap</h6>
                  <a href="#" class="add-cart">+ Add To Cart</a>
                  <div class="rating">
                     <i class="fa fa-star-o"></i>
                     <i class="fa fa-star-o"></i>
                     <i class="fa fa-star-o"></i>
                     <i class="fa fa-star-o"></i>
                     <i class="fa fa-star-o"></i>
                  </div>
                  <h5>$60.9</h5>
                  <div class="product__color__select">
                     <label for="pc-10">
                        <input type="radio" id="pc-10">
                     </label>
                     <label class="active black" for="pc-11">
                        <input type="radio" id="pc-11">
                     </label>
                     <label class="grey" for="pc-12">
                        <input type="radio" id="pc-12">
                     </label>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</section>
<!-- Related Section End -->

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