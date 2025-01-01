/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import interfaces.LaporanGenerator;
import config.DatabaseConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author user
 */
public class LaporanPenjualan implements LaporanGenerator {
    private static final Logger logger = LoggerFactory.getLogger(LaporanPenjualan.class);
    
    private String periode;
    private final List<Transaksi> transaksiList;
    private final List<Transaksi> laporanHarian;
    private final List<Transaksi> laporanMingguan;
    private final List<Transaksi> laporanBulanan;
    private final Connection connection;

    public LaporanPenjualan() {
        this.transaksiList = new ArrayList<>();
        this.laporanHarian = new ArrayList<>();
        this.laporanMingguan = new ArrayList<>();
        this.laporanBulanan = new ArrayList<>();
        this.connection = DatabaseConfig.getConnection();
    }

    @Override
    public void generateLaporanHarian() {
        try {
            String query = "SELECT * FROM transaksi WHERE DATE(tanggal) = CURRENT_DATE()";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            laporanHarian.clear();
            while (rs.next()) {
                laporanHarian.add(mapResultSetToTransaksi(rs));
            }
            logger.info("Generated daily report with {} transactions", laporanHarian.size());
        } catch (SQLException e) {
            logger.error("Error generating daily report", e);
            throw new RuntimeException("Error generating daily report", e);
        }
    }

    @Override
    public void generateLaporanMingguan() {
        try {
            String query = "SELECT * FROM transaksi WHERE tanggal >= DATE_SUB(CURRENT_DATE(), INTERVAL 7 DAY)";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            laporanMingguan.clear();
            while (rs.next()) {
                laporanMingguan.add(mapResultSetToTransaksi(rs));
            }
            logger.info("Generated weekly report with {} transactions", laporanMingguan.size());
        } catch (SQLException e) {
            logger.error("Error generating weekly report", e);
            throw new RuntimeException("Error generating weekly report", e);
        }
    }

    @Override
    public void generateLaporanBulanan() {
        try {
            String query = "SELECT * FROM transaksi WHERE YEAR(tanggal) = YEAR(CURRENT_DATE()) " +
                          "AND MONTH(tanggal) = MONTH(CURRENT_DATE())";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            laporanBulanan.clear();
            while (rs.next()) {
                laporanBulanan.add(mapResultSetToTransaksi(rs));
            }
            logger.info("Generated monthly report with {} transactions", laporanBulanan.size());
        } catch (SQLException e) {
            logger.error("Error generating monthly report", e);
            throw new RuntimeException("Error generating monthly report", e);
        }
    }

    @Override
    public void barangTerlaris() {
        try {
            String query = "SELECT kode_barang, nama_barang, SUM(jumlah) as total_terjual, " +
                          "SUM(total) as total_penjualan FROM transaksi " +
                          "GROUP BY kode_barang, nama_barang " +
                          "ORDER BY total_terjual DESC LIMIT 10";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            transaksiList.clear();
            while (rs.next()) {
                Transaksi t = new Transaksi();
                t.setKodeBarang(rs.getString("kode_barang"));
                t.setNamaBarang(rs.getString("nama_barang"));
                t.setJumlah(rs.getInt("total_terjual"));
                t.setTotal(rs.getBigDecimal("total_penjualan"));
                transaksiList.add(t);
            }
            logger.info("Generated best-selling items report");
        } catch (SQLException e) {
            logger.error("Error generating best-selling items report", e);
            throw new RuntimeException("Error generating best-selling items report", e);
        }
    }

    public void cetakLaporan() {
        // Implementation for printing the report
        logger.info("Printing sales report for period: {}", periode);
        // Add your report printing logic here
    }

    private Transaksi mapResultSetToTransaksi(ResultSet rs) throws SQLException {
        Transaksi t = new Transaksi();
        t.setId(rs.getLong("id"));
        t.setTanggal(rs.getTimestamp("tanggal"));
        t.setKodeBarang(rs.getString("kode_barang"));
        t.setNamaBarang(rs.getString("nama_barang"));
        t.setJumlah(rs.getInt("jumlah"));
        t.setHarga(rs.getBigDecimal("harga"));
        t.setTotal(rs.getBigDecimal("total"));
        return t;
    }

    // Getters and Setters
    public String getPeriode() { return periode; }
    public void setPeriode(String periode) { this.periode = periode; }
    public List<Transaksi> getTransaksiList() { return transaksiList; }
    public List<Transaksi> getLaporanHarian() { return laporanHarian; }
    public List<Transaksi> getLaporanMingguan() { return laporanMingguan; }
    public List<Transaksi> getLaporanBulanan() { return laporanBulanan; }
}
