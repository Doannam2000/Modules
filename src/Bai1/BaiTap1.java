/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Doann
 */
public class BaiTap1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=BaiTap1;user=sa;password=123456";
            Connection conn = DriverManager.getConnection(dbURL);
            Scanner sn = new Scanner(System.in);
            if (conn != null) {
                while (true) {
                    System.out.println("==============================================");
                    System.out.println("1.Câu a\n2.Câu b\n3.Thoát");
                    int x = sn.nextInt();
                    if (x == 1) {
                        Statement stm = conn.createStatement();
                        ResultSet rs = stm.executeQuery("select * from SanPham");
                        while (rs.next()) {
                            System.out.println("MaSP : " + rs.getString(1) + ";\t\t TenSP : " + rs.getString(2) + ";\t\t Nhà sản xuất : " + rs.getString(3));
                        }

                    } else if (x == 2) {

                        LoaiSanPham loaisp = new LoaiSanPham();
                        sn.nextLine();
                        System.out.print("Nhập mã loại sản phẩm :");
                        loaisp.setMaLoaiSP(sn.nextLine());
                        System.out.print("Nhập tên loại sản phẩm :");
                        loaisp.setTenLoaiSP(sn.nextLine());
                        String sql = "insert into LoaiSanPham values('"+loaisp.getMaLoaiSP()+"',N'"+ loaisp.getTenLoaiSP()+"')";
                        PreparedStatement pr = conn.prepareStatement(sql);
                        if (pr.executeUpdate() > 0) {
                            System.out.println("========================");
                            System.out.println("Loại sản phẩm ");
                            Statement stm = conn.createStatement();
                            ResultSet rs = stm.executeQuery("select * from LoaiSanPham");
                            while (rs.next()) {
                                System.out.println("MaLoaiSP : " + rs.getString(1) + ";\t\t TenLoaiSp : " + rs.getString(2));
                            }
                        }
                  

                    } else if (x == 3) {
                        break;
                    }
                }

            }
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }
}
