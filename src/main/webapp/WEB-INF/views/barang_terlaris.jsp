<%-- 
    Document   : barang_terlaris
    Created on : 1 Jan 2025, 16.35.08
    Author     : user
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Barang Terlaris</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>Daftar Barang Terlaris</h2>
            <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Kembali</a>
        </div>

        <div class="card mb-4">
            <div class="card-body">
                <h5 class="card-title">10 Barang Terlaris</h5>
                <p class="card-text">Berdasarkan jumlah penjualan tertinggi</p>
            </div>
        </div>

        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>No</th>
                        <th>Kode Barang</th>
                        <th>Nama Barang</th>
                        <th>Total Terjual</th>
                        <th>Total Pendapatan</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="barang" items="${barangTerlaris}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${barang.kodeBarang}</td>
                            <td>${barang.namaBarang}</td>
                            <td>${barang.jumlah}</td>
                            <td><fmt:formatNumber value="${barang.total}" type="currency" currencySymbol="Rp" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>