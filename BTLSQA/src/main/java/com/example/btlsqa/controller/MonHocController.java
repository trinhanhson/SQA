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
    private SinhVienRepository sinhVienRepository;
    @Autowired
    private DangKiHocRepository dangKiHocRepository;


    @GetMapping("/chonMonHoc")
    public String showHomePage() {
        return "choose_a_subject";
    }

    @GetMapping("/search")
    public String searchIdMonHoc(Model model, @RequestParam(value = "maMonHoc", name = "maMonHoc", required = false, defaultValue = "") String maMonHoc) {
        List<MonHoc> listMonHoc = monHocRepository.findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(maMonHoc, maMonHoc);
        model.addAttribute("listMonHoc", listMonHoc);
        model.addAttribute("maMonHoc", maMonHoc);
        return "choose_a_subject";
    }

    @GetMapping("/search/{id}")
    public String check(@PathVariable("id") String id, Model model, RedirectAttributes ra) {
//        SinhVien sinhVien = sinhVienRepository.findById(1);
//        List<String> finish = List.of(new String[]{"BAS1201", "BAS1203", "BAS1150", "INT1154"});
//        List<String> finish = List.of(new String[]{"BAS1201", "BAS1150", "INT1154"});
//        finish.add(new MonHoc("BAS1201","Đại số",3));
//        finish.add(new MonHoc("BAS1203","Giải tích 1",3));
//        finish.add(new MonHoc("BAS1150","Triết học Mác-Lenin",3));
//        finish.add(new MonHoc("INT1154","Tin học cơ sở 1",2));

        // danh sách môn học đã hoàn thành // của sinh viên có id = 2
        List<String> finish = dangKiHocRepository.findMonHocBySinhVienId(2);

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
            return "redirect:/search";
        }
    }

//    @PostMapping("/search")
//    public String clickMonHocsearchlHP(Model model, @RequestParam(name = "lophoc", required = false) String monHocId){
//        List<LopHocPhan> listLopHocPhan = lopHocPhanRepository.findByMonHocId(monHocId);
//        model.addAttribute("listLopHocPhan", listLopHocPhan);
//        return "redirect:/";
//    }

//    @GetMapping("/search")
//    public String search(@RequestParam(name = "maMonHoc", required = false) String maMonHoc, Model model) {
//        List<LopHocPhan> listLopHocPhan = new ArrayList<>();
//        if (maMonHoc != null) {
//            MonHoc monHoc = monHocRepository.findById(String.valueOf(Long.valueOf(maMonHoc))).orElse(null);
//            if (monHoc != null) {
//                listLopHocPhan = lopHocPhanRepository.findById(monHoc.getId());
//            }
//        }
//        model.addAttribute("listLopHocPhan", listLopHocPhan);
//        model.addAttribute("maMonHoc", maMonHoc);
//        model.addAttribute("listMonHoc", monHocRepository.findAll());
//        return "search";
//    }

//    @GetMapping("/search/{id}")
//    public String getListLopHocPhanByMonHocId(@PathVariable("id") String id, Model model){
//        List<MonHoc> listMonHoc = monHocRepository.findAllById(id);
//        model.addAttribute("listMonHoc", listMonHoc);
//        List<LopHocPhan> listLopHocPhan = lopHocPhanRepository.findByMonHocId(id);
//        model.addAttribute("listLopHocPhan", listLopHocPhan);
//        return "search";
//    }


}

