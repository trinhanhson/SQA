/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.DAO;

import com.example.demo.Model.MonHoc;
import com.example.demo.Model.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class MonHocDAO extends DAO {

    private static final String GET_MON_HOC = "SELECT * FROM MonHoc WHERE id = ?";

    public MonHocDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    public MonHoc getMonHoc(String id) throws SQLException {
        MonHoc monHoc = null;

        Connection conn = getConnection();

        PreparedStatement stmt = conn.prepareStatement(GET_MON_HOC);
        stmt.setString(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            monHoc = new MonHoc();
            monHoc.setId(rs.getString("id"));
            monHoc.setTen(rs.getString("ten"));
            monHoc.setSoTinChi(rs.getInt("soTinChi"));
        }

        rs.close();
        stmt.close();

        return monHoc;
    }
}
