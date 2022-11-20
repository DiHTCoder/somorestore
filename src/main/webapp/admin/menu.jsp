<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">
   <div class="app-brand demo">
      <a href="./index.jsp" class="app-brand-link">
         <span class="app-brand-logo demo">
            <img src="./assets/img/logo.png" alt="">
         </span>
      </a>
      <a href="javascript:void(0);" class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
         <i class="bx bx-chevron-left bx-sm align-middle"></i>
      </a>
   </div>
   <div class="menu-inner-shadow"></div>
   <ul class="menu-inner py-1">
      <!-- Menu Items -->
<%--      <li class="menu-item" id="menu-overview">--%>
<%--         <a href="./index.jsp" class="menu-link">--%>
<%--            <i class="menu-icon tf-icons bx bx-home-circle"></i>--%>
<%--            <div data-i18n="Analytics">Tổng quan</div>--%>
<%--         </a>--%>
<%--      </li>--%>
      <li class="menu-item" id="menu-managements">
         <a href="javascript:void(0);" class="menu-link menu-toggle">
            <i class="menu-icon tf-icons bx bx-layout"></i>
            <div data-i18n="Managements">Quản lý cửa hàng</div>
         </a>
         <ul class="menu-sub">
            <li class="menu-item" id="menu-managements-categories">
               <a href="admin/categories" class="menu-link">
                  <div data-i18n="Without menu">Quản lý danh mục</div>
               </a>
            </li>
            <li class="menu-item" id="menu-managements-products">
               <a href="<%request.getContextPath();%>/admin/products" class="menu-link">
                  <div data-i18n="Without navbar">Quản lý sản phẩm</div>
               </a>
            </li>
            <li class="menu-item" id="menu-managements-orders">
               <a href="<%request.getContextPath();%>/admin/orders" class="menu-link">
                  <div data-i18n="Without navbar">Quản lý đơn hàng</div>
               </a>
            </li>
            <li class="menu-item" id="menu-managements-account">
               <a href="<%request.getContextPath();%>/admin/orders" class="menu-link">
                  <div data-i18n="Without navbar">Quản lý tài khoản</div>
               </a>
            </li>
         </ul>
      </li>
      <li class="menu-item" id="menu-account">
         <a href="javascript:void(0);" class="menu-link menu-toggle">
            <i class="menu-icon tf-icons bx bx-dock-top"></i>
            <div data-i18n="Account Settings">Thông tin tài khoản</div>
         </a>
         <ul class="menu-sub">
            <li class="menu-item" id="menu-account-profile">
               <a href="./account-profile.jsp" class="menu-link">
                  <div data-i18n="Account">Tài khoản của bạn</div>
               </a>
            </li>
         </ul>
      </li>
   </ul>
</aside>