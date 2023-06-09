/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.btlsqa.controller;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.model.LopHocPhan;
import com.example.btlsqa.model.SinhVien;
import com.example.btlsqa.repository.LopHocPhanRepository;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ADMIN
 */
@Controller
public class LopHocPhanController {

    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;
    
    @PostMapping("/chonLopHocPhan")
    public String chonLopHocPhan(@RequestParam(name = "lophoc", required = false, defaultValue = "0") long newId, @RequestParam("id") long oldId, HttpSession session, RedirectAttributes ra) {

        SinhVien sinhVien = (SinhVien) session.getAttribute("sinhVien");
        if (sinhVien == null) {
            return "redirect:/login";
        }

        if ((oldId == -1 && newId == 0) || (oldId == newId)) {
            return "redirect:/class_registration";
        }

        if (oldId == -1 && newId != 0) {
            Optional<LopHocPhan> lhp = lopHocPhanRepository.findById(newId);

            LopHocPhan trueLhp = lhp.get();

            String tkbMatrix[][] = (String[][]) session.getAttribute("tkbMatrix");

            for (int i = 0; i < trueLhp.getSoTiet(); i++) {
                if (tkbMatrix[trueLhp.getThu()][trueLhp.getTietBatDau() + i] != null) {
                    ra.addFlashAttribute("message", "Thời khóa biểu bị trùng với học phần khác");
                    return "redirect:/choose/" + trueLhp.getMonHoc().getId();
                }
            }

            List<DangKiHoc> listDangKiHocMoi = (List<DangKiHoc>) session.getAttribute("listDangKiHocMoi");

            DangKiHoc dk = new DangKiHoc();

            dk.setDiemTongKet(0);
            dk.setLopHocPhan(trueLhp);
            dk.setSoLanHoc(-1);
            dk.setSinhVien(sinhVien);

            listDangKiHocMoi.add(dk);

            session.setAttribute("listDangKiHocMoi", listDangKiHocMoi);

            return "redirect:/class_registration";
        }

        if (oldId != -1 && newId != 0) {
            Optional<LopHocPhan> lhp = lopHocPhanRepository.findById(newId);

            LopHocPhan trueLhp = lhp.get();

            String tkbMatrix[][] = (String[][]) session.getAttribute("tkbMatrix");

            for (int i = 0; i < trueLhp.getSoTiet(); i++) {
                if (tkbMatrix[trueLhp.getThu()][trueLhp.getTietBatDau() + i] != null && tkbMatrix[trueLhp.getThu()][trueLhp.getTietBatDau() + i].equals(trueLhp.getMonHoc().getId())) {
                    ra.addFlashAttribute("message", "Thời khóa biểu bị trùng với học phần khác");
                    return "redirect:/choose/" + trueLhp.getMonHoc().getId();
                }
            }

            DangKiHoc dk = new DangKiHoc();

            List<DangKiHoc> listDangKiHocMoi = (List<DangKiHoc>) session.getAttribute("listDangKiHocMoi");

            for (int i = 0; i < listDangKiHocMoi.size(); i++) {
                if (listDangKiHocMoi.get(i).getLopHocPhan().getId() == oldId) {
                    dk = listDangKiHocMoi.remove(i);
                    break;
                }
            }
            dk.setDiemTongKet(0);
            dk.setLopHocPhan(trueLhp);
            dk.setSoLanHoc(-1);

            listDangKiHocMoi.add(dk);

            session.setAttribute("listDangKiHocMoi", listDangKiHocMoi);

            return "redirect:/class_registration";
        }

        List<DangKiHoc> listDangKiHocMoi = (List<DangKiHoc>) session.getAttribute("listDangKiHocMoi");

        for (int i = 0; i < listDangKiHocMoi.size(); i++) {
            if (listDangKiHocMoi.get(i).getLopHocPhan().getId() == oldId) {
                listDangKiHocMoi.remove(i);
                break;
            }
        }

        session.setAttribute("listDangKiHocMoi", listDangKiHocMoi);

        return "redirect:/class_registration";

    }
}
