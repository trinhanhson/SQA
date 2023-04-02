/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.DAO;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.DangKiHoc;
import com.example.demo.Model.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DangKiHocDAO extends DAO {

    private static final String GET_DANG_KI_HOC = "SELECT * FROM DangKiHoc WHERE maSinhVien = ?";

    public DangKiHocDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    public ArrayList<DangKiHoc> getListDangKiHoc(String maSinhVien) throws SQLException {
        ArrayList<DangKiHoc> listDangKiHocs = new ArrayList<>();

        Connection conn = getConnection();

        PreparedStatement stmt = conn.prepareStatement(GET_DANG_KI_HOC);
        stmt.setString(1, maSinhVien);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            DangKiHoc dangKiHoc = new DangKiHoc();
            dangKiHoc.setId(rs.getInt("id"));
            dangKiHoc.setDiemTongKet(rs.getFloat("diemTongKet"));
            dangKiHoc.setSoLanHoc(rs.getInt("soLanHoc"));
            dangKiHoc.setMaSinhVien(rs.getString("maSinhVien"));
            dangKiHoc.setLopHocPhanId(rs.getInt("lopHocPhanId"));
            if (dangKiHoc.getSoLanHoc() == 0) {
                listDangKiHocs.add(dangKiHoc);
            }
        }

        rs.close();
        stmt.close();

        return listDangKiHocs;
    }
}
