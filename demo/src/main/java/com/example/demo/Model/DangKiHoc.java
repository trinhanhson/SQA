/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Model;

/**
 *
 * @author ADMIN
 */
public class DangKiHoc {

    private int id;
    private float diemTongKet;
    private int soLanHoc;
    private String maSinhVien;
    private int lopHocPhanId;

    public DangKiHoc() {
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

    public String getSinhVienId() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public int getLopHocPhanId() {
        return lopHocPhanId;
    }

    public void setLopHocPhanId(int lopHocPhanId) {
        this.lopHocPhanId = lopHocPhanId;
    }
    
}
