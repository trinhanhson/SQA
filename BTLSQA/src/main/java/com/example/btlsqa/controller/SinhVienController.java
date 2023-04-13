
package com.example.btlsqa.controller;

//import com.example.demo.DAO.DangKiHocDAO;
//import com.example.demo.DAO.LopHocPhanDAO;
//import com.example.demo.DAO.MonHocDAO;
//import com.example.demo.DAO.SinhVienDAO;
//import com.example.demo.Model.DangKiHoc;
//import com.example.demo.Model.MonHoc;
//import com.example.demo.Model.SinhVien;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.model.MonHoc;
import com.example.btlsqa.model.SinhVien;
import com.example.btlsqa.repository.*;
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

        // chưa có hàm findByLopHocPhanId trong monHocRepository
//        for(DangKiHoc i : dangKiHocList){
//            Optional<MonHoc> monHoc = monHocRepository.findByLopHocPhanId(i.getLopHocPhan().getId());
//            monHocList.add(monHoc.get());
//        }

        model.addAttribute("dangKiHocList",dangKiHocList);

        model.addAttribute("monHocList",monHocList);

        return "dashboard";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              RedirectAttributes redirectAttributes,
                              Model model) throws ClassNotFoundException, SQLException {

        SinhVien sinhVien = sinhVienRepository.findByTenDangNhapVaMatKhau(username, password);

        if (sinhVien != null) {
            redirectAttributes.addFlashAttribute("sinhVien", sinhVien);
            model.addAttribute("idSv", sinhVien.getId());
            return "redirect:/setid?idSv=" + sinhVien.getId();
        } else {
            return "login";
        }
    }
}
