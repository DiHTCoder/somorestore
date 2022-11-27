<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Somore | Shop</title>

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
<jsp:include page="header.jsp"/>
<!-- Header Section End -->

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__text">
                    <h4>Shop</h4>
                    <div class="breadcrumb__links">
                        <a href="index.jsp">Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shop Section Begin -->
<section class="shop spad">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="shop__sidebar">
                    <div class="shop__sidebar__search">
                        <form action="#">
                            <input type="text" placeholder="Tìm sản phẩm..." id="searchinput">
                            <button type="submit"><span class="icon_search"></span></button>
                        </form>
                    </div>
                    <div class="shop__sidebar__accordion">
                        <div class="accordion" id="accordionExample">
                            <div class="card">
                                <div class="card-heading">
                                    <a data-toggle="collapse" data-target="#collapseOne">Danh mục sản phẩm</a>
                                </div>
                                <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                    <div class="card-body">
                                        <div class="shop__sidebar__categories">
                                            <ul class="nice-scroll">
                                                <c:forEach items="${cateList}" var="o">
                                                    <li><a href="shop?cid=${o.id}">${o.name}</a></li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-heading">
                                    <a data-toggle="collapse" data-target="#collapseThree">Giá sản phẩm</a>
                                </div>
                                <div id="collapseTwo" class="collapse show" data-parent="#accordionExample">
                                    <div class="card-body">
                                        <div class="shop__sidebar__price">
                                            <ul class="product-price-list">
                                                <li><a href="shop">Tăng dần</a></li>
                                                <li><a href="sap-xep-giam">Giảm dần</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--                            <div class="card">--%>
                            <%--                                <div class="card-heading">--%>
                            <%--                                    <a data-toggle="collapse" data-target="#collapseThree">Màu sắc</a>--%>
                            <%--                                </div>--%>
                            <%--                                <div id="collapseThree" class="collapse show" data-parent="#accordionExample">--%>
                            <%--                                    <div class="card-body">--%>
                            <%--                                        <div class="shop__sidebar__price">--%>
                            <%--                                            <ul>--%>
                            <%--                                                <li><a href="#">Trắng</a></li>--%>
                            <%--                                                <li><a href="#">Đen</a></li>--%>
                            <%--                                                <li><a href="#">Vàng</a></li>--%>
                            <%--                                                <li><a href="#">Hồng</a></li>--%>
                            <%--                                                <li><a href="#">Mix Trắng Đen</a></li>--%>
                            <%--                                                <li><a href="#">Mix Cầu Vòng</a></li>--%>
                            <%--                                            </ul>--%>
                            <%--                                        </div>--%>
                            <%--                                    </div>--%>
                            <%--                                </div>--%>
                            <%--                            </div>--%>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="shop__product__option">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="shop__product__option__left">
                                <p>Sản phẩm</p>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="shop__product__option__right">
                                <%--                                <p>Sắp xếp theo giá:</p>--%>
                                <%--                                <select>--%>
                                <%--                                    <option value="">Cao - Thấp</option>--%>
                                <%--                                    <option value="">Thấp - Cao</option>--%>
                                <%--                                </select>--%>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row product-item-all">
                    <c:forEach items="${productList}" var="p">
                        <div class="col-lg-4 col-md-3 col-sm-6 product-item">
                            <div class="block product no-border z-depth-2-top z-depth-2--hover">
                                <div class="block-image">
                                    <a href="product-detail?pid=${p.id}">
                                        <img src="${p.image}" class="img-center">
                                    </a>
                                    <span
                                            class="product-ribbon product-ribbon-right product-ribbon--style-1 bg-blue text-uppercase">-${p.discount}</span>
                                </div>
                                <div class="block-body text-center">
                                    <h2 class="product__name">
                                        <a href="#">
                                                ${p.name}
                                        </a>
                                    </h2>
                                    <p class="product-description">
                                            ${p.price}
                                    </p>
                                    <div class="product-buttons mt-4">
                                        <div class="row align-items-center">
                                            <div class="col-2">
                                                <button type="button" class="btn-icon" data-toggle="tooltip"
                                                        data-placement="top" title=""
                                                        data-original-title="Favorite">
                                                    <a href="product-detail?pid=${p.id}"><i
                                                            class="fa fa-search"></i></a>
                                                </button>
                                            </div>
                                            <div class="col-10">
                                                <button type="button"
                                                        class="add-to-cart btn btn-block btn-primary btn-circle btn-icon-left">
                                                    <a href="cart?pid=${p.id}&username=${userLogged.username}"><i class="fa fa-shopping-cart"></i>Add to cart </a>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="product__pagination">
                            <a class="active" href="#">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <span>...</span>
                            <a href="#">21</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shop Section End -->

<!-- Footer Section Begin -->
<jsp:include page="footer.jsp"/>
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