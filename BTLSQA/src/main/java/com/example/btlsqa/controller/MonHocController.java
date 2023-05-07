package com.example.btlsqa.controller;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.model.LopHocPhan;
import com.example.btlsqa.model.MonHoc;
import com.example.btlsqa.model.SinhVien;
import com.example.btlsqa.repository.*;
import com.example.btlsqa.service.DangKiHocService;
import com.example.btlsqa.service.MonHocService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MonHocController {

    @Autowired
    private MonHocService monHocService;
    @Autowired
    private DangKiHocService dangKiHocService;
    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;

    private int idSinhVien = 0;

    @RequestMapping("/choose")
    public String searchByIdOrSubjectName(Model model,
            @RequestParam(value = "maMonHoc", name = "maMonHoc", required = false, defaultValue = "") String maMonHoc, HttpSession session) {
        SinhVien sinhVien = (SinhVien) session.getAttribute("sinhVien");
        if (sinhVien == null) {
            return "redirect:/login";
        }
        idSinhVien = sinhVien.getId();
        List< MonHoc> listMonHoc = monHocService.searchByIdOrSubjectName(maMonHoc);
        model.addAttribute("listMonHoc", listMonHoc);
        model.addAttribute("maMonHoc", maMonHoc);
        return "choose_a_subject";
    }

    @GetMapping("/choose/{id}")
    public String checkChooseSubject(@PathVariable("id") String id, Model model, RedirectAttributes ra, HttpSession session) {

        SinhVien sinhVien = (SinhVien) session.getAttribute("sinhVien");
        if (sinhVien == null) {
            return "redirect:/login";
        }
        boolean flag = monHocService.checkPrerequisitesSubject(idSinhVien, id);
        if (flag) {

            DangKiHoc dk = getDangKiHocMoi(id, (List<DangKiHoc>) session.getAttribute("listDangKiHocMoi"));
            if (dk != null) {
                model.addAttribute("id", dk.getLopHocPhan().getId());
            } else {
                model.addAttribute("id", -1);
            }

            List<LopHocPhan> listLopHocPhan = lopHocPhanRepository.findByMonHocId(id);
            model.addAttribute("listLopHocPhan", listLopHocPhan);
            return "select_class_section";
        } else {
            ra.addFlashAttribute("message", "Sinh viên chưa hoàn thành môn tiên quyết của môn học này");
            return "redirect:/choose";
        }
    }

    private DangKiHoc getDangKiHocMoi(String idMonHoc, List<DangKiHoc> listDangKiHocMoi) {
        for (DangKiHoc i : listDangKiHocMoi) {
            if (idMonHoc.equals(i.getLopHocPhan().getMonHoc().getId())) {
                return i;
            }
        }
        return null;
    }
}
