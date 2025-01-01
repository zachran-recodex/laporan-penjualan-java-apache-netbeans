<%-- 
    Document   : laporan_harian
    Created on : 1 Jan 2025, 16.17.33
    Author     : user
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Laporan Penjualan Harian</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Laporan Penjualan Harian</h2>
        <a href="${pageContext.request.contextPath}/" class="btn btn-secondary mb-3">Kembali</a>
        
        <table class="table table-striped">
            <thead>
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
                <c:forEach var="transaksi" items="${laporanHarian}">
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>