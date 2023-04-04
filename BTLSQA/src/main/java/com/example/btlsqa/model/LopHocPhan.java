package com.example.btlsqa.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    // constructors, getters, setters, toString


    public LopHocPhan() {
    }

    public LopHocPhan(int id, String nhomMonHoc, int siSoToiDa, int siSoThucTe, int thu, int tietBatDau, int soTiet, String phong, String tenGiangVien, MonHoc monHoc, List<DangKiHoc> danhSachDangKiHoc) {
        this.id = id;
        this.nhomMonHoc = nhomMonHoc;
        this.siSoToiDa = siSoToiDa;
        this.siSoThucTe = siSoThucTe;
        this.thu = thu;
        this.tietBatDau = tietBatDau;
        this.soTiet = soTiet;
        this.phong = phong;
        this.tenGiangVien = tenGiangVien;
        this.monHoc = monHoc;
        this.danhSachDangKiHoc = danhSachDangKiHoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNhomMonHoc() {
        return nhomMonHoc;
    }

    public void setNhomMonHoc(String nhomMonHoc) {
        this.nhomMonHoc = nhomMonHoc;
    }

    public int getSiSoToiDa() {
        return siSoToiDa;
    }

    public void setSiSoToiDa(int siSoToiDa) {
        this.siSoToiDa = siSoToiDa;
    }

    public int getSiSoThucTe() {
        return siSoThucTe;
    }

    public void setSiSoThucTe(int siSoThucTe) {
        this.siSoThucTe = siSoThucTe;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public int getTietBatDau() {
        return tietBatDau;
    }

    public void setTietBatDau(int tietBatDau) {
        this.tietBatDau = tietBatDau;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public List<DangKiHoc> getDanhSachDangKiHoc() {
        return danhSachDangKiHoc;
    }

    public void setDanhSachDangKiHoc(List<DangKiHoc> danhSachDangKiHoc) {
        this.danhSachDangKiHoc = danhSachDangKiHoc;
    }

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
