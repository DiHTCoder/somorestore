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
      <li class="menu-item" id="menu-managements">
         <a href="javascript:void(0);" class="menu-link menu-toggle">
            <i class="menu-icon tf-icons bx bx-layout"></i>
            <div data-i18n="Managements">Quản lý đơn vận</div>
         </a>
         <ul class="menu-sub">
            <li class="menu-item" id="menu-managements-categories">
               <a href="<%request.getContextPath();%>./confirm-order" class="menu-link">
                  <div data-i18n="Without menu">Đơn hàng chưa nhận</div>
               </a>
            </li>
            <li class="menu-item" id="menu-managements-products">
               <a href="<%request.getContextPath();%>./delivering-order" class="menu-link">
                  <div data-i18n="Without navbar">Đơn hàng đang giao</div>
               </a>
            </li>
            <li class="menu-item" id="menu-managements-orders">
               <a href="<%request.getContextPath();%>./done-order" class="menu-link">
                  <div data-i18n="Without navbar">Đơn hàng đã giao</div>
               </a>
            </li>
         </ul>
      </li>
   </ul>
</aside>