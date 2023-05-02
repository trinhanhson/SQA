/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.btlsqa.controller;

import com.example.btlsqa.model.SinhVien;
import com.example.btlsqa.repository.DangKiHocRepository;
import com.example.btlsqa.repository.LopHocPhanRepository;
import com.example.btlsqa.repository.MonHocRepository;
import com.example.btlsqa.repository.MonHocTienQuyetRepository;
import com.example.btlsqa.repository.SinhVienRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class DangKyHocController {

    @Autowired
    private MonHocTienQuyetRepository repository;
    @Autowired
    private MonHocRepository monHocRepository;
    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;
    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Autowired
    private DangKiHocRepository dangKiHocRepository;

    @RequestMapping(value = "/dashboard")
    public String dashboard(Model model, HttpSession session) {
        SinhVien sinhVien = (SinhVien) session.getAttribute("sinhVien");
        model.addAttribute("sinhVien", sinhVien);
        return "dashboard";
    }
    
    @PostMapping("/chonMon")
    public String goToChonMon(HttpSession session){
        SinhVien sinhVien=(SinhVien) session.getAttribute("sinhVien");
        return "redirect:/setid?idSv="+sinhVien.getId();
    }
}
