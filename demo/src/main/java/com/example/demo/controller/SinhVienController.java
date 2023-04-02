/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.DAO.DangKiHocDAO;
import com.example.demo.DAO.LopHocPhanDAO;
import com.example.demo.DAO.MonHocDAO;
import com.example.demo.DAO.SinhVienDAO;
import com.example.demo.Model.DangKiHoc;
import com.example.demo.Model.MonHoc;
import com.example.demo.Model.SinhVien;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ADMIN
 */
@Controller
public class SinhVienController {

    @RequestMapping(value = "/")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(Model model) throws ClassNotFoundException, SQLException {

        SinhVien sinhVien = (SinhVien) model.asMap().get("sinhVien");

        DangKiHocDAO dangKiHocDAO = new DangKiHocDAO();

        LopHocPhanDAO lopHocPhanDAO = new LopHocPhanDAO();

        MonHocDAO monHocDAO = new MonHocDAO();

        ArrayList<DangKiHoc> dangKiHocList = dangKiHocDAO.getListDangKiHoc(sinhVien.getMaSinhVien());

        ArrayList<String> monHocIdList = new ArrayList<>();

        ArrayList<MonHoc> mocHocList = new ArrayList<>();

        for (DangKiHoc iDangKiHoc : dangKiHocList) {
            String monHocID = lopHocPhanDAO.getMonHocIdLopHocPhan(iDangKiHoc.getLopHocPhanId());
            MonHoc monHoc = monHocDAO.getMonHoc(monHocID);
            
            monHocIdList.add(monHocID);
            
            mocHocList.add(monHoc);
        }

        model.addAttribute("sinhVien", sinhVien);
        
        model.addAttribute("monHocIdList",monHocIdList);
        
        model.addAttribute("mocHocList",mocHocList);

        return "dashboard";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("username") String username,
            @RequestParam("password") String password, RedirectAttributes redirectAttributes) throws ClassNotFoundException, SQLException {

        SinhVienDAO sinhVienDAO = new SinhVienDAO();

        SinhVien sinhVien = sinhVienDAO.getSinhVien(username, password);

        if (sinhVien != null) {
            redirectAttributes.addFlashAttribute("sinhVien", sinhVien);
            return "redirect:/dashboard";
        } else {
            return "login";
        }
    }
}
