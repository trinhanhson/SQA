package com.example.btlsqa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "lop_hoc_phan")
public class LopHocPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nhom_mon_hoc")
    private String nhomMonHoc;

    @Column(name = "si_so_toi_da")
    private int siSoToiDa;

    @Column(name = "si_so_thuc_te")
    private int siSoThucTe;

    @Column(name = "thu")
    private int thu;

    @Column(name = "tiet_bat_dau")
    private int tietBatDau;

    @Column(name = "so_tiet")
    private int soTiet;

    @Column(name = "phong")
    private String phong;

    @Column(name = "ten_giang_vien")
    private String tenGiangVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mon_hoc_id")
    private MonHoc monHoc;

    @OneToMany(mappedBy = "lopHocPhan")
    private List<DangKiHoc> danhSachDangKiHoc = new ArrayList<>();

    public LopHocPhan(MonHoc monHoc) {
        this.monHoc = monHoc;
    }
}
