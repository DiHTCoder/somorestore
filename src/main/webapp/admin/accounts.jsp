<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
		 isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="utf-8" />
	<meta name="viewport"
		  content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
	<title>Managements | Products</title>
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
	<style>
		th {
			padding: 10px !important;
		}

		td {
			padding: 10px !important;
		}
	</style>
</head>
<body>
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
	<div class="layout-container">
		<jsp:include page="./menu.jsp" />
		<!-- Layout container -->
		<div class="layout-page">
			<jsp:include page="./navbar.jsp" />
			<!-- Content wrapper -->
			<div class="content-wrapper">
				<div class="container-xxl flex-grow-1 container-p-y">
					<h4 class="py-3 mb-4">
						<a href="${pageContext.request.contextPath}/admin">Quản lý >
						</a> <span class="fw-bold">Tài khoản</span>
					</h4>
					<div class="card">
						<h5 class="card-header">Tài khoản</h5>
						<div class="table-responsive text-nowrap">
							<table class="table table-hover">
								<thead>
								<tr>
									<th>Username</th>
									<th>Tên</th>
									<th style="height: 30px;">Địa chỉ</th>
									<th>Giới tính</th>
									<th>Số điện thoai</th>
									<th>CartId</th>
								</tr>
								</thead>
								<tbody class="table-border-bottom-0">
								<c:forEach items="${users}" var="user">
									<tr>
										<td><strong>${user.username}</strong></td>
										<td>${user.name}</td>
										<td>${user.address}</td>
										<td>${user.gender}</td>
										<td>${user.phone}</td>
										<td>${user.cart.id}</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
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
<!-- end-build -->

<!-- Main JS -->
<script src="./assets/js/main.js"></script>

<!-- Page JS -->
<!-- Active Menu Item -->
<script>
	document.getElementById('menu-managements').classList.add('active',
			'open')
	document.getElementById('menu-managements-accounts').classList
			.add('active')
</script>
</body>
</html>