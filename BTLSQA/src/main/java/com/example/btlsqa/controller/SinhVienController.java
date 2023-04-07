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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(Model model) throws ClassNotFoundException, SQLException {
        
        SinhVien sinhVien = (SinhVien) model.asMap().get("sinhVien");
        
        List<DangKiHoc> dangKiHocList =dangKiHocRepository.findAllLopHocPhanDangDangKiBySinhVienId(sinhVien.getId());
        
        List<MonHoc> monHocList=new ArrayList<>();
        
        for(DangKiHoc i : dangKiHocList){
            Optional<MonHoc> monHoc = monHocRepository.findByLopHocPhanId(i.getLopHocPhan().getId());
            monHocList.add(monHoc.get());
        }
        
        model.addAttribute("dangKiHocList",dangKiHocList);
        
        model.addAttribute("monHocList",monHocList);

        return "dashboard";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("username") String username,
            @RequestParam("password") String password, RedirectAttributes redirectAttributes) throws ClassNotFoundException, SQLException {

        SinhVien sinhVien = sinhVienRepository.findByTenDangNhapVaMatKhau(username, password);

        if (sinhVien != null) {
            redirectAttributes.addFlashAttribute("sinhVien", sinhVien);
            return "redirect:/dashboard";
        } else {
            return "login";
        }
//         return "login";
    }
}
