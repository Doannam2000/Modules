/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

/**
 *
 * @author Doann
 */
public class NhanVien {
    private String MaNV;
    private String HoTen;
    private String NgaySinh;
    private String DiaChi;
    private String SoDT;
    private String GioiTinh;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String HoTen, String NgaySinh, String DiaChi, String SoDT, String GioiTinh) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SoDT = SoDT;
        this.GioiTinh = GioiTinh;
    }


    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    @Override
    public String toString() {
        return "MaNV : "+MaNV+"\t TenNV : "+HoTen +"\t NgaySinh : "+NgaySinh +"\t DiaChi : "+ DiaChi +"\t SoDT : "+SoDT +"\t GioiTine : "+GioiTinh; //To change body of generated methods, choose Tools | Templates.
    }
    
}
