package com.example.cuoiky_thuchanh;


public class SinhVien {
    int id;
    String masv;
    String tenSV;
    String email;
    String lop;
    String diachi;
    String gioitinh;
    String ngaysinh;
    String anh;
    public void setId(int id) {
        this.id = id;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setLop(String lop) {
        this.lop = lop;
    }



    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }


    public int getId() {
        return id;
    }

    public String getAnh() {
        return anh;
    }

    public String getMasv() {
        return masv;
    }

    public String getTenSV() {
        return tenSV;
    }

    public String getEmail() {
        return email;
    }


    public String getLop() {
        return lop;
    }



    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }


    public SinhVien(int id, String masv, String tenSV, String email, String lop,String diachi,String gioitinh, String ngaysinh,String anh  ) {
        this.id = id;
        this.anh = anh;
        this.masv = masv;
        this.tenSV = tenSV;
        this.email = email;
        this.lop = lop;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }


}
