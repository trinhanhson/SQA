package com.example.btlsqa.controller;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.model.SinhVien;
import com.example.btlsqa.service.DangKiHocService;
import com.example.btlsqa.service.SinhVienService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.List;

@Controller
public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;
    @Autowired
    private DangKiHocService dangKiHocService;

    @GetMapping(value = "/login")
    public String login(HttpSession session) {

        SinhVien sinhVien = (SinhVien) session.getAttribute("sinhVien");
        if (sinhVien != null) {
            return "redirect:/class_registration";
        }

        return "login";
    }

    @PostMapping("/checkLogin")
    public String handleLogin(@RequestParam("username") String username,
            @RequestParam("password") String password,
            RedirectAttributes redirectAttributes,
            Model model,
            HttpSession session) throws ClassNotFoundException, SQLException {

        SinhVien sinhVien = sinhVienService.login(username, password);

        if (username.equals("") || password.equals("")) {
            redirectAttributes.addFlashAttribute("wrongInfo", "Hãy nhập đầy đủ tên đăng nhập và mật khẩu");

            return "redirect:/login";
        }

        if (sinhVien == null) {
            redirectAttributes.addFlashAttribute("wrongInfo", "Sai tên đăng nhập hoặc mật khẩu");

            return "redirect:/login";
        }

        List<DangKiHoc> listDangKiHocMoi = dangKiHocService.getListDangKiHocBySinhVienId(sinhVien.getId());

        session.setAttribute("listDangKiHocMoi", listDangKiHocMoi);

        session.setAttribute("sinhVien", sinhVien);

        return "redirect:/class_registration";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}
