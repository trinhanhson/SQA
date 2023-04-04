package com.example.btlsqa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mon_hoc")
public class MonHoc {

    @Id
    private String id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "so_tin_chi")
    private Integer soTinChi;

    // constructors, getters, setters, toString

    public MonHoc() {
    }

    public MonHoc(String id, String ten, Integer soTinChi) {
        this.id = id;
        this.ten = ten;
        this.soTinChi = soTinChi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(Integer soTinChi) {
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "id='" + id + '\'' +
                ", ten='" + ten + '\'' +
                ", soTinChi=" + soTinChi +
                '}';
    }
}
