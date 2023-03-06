package com.example.cuoiky_thuchanh;

public class taiKhoan {
    int id,maQuyenTruyCap;
    String tenDangNhap;
    String matKhau;
    public void setId(int id) {
        this.id = id;
    }

    public void setMaQuyenTruyCap(int maQuyenTruyCap) {
        this.maQuyenTruyCap = maQuyenTruyCap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public int getId() {
        return id;
    }
    public int getMaQuyenTruyCap() {
        return maQuyenTruyCap;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }


    public taiKhoan(int id, int maQuyenTruyCap, String tenDangNhap, String matKhau) {
        this.id = id;
        this.maQuyenTruyCap = maQuyenTruyCap;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }


}
