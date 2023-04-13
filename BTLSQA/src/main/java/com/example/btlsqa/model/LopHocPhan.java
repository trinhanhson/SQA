package com.example.btlsqa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "LopHocPhan{" +
                "id=" + id +
                ", nhomMonHoc='" + nhomMonHoc + '\'' +
                ", siSoToiDa=" + siSoToiDa +
                ", siSoThucTe=" + siSoThucTe +
                ", thu=" + thu +
                ", tietBatDau=" + tietBatDau +
                ", soTiet=" + soTiet +
                ", phong='" + phong + '\'' +
                ", tenGiangVien='" + tenGiangVien + '\'' +
                ", monHoc=" + monHoc +
                ", danhSachDangKiHoc=" + danhSachDangKiHoc +
                '}';
    }
}
