package com.example.btlsqa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dang_ki_hoc")
public class DangKiHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "diem_tong_ket")
    private float diemTongKet;

    @Column(name = "so_lan_hoc")
    private int soLanHoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinh_vien_id")
    private SinhVien sinhVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lop_hoc_phan_id")
    private LopHocPhan lopHocPhan;

    // constructors, getters, setters, toString


    public DangKiHoc() {
    }

    public DangKiHoc(int id, float diemTongKet, int soLanHoc, SinhVien sinhVien, LopHocPhan lopHocPhan) {
        this.id = id;
        this.diemTongKet = diemTongKet;
        this.soLanHoc = soLanHoc;
        this.sinhVien = sinhVien;
        this.lopHocPhan = lopHocPhan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDiemTongKet() {
        return diemTongKet;
    }

    public void setDiemTongKet(float diemTongKet) {
        this.diemTongKet = diemTongKet;
    }

    public int getSoLanHoc() {
        return soLanHoc;
    }

    public void setSoLanHoc(int soLanHoc) {
        this.soLanHoc = soLanHoc;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public LopHocPhan getLopHocPhan() {
        return lopHocPhan;
    }

    public void setLopHocPhan(LopHocPhan lopHocPhan) {
        this.lopHocPhan = lopHocPhan;
    }

    @Override
    public String toString() {
        return "DangKiHoc{" +
                "id=" + id +
                ", diemTongKet=" + diemTongKet +
                ", soLanHoc=" + soLanHoc +
                ", sinhVien=" + sinhVien +
                ", lopHocPhan=" + lopHocPhan +
                '}';
    }
}