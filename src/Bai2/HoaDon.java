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
public class HoaDon {
    private String MaHD;
    private String MaNV;
    private String LoaiHD;
    private String NgayLap;
    private String NgayGiao;
    private String DienGian;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaNV, String LoaiHD, String NgayLap, String NgayGiao, String DienGian) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.LoaiHD = LoaiHD;
        this.NgayLap = NgayLap;
        this.NgayGiao = NgayGiao;
        this.DienGian = DienGian;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getLoaiHD() {
        return LoaiHD;
    }

    public void setLoaiHD(String LoaiHD) {
        this.LoaiHD = LoaiHD;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public String getNgayGiao() {
        return NgayGiao;
    }

    public void setNgayGiao(String NgayGiao) {
        this.NgayGiao = NgayGiao;
    }

    public String getDienGian() {
        return DienGian;
    }

    public void setDienGian(String DienGian) {
        this.DienGian = DienGian;
    }

    @Override
    public String toString() {
        return "MaHD : "+MaHD+"\t MaNV : "+MaNV +"\t Loại : "+LoaiHD +"\t NgayLap : "+ NgayLap +"\t NgayGiao : "+NgayGiao +"\t DienGiai : "+DienGian;  //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
