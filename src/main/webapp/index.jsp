<%-- 
    Document   : index
    Created on : 1 Jan 2025, 16.16.24
    Author     : user
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sistem Laporan Penjualan</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Sistem Laporan Penjualan</h2>
        <div class="row">
            <div class="col-md-3 mb-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Laporan Harian</h5>
                        <a href="${pageContext.request.contextPath}/laporan/harian" class="btn btn-primary">Lihat Laporan</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3 mb-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Laporan Mingguan</h5>
                        <a href="${pageContext.request.contextPath}/laporan/mingguan" class="btn btn-primary">Lihat Laporan</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3 mb-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Laporan Bulanan</h5>
                        <a href="${pageContext.request.contextPath}/laporan/bulanan" class="btn btn-primary">Lihat Laporan</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3 mb-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Barang Terlaris</h5>
                        <a href="${pageContext.request.contextPath}/laporan/terlaris" class="btn btn-primary">Lihat Laporan</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
