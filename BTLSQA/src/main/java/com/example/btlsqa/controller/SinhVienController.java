package com.example.btlsqa.controller;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.model.MonHoc;
import com.example.btlsqa.model.SinhVien;
import com.example.btlsqa.repository.*;
import com.example.btlsqa.service.DangKiHocService;
import com.example.btlsqa.service.MonHocService;
import com.example.btlsqa.service.SinhVienService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SinhVienController {

    @Autowired
    private SinhVienService SinhVienService;
    @Autowired
    private DangKiHocService DangKiHocService;
    @Autowired
    private MonHocService monHocService;

    @RequestMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("username") String username,
            @RequestParam("password") String password,
            RedirectAttributes redirectAttributes,
            Model model,
            HttpSession session) throws ClassNotFoundException, SQLException {

        SinhVien sinhVien = SinhVienService.login(username, password);

        if (username.equals("") || password.equals("")) {
            redirectAttributes.addFlashAttribute("wrongInfo", "Hãy nhập đầy đủ tên đăng nhập và mật khẩu");

            return "redirect:/login";
        }

        if (sinhVien == null) {
            redirectAttributes.addFlashAttribute("wrongInfo", "Sai tên đăng nhập hoặc mật khẩu");

            return "redirect:/login";
        }

        List<DangKiHoc> listDangKiHoc = DangKiHocService.getListDangKiHocBySinhVienId(sinhVien.getId());

        List<MonHoc> monHocList = monHocService.getAllMonHocByDangKiHocId(listDangKiHoc);
        
        session.setAttribute("sinhVien", sinhVien);

        redirectAttributes.addFlashAttribute("dangKiHocList", listDangKiHoc);

        redirectAttributes.addFlashAttribute("monHocList", monHocList);

        return "redirect:/class_registration";
    }
}
