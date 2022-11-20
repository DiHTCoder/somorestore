<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Page Preloder -->
<%--<div id="preloder">--%>
<%--   <div class="loader"></div>--%>
<%--</div>--%>

<!-- Offcanvas Menu Begin -->
<div class="offcanvas-menu-overlay"></div>
<div class="offcanvas-menu-wrapper">
   <div class="offcanvas__option">
      <div class="logo-mobile">
         <img src="./assets/img/shop/logomain.png" alt="">
      </div>
      <div class="offcanvas__links">
         <a href="./authentication.jsp">Đăng nhập/Đăng ký</a>
      </div>
   </div>

   <div class="offcanvas__nav__option">
   </div>
   <div id="mobile-menu-wrap"></div>
   <div class="offcanvas__text">
      <p>Miễn phí vận chuyển, đổi trả trong vòng 1 tuần.</p>
   </div>
</div>
<!-- Offcanvas Menu End -->

<!-- Header Section Begin -->
<header class="header">
   <div class="header__top">
      <div class="container">
         <div class="row">
            <div class="col-lg-6 col-md-7">
               <div class="header__top__left">
                  <p>Miễn phí vận chuyển, đổi trả trong vòng 1 tuần.</p>
               </div>
            </div>
            <div class="col-lg-6 col-md-5">
               <div class="header__top__right">
                  <div class="header__top__links">
                     <a href="#">Đăng nhập / Đăng ký</a>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <div class="container">
      <div class="row">
         <div class="col-lg-3 col-md-3">
            <div class="header__logo">
               <a href="./index.jsp"><img src="./assets/img/shop/logomain.png" alt=""></a>
            </div>
         </div>
         <div class="col-lg-6 col-md-6">
            <nav class="header__menu mobile-menu">
               <ul>
                  <li id="menu-home"><a href="./index.jsp">Trang chủ</a></li>
                  <li id="menu-shop"><a href="./shop.jsp">Shop</a></li>
                  <li id="menu-pages"><a href="./blog.jsp">Blogs</a></li>
                  <li id="menu-contact"><a href="./contact.jsp">Liên hệ</a></li>
               </ul>
            </nav>
         </div>
         <div class="col-lg-3 col-md-3">
            <div class="header__nav__option mobile-menu">
               <div class="header__nav-username">Hi!<b> ${userLogged.name}</b></div>
               <div class="header__nav-avatar">
                  <a href="profile.jsp"><img src="assets/img/shop/For-Men.png" alt=""></a>
               </div>
               <a href="shopping-cart.jsp"><img src="assets/img/icon/cart.png" alt=""> <span>0</span></a>
               <div class="price">$0.00</div>
            </div>
         </div>
      </div>
      <div class="canvas__open"><i class="fa fa-bars"></i></div>
   </div>
</header>
<!-- Header Section End -->