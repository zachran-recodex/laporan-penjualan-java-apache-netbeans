/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class Transaksi {
    private Long id;
    private Date tanggal;
    private String kodeBarang;
    private String namaBarang;
    private Integer jumlah;
    private BigDecimal harga;
    private BigDecimal total;

    public Transaksi() {}

    public Transaksi(Long id, Date tanggal, String kodeBarang, String namaBarang, 
                     Integer jumlah, BigDecimal harga) {
        this.id = id;
        this.tanggal = tanggal;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
        this.harga = harga;
        this.total = harga.multiply(new BigDecimal(jumlah));
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Date getTanggal() { return tanggal; }
    public void setTanggal(Date tanggal) { this.tanggal = tanggal; }
    public String getKodeBarang() { return kodeBarang; }
    public void setKodeBarang(String kodeBarang) { this.kodeBarang = kodeBarang; }
    public String getNamaBarang() { return namaBarang; }
    public void setNamaBarang(String namaBarang) { this.namaBarang = namaBarang; }
    public Integer getJumlah() { return jumlah; }
    public void setJumlah(Integer jumlah) { this.jumlah = jumlah; }
    public BigDecimal getHarga() { return harga; }
    public void setHarga(BigDecimal harga) { this.harga = harga; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
