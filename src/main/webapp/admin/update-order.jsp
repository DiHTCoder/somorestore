<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="utf-8" />
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
  <title>Managements | Orders</title>
  <link rel="icon" type="image/x-icon"
        href="./assets/img/favicon/favicon.ico" />
  <link
          href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
          rel="stylesheet" />
  <link rel="stylesheet" href="./assets/vendor/fonts/boxicons.css" />
  <link rel="stylesheet" href="./assets/vendor/css/core.css"
        class="template-customizer-core-css" />
  <link rel="stylesheet" href="./assets/vendor/css/theme-default.css"
        class="template-customizer-theme-css" />
  <link rel="stylesheet" href="./assets/css/demo.css" />
  <link rel="stylesheet"
        href="./assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />
  <link rel="stylesheet"
        href="./assets/vendor/libs/apex-charts/apex-charts.css" />
  <script src="./assets/vendor/js/helpers.js"></script>
  <script src="./assets/js/config.js"></script>
</head>
<body>
<!-- Layout wrapper -->
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
  <div class="layout-container">
    <jsp:include page="./menu.jsp" />
    <!-- Layout container -->
    <div class="layout-page">
      <jsp:include page="./navbar.jsp" />
      <!-- Content wrapper -->
      <div class="content-wrapper">
        <!-- Content -->
        <div class="container-xxl flex-grow-1 container-p-y">
          <h4 class="fw-bold py-3 mb-4">
            <span class="text-muted fw-light">Quản lý/Đơn hàng/</span> Chi
            Tiết
          </h4>
          <!-- Basic Layout & Basic with Icons -->
          <div class="row">
            <!-- Basic Layout -->
            <div class="col-xxl">
              <div class="card mb-4">
                <div
                        class="card-header d-flex align-items-center justify-content-between">
                  <h5 class="mb-0"></h5>
                  <a href="./orders.jsp" class="btn btn-outline-primary">Trở
                    về</a>
                </div>
                <div class="card-body">
                  <form method="post" action="./updateOrder?orderId=${order.id}">
                    <div class="row mb-3">
                      <label class="col-sm-2 col-form-label">ID</label>
                      <div class="col-sm-10">
                        <span class="form-control" name="id">${order.id}</span>
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label class="col-sm-2 col-form-label">Ngày đặt hàng</label>
                      <div class="col-sm-10">
                        <span class="form-control">${order.created}</span>
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label class="col-sm-2 col-form-label">Người đặt</label>
                      <div class="col-sm-10">
                        <span class="form-control">${order.name}</span>
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label class="col-sm-2 col-form-label" for="order-phone">Số
                        điện thoại</label>
                      <div class="col-sm-10">
                        <input type="text" class="form-control" id="order-phone" name="phone"
                               placeholder="${order.phone}" />
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label class="col-sm-2 col-form-label" for="order-address">Địa
                        chỉ</label>
                      <div class="col-sm-10">
                        <input type="text" class="form-control" id="order-address" name="address"
                               placeholder="${order.address}" />
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label class="col-sm-2 col-form-label">Sản phẩm</label>
                      <div class="col-sm-10">
                        <div class="table-responsive text-nowrap">
                          <table class="table table-hover">
                            <thead>
                            <tr>
                              <th>Tên</th>
                              <th>Giá</th>
                              <th>Số lượng</th>
                              <th>Tổng tiền</th>
                            </tr>
                            </thead>
                            <tbody class="table-border-bottom-0">

                            <c:forEach items="${ItemDAO.getAllItemsByOrderId(order)}" var="item">

                              <tr>
                                <td><i class="fab fa-angular fa-lg text-danger"></i>
                                  <strong>${productDAO.getProductsByOrderItem(item.product).name}</strong></td>
                                <td><strong>${productDAO.getProductsByOrderItem(item.product).price}</strong></td>
                                <td><strong class="ms-4">${productDAO.getProductsByOrderItem(item.product).quantity}</strong></td>
                                <td><strong>${productDAO.total(productDAO.getProductsByOrderItem(item.product).quantity,productDAO.getProductsByOrderItem(item.product).price)}</strong></td>
                              </tr>
                            </c:forEach>
                            </tbody>
                          </table>
                        </div>
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label class="col-sm-2 col-form-label">Thành tiền</label>
                      <div class="col-sm-10">
													<span
                                                            class="d-flex justify-content-sm-end fs-large me-4 text-primary"><strong>${order.total}</strong></span>
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label class="col-sm-2 col-form-label">Ghi chú</label>
                      <div class="col-sm-10">
                        <span class="form-control">${order.note}</span>
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label for="order-status" class="col-sm-2 col-form-label">Trạng
                        thái đơn hàng</label>
                      <div class="col-sm-10">
                        <select id="order-status" name="status" class="form-select">
                          <option ${order.status == "Đang xử lý" ? "selected" : ""} value="Đang xử lý">Đang xử lý</option>
                          <option ${order.status == "Đã giao cho đơn vị vận chuyển" ? "selected" : "" } value="Đã giao cho đơn vị vận chuyển">Đã giao cho đơn vị vận chuyển</option>
                          <option ${order.status == "Đã giao thành công" ? "selected" : ""} value="Đã giao thành công">Đã giao thành công</option>
                          <option ${order.status == "Đã hủy đơn" ? "selected" : ""} value="Đã hủy đơn">Đã hủy đơn</option>
                        </select>
                      </div>
                    </div>
                    <div class="row justify-content-end">
                      <div class="col-sm-10" style="text-align: end;">
                        <button type="submit" class="btn btn-primary">Lưu</button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- / Content -->

        <jsp:include page="./footer.jsp" />

        <div class="content-backdrop fade"></div>
      </div>
      <!-- Content wrapper -->
    </div>
    <!-- / Layout page -->
  </div>

  <!-- Overlay -->
  <div class="layout-overlay layout-menu-toggle"></div>
</div>
<!-- / Layout wrapper -->

<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->
<script src="./assets/vendor/libs/jquery/jquery.js"></script>
<script src="./assets/vendor/libs/popper/popper.js"></script>
<script src="./assets/vendor/js/bootstrap.js"></script>
<script
        src="./assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

<script src="./assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->

<!-- Main JS -->
<script src="./assets/js/main.js"></script>

<!-- Active Menu Item -->
<script>
  document.getElementById('menu-managements').classList.add('active',
          'open')
  document.getElementById('menu-managements-orders').classList
          .add('active')
</script>
</body>
</html>
