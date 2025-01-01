<%-- 
    Document   : laporan_mingguan
    Created on : 1 Jan 2025, 16.34.12
    Author     : user
--%>

<!-- src/main/webapp/WEB-INF/views/laporan_mingguan.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Laporan Penjualan Mingguan</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>Laporan Penjualan Mingguan</h2>
            <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Kembali</a>
        </div>
        
        <div class="card mb-4">
            <div class="card-body">
                <h5 class="card-title">Ringkasan Mingguan</h5>
                <div class="row">
                    <div class="col-md-4">
                        <p>Total Transaksi: ${laporanMingguan.size()}</p>
                    </div>
                    <div class="col-md-4">
                        <p>Total Pendapatan: 
                            <fmt:formatNumber value="${laporanMingguan.stream().map(t -> t.getTotal()).sum()}" 
                                            type="currency" currencySymbol="Rp" />
                        </p>
                    </div>
                </div>
            </div>
        </div>

        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>Tanggal</th>
                        <th>Kode Barang</th>
                        <th>Nama Barang</th>
                        <th>Jumlah</th>
                        <th>Harga</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="transaksi" items="${laporanMingguan}">
                        <tr>
                            <td><fmt:formatDate value="${transaksi.tanggal}" pattern="dd/MM/yyyy HH:mm" /></td>
                            <td>${transaksi.kodeBarang}</td>
                            <td>${transaksi.namaBarang}</td>
                            <td>${transaksi.jumlah}</td>
                            <td><fmt:formatNumber value="${transaksi.harga}" type="currency" currencySymbol="Rp" /></td>
                            <td><fmt:formatNumber value="${transaksi.total}" type="currency" currencySymbol="Rp" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
