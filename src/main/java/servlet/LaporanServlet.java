/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.LaporanPenjualan;
import java.io.IOException;

/**
 *
 * @author user
 */
@WebServlet("/laporan/*")
public class LaporanServlet extends HttpServlet {
    private LaporanPenjualan laporanPenjualan;
    
    @Override
    public void init() throws ServletException {
        laporanPenjualan = new LaporanPenjualan();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        
        try {
            switch (pathInfo) {
                case "/harian" -> {
                    laporanPenjualan.generateLaporanHarian();
                    request.setAttribute("laporanHarian", laporanPenjualan.getLaporanHarian());
                    request.getRequestDispatcher("/WEB-INF/views/laporan_harian.jsp")
                            .forward(request, response);
                }
                    
                case "/mingguan" -> {
                    laporanPenjualan.generateLaporanMingguan();
                    request.setAttribute("laporanMingguan", laporanPenjualan.getLaporanMingguan());
                    request.getRequestDispatcher("/WEB-INF/views/laporan_mingguan.jsp")
                            .forward(request, response);
                }
                    
                case "/bulanan" -> {
                    laporanPenjualan.generateLaporanBulanan();
                    request.setAttribute("laporanBulanan", laporanPenjualan.getLaporanBulanan());
                    request.getRequestDispatcher("/WEB-INF/views/laporan_bulanan.jsp")
                            .forward(request, response);
                }
                    
                case "/terlaris" -> {
                    laporanPenjualan.barangTerlaris();
                    request.setAttribute("barangTerlaris", laporanPenjualan.getTransaksiList());
                    request.getRequestDispatcher("/WEB-INF/views/barang_terlaris.jsp")
                            .forward(request, response);
                }
                    
                default -> response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (ServletException | IOException e) {
            throw new ServletException("Error processing report", e);
        }
    }
}
