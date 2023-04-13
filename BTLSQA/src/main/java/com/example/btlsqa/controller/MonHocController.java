package com.example.btlsqa.controller;

import com.example.btlsqa.model.LopHocPhan;
import com.example.btlsqa.model.MonHoc;
import com.example.btlsqa.repository.*;
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
    private MonHocTienQuyetRepository repository;
    @Autowired
    private MonHocRepository monHocRepository;
    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;
    @Autowired
    private DangKiHocRepository dangKiHocRepository;

    private int idSinhVien = 0;

    @GetMapping("/setid")
    public String setIdSv(RedirectAttributes ra, @RequestParam("idSv") int idSv) {
        idSinhVien = idSv;
        return "redirect:/choose";
    }

    @GetMapping("/choose")
    public String searchIdMonHoc(Model model,
                                 @RequestParam(value = "maMonHoc", name = "maMonHoc", required = false, defaultValue = "") String maMonHoc) {
        List<MonHoc> listMonHoc = monHocRepository.findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(maMonHoc, maMonHoc);
        model.addAttribute("listMonHoc", listMonHoc);
        model.addAttribute("maMonHoc", maMonHoc);
        return "choose_a_subject";
    }

    @GetMapping("/choose/{id}")
    public String check(@PathVariable("id") String id, Model model, RedirectAttributes ra) {

        // danh sách môn học sinh viên có id = idSinhVien đã hoàn thành
        List<String> finish = dangKiHocRepository.findMonHocBySinhVienId(idSinhVien);

        boolean flag = true;
        //danh sách môn học tiên quyết
        List<String> needToFinish = repository.findByMonHocId(id);
        for (String x : needToFinish) {
            if (!finish.contains(x)) {
                flag = false;
                break;
            }
        }

        if (flag) {
            List<LopHocPhan> listLopHocPhan = lopHocPhanRepository.findByMonHocId(id);
            model.addAttribute("listLopHocPhan", listLopHocPhan);
            return "select_class_section";
        } else {
            ra.addFlashAttribute("message", "Sinh viên chưa đăng kí học môn tiên quyết của môn học này");
            return "redirect:/choose";
        }
    }

}
