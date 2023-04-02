/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.DAO;

import com.example.demo.Model.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class SinhVienDAO extends DAO {

    private static final String LOGIN_STRING = "SELECT * FROM SinhVien WHERE tenDangNhap = ? AND matKhau = ?";

    public SinhVienDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    public SinhVien getSinhVien(String tenDangNhap, String matKhau) throws SQLException {
        SinhVien sinhvien = null;
        
        Connection conn=getConnection();
        
        PreparedStatement stmt = conn.prepareStatement(LOGIN_STRING);
        stmt.setString(1, tenDangNhap);
        stmt.setString(2, matKhau);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            sinhvien = new SinhVien();
            sinhvien.setId(rs.getInt("id"));
            sinhvien.setTenDangNhap(rs.getString("tenDangNhap"));
            sinhvien.setMatKhau(rs.getString("matKhau"));
            sinhvien.setHoTen(rs.getString("hoTen"));
            sinhvien.setMaSinhVien(rs.getString("maSinhVien"));
        }

        rs.close();
        stmt.close();

        return sinhvien;
    }

}
