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
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class LopHocPhanDAO extends DAO {

    private static final String GET_MON_HOC_ID_LOP_HOC_PHAN = "SELECT * FROM DangKiHoc WHERE id = ?";

    public LopHocPhanDAO() throws ClassNotFoundException, SQLException {
    }

    public String getMonHocIdLopHocPhan(int id) throws SQLException {
        String monHocId = null;

        Connection conn = getConnection();

        PreparedStatement stmt = conn.prepareStatement(GET_MON_HOC_ID_LOP_HOC_PHAN);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            monHocId = rs.getString("monHocId");
        }

        rs.close();
        stmt.close();

        return monHocId;
    }

}
