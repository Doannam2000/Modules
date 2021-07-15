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
public class ChiTietHD {
    private String MaHD;
    private String MaSP;
    private int SoLuong;

    public ChiTietHD() {
    }

    public ChiTietHD(String MaHD, String MaNV, int SoLuong) {
        this.MaHD = MaHD;
        this.MaSP = MaNV;
        this.SoLuong = SoLuong;
    }


    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setSP(String SP) {
        this.MaSP = MaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    @Override
    public String toString() {
        return "MaHD : "+ MaHD + " \t MaSP : "+ MaSP +" \t SoLuong :"+SoLuong; //To change body of generated methods, choose Tools | Templates.
    }
    
}
