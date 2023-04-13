package com.example.btlsqa.model;

import jakarta.persistence.*;
import lombok.*;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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