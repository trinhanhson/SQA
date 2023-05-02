package com.example.btlsqa.controller;

import com.example.btlsqa.model.LopHocPhan;
import com.example.btlsqa.model.MonHoc;
import com.example.btlsqa.repository.*;
import com.example.btlsqa.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MonHocController {
    @Autowired
    private MonHocService monHocService;
    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;

    private int idSinhVien = 0;

    @GetMapping("/setid")
    public String setIdSv(RedirectAttributes ra, @RequestParam("idSv") int idSv) {
        idSinhVien = idSv;
        return "redirect:/choose";
    }

    @GetMapping("/choose")
    public String searchByIdOrSubjectName(Model model,
                                 @RequestParam(value = "maMonHoc", name = "maMonHoc", required = false, defaultValue = "") String maMonHoc) {
        List<MonHoc> listMonHoc = monHocService.searchByIdOrSubjectName(maMonHoc);
        model.addAttribute("listMonHoc", listMonHoc);
        model.addAttribute("maMonHoc", maMonHoc);
        return "choose_a_subject";
    }

    @GetMapping("/choose/{id}")
    public String checkChooseSubject(@PathVariable("id") String id, Model model, RedirectAttributes ra) {
        boolean flag = monHocService.checkPrerequisitesSubject(idSinhVien, id);
        if (flag) {
            List<LopHocPhan> listLopHocPhan = lopHocPhanRepository.findByMonHocId(id);
            model.addAttribute("listLopHocPhan", listLopHocPhan);
            return "select_class_section";
        } else {
            ra.addFlashAttribute("message", "Sinh viên chưa hoàn thành môn tiên quyết của môn học này");
            return "redirect:/choose";
        }
    }
}
