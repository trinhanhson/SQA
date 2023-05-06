/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.btlsqa.controller;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.model.MonHoc;
import com.example.btlsqa.model.SinhVien;
import com.example.btlsqa.repository.DangKiHocRepository;
import com.example.btlsqa.repository.LopHocPhanRepository;
import com.example.btlsqa.repository.MonHocRepository;
import com.example.btlsqa.repository.MonHocTienQuyetRepository;
import com.example.btlsqa.repository.SinhVienRepository;
import com.example.btlsqa.service.MonHocService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
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
    private MonHocService monHocService;
    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;
    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Autowired
    private DangKiHocRepository dangKiHocRepository;

    @RequestMapping(value = "/class_registration")
    public String dashboard(Model model, HttpSession session) {
        SinhVien sinhVien = (SinhVien) session.getAttribute("sinhVien");
        if (sinhVien == null) {
            return "redirect:/login";
        }
        model.addAttribute("sinhVien", sinhVien);
        
        List<DangKiHoc> listDangKiHocMoi = (List<DangKiHoc>)session.getAttribute("listDangKiHocMoi");

        List<MonHoc> monHocList = monHocService.getAllMonHocByDangKiHocId(listDangKiHocMoi);
        
        model.addAttribute("listDangKiHocMoi", listDangKiHocMoi);
        
        model.addAttribute("monHocList", monHocList);
        
        return "class_registration";
    }

    @PostMapping("/chonMon")
    public String goToChonMon(HttpSession session) {
        return "redirect:/choose";
    }
}
