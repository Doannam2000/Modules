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
public class SanPham {
    private String MaSP;
    private String TenSP;
    private String DonVi;
    private int Gia;

    public SanPham() {
    }
    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getDonVi() {
        return DonVi;
    }

    public void setDonVi(String DonVi) {
        this.DonVi = DonVi;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public SanPham(String MaSP, String TenSP, String DonVi, int Gia) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DonVi = DonVi;
        this.Gia = Gia;
    }

    @Override
    public String toString() {
        return "MaSp : "+MaSP + "\t TenSP : "+TenSP +"\t Don vi : "+DonVi + "\t Gia : "+ Gia; //To change body of generated methods, choose Tools | Templates.
    }
    
}
