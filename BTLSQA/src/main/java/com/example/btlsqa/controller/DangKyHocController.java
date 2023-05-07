/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.btlsqa.controller;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.model.SinhVien;
import com.example.btlsqa.repository.DangKiHocRepository;
import com.example.btlsqa.repository.LopHocPhanRepository;
import com.example.btlsqa.repository.MonHocTienQuyetRepository;
import com.example.btlsqa.repository.SinhVienRepository;
import com.example.btlsqa.service.DangKiHocService;
import com.example.btlsqa.service.MonHocService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    private DangKiHocService dangKiHocService;
    @Autowired
    private DangKiHocRepository dangKiHocRepository;

    @GetMapping("/class_registration")
    public String dashboard(Model model, HttpSession session) {
        SinhVien sinhVien = (SinhVien) session.getAttribute("sinhVien");
        if (sinhVien == null) {
            return "redirect:/login";
        }
        model.addAttribute("sinhVien", sinhVien);

        List<DangKiHoc> listDangKiHocMoi = (List< DangKiHoc>) session.getAttribute("listDangKiHocMoi");

        int stc = 0;
        for (DangKiHoc i : listDangKiHocMoi) {
            stc += i.getLopHocPhan().getMonHoc().getSoTinChi();
        }

        String tkbMatrix[][] = taoTkbMatrix(listDangKiHocMoi);

        session.setAttribute("tkbMatrix", tkbMatrix);

        model.addAttribute("stc", stc);

        model.addAttribute("listDangKiHocMoi", listDangKiHocMoi);

        return "class_registration";
    }

    @PostMapping("/chonMon")
    public String goToChonMon(HttpSession session) {
        return "redirect:/choose";
    }

    @GetMapping("/xoaDangKi/{id}")
    public String xoaDangKi(@PathVariable("id") int id, HttpSession session) {
        List<DangKiHoc> listDangKiHocMoi = (List<DangKiHoc>) session.getAttribute("listDangKiHocMoi");

        for (int i = 0; i < listDangKiHocMoi.size(); i++) {
            if (listDangKiHocMoi.get(i).getId() == id) {
                listDangKiHocMoi.remove(i);
                break;
            }
        }

        session.setAttribute("listDangKiHocMoi", listDangKiHocMoi);

        return "redirect:/class_registration";

    }

    @PostMapping("/luuDangKi")
    public String luuDangKi(HttpSession session) {
        SinhVien sinhVien = (SinhVien) session.getAttribute("sinhVien");
        if (sinhVien == null) {
            return "redirect:/login";
        }
        List<DangKiHoc> listDangKiHocMoi = (List<DangKiHoc>) session.getAttribute("listDangKiHocMoi");

        dangKiHocRepository.deleteBySinhVien(sinhVien);

        for (DangKiHoc i : listDangKiHocMoi) {
            i.setSoLanHoc(0);
            dangKiHocRepository.save(i);
        }

        session.setAttribute("listDangKiHocMoi", listDangKiHocMoi);

        return "redirect:/class_registration";
    }

    private String[][] taoTkbMatrix(List<DangKiHoc> listDangKiHoc) {
        String tbkMatrix[][] = new String[7][9];

        for (DangKiHoc i : listDangKiHoc) {
            for (int j = 0; j < i.getLopHocPhan().getSoTiet(); j++) {
                tbkMatrix[i.getLopHocPhan().getThu()][i.getLopHocPhan().getTietBatDau() + j] = i.getLopHocPhan().getMonHoc().getId();
            }
        }

        return tbkMatrix;
    }
}
