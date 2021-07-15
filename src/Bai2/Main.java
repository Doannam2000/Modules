/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Doann
 */
public class Main {

    public static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QLNV;user=sa;password=123456";
    public static Connection conn;
    public static Scanner sn = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(dbURL);
        } catch (Exception e) {
        }
        while (true) {
            System.out.println("=====================================");
            System.out.println("1.Bảng nhân viên");
            System.out.println("2.Bảng sản phẩm");
            System.out.println("3.Bảng hóa đơn");
            System.out.println("4.Bảng chi tiết hóa đơn");
            int i = sn.nextInt();
            switch (i) {
                case 1:
                    BangNV();
                    break;
                case 2:
                    BangSP();
                    break;
                case 3:
                    BangHD();
                    break;
                case 4:
                    BangChiTiet();
                    break;
                default:
                    return;

            }
        }
    }

    private static void BangNV() {
        System.out.println("1.Thêm\n2.Sửa\n3.Xóa\n4.Xem");
        int i = sn.nextInt();
        switch (i) {
            case 1:
                if (ThemNV()) {
                    System.out.println("Thêm thành công !!!");
                }
                break;
            case 2:
                if (SuaNV()) {
                    System.out.println("Sửa thành công");
                }
                break;
            case 3:
                if (XoaNV()) {
                    System.out.println("Xóa thành công");

                }
                break;
            case 4:
                ArrayList<NhanVien> nv = NhanVien();
                for (NhanVien n : nv) {
                    System.out.println(n);
                }
                break;
        }
        System.out.println("=====================================");
    }

    public static ArrayList<NhanVien> NhanVien() {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "select * from NhanVien";
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String MaNV = rs.getString("MaNV");
                String HoTen = rs.getString("HoTen");
                String NgaySinh = rs.getString("NgaySinh");
                String DiaChi = rs.getString("DiaChi");
                String SoDT = rs.getString("SoDienThoai");
                String GioiTinh = rs.getString("GioiTinh");
                list.add(new NhanVien(MaNV, HoTen, NgaySinh, DiaChi, SoDT, GioiTinh));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static boolean ThemNV() {
        NhanVien x = new NhanVien();
        System.out.println("Nhập thông tin nhân viên");
        sn.nextLine();
        System.out.print("Nhập mã nhân viên :");
        x.setMaNV(sn.nextLine());
        System.out.print("Nhập tên nhân viên :");
        x.setHoTen(sn.nextLine());
        System.out.print("Nhập ngày sinh :");
        x.setNgaySinh(sn.nextLine());
        System.out.print("Nhập địa chỉ :");
        x.setDiaChi(sn.nextLine());
        System.out.print("Nhập số điện thoại :");
        x.setSoDT(sn.nextLine());
        System.out.print("Nhập giới tính :");
        x.setGioiTinh(sn.nextLine());
        String sql = "insert into NhanVien values(?,?,?,?,?,?)";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, x.getMaNV());
            pr.setString(2, x.getHoTen());
            pr.setString(3, x.getNgaySinh());
            pr.setString(4, x.getDiaChi());
            pr.setString(5, x.getSoDT());
            pr.setString(6, x.getGioiTinh());
            if (pr.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean XoaNV() {
        sn.nextLine();
        System.out.print("Nhập mã nhân viên cần xóa :");
        String ma = sn.nextLine();
        String sql = "Delete NhanVien where MaNV = ?";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, ma);
            if (pr.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean SuaNV() {
        NhanVien x = new NhanVien();
        System.out.println("Nhập thông tin nhân viên mới ");
        sn.nextLine();
        System.out.print("Nhập mã nhân viên cần sửa :");
        x.setMaNV(sn.nextLine());
        System.out.print("Nhập tên nhân viên :");
        x.setHoTen(sn.nextLine());
        System.out.print("Nhập ngày sinh :");
        x.setNgaySinh(sn.nextLine());
        System.out.print("Nhập địa chỉ :");
        x.setDiaChi(sn.nextLine());
        System.out.print("Nhập số điện thoại :");
        x.setSoDT(sn.nextLine());
        System.out.print("Nhập giới tính :");
        x.setGioiTinh(sn.nextLine());
        String sql = "update NhanVien set HoTen=?,NgaySinh =?,DiaChi=?,SoDienThoai=?,GioiTinh=? where MaNV = ?";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, x.getHoTen());
            pr.setString(2, x.getNgaySinh());
            pr.setString(3, x.getDiaChi());
            pr.setString(4, x.getSoDT());
            pr.setString(5, x.getGioiTinh());
            pr.setString(6, x.getMaNV());
            if (pr.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    // ================== Sản Phẩm ============
    private static void BangSP() {
        System.out.println("1.Thêm\n2.Sửa\n3.Xóa\n4.Xem");
        int i = sn.nextInt();
        switch (i) {
            case 1:
                if (ThemSP()) {
                    System.out.println("Thêm thành công !!!");
                }
                break;
            case 2:
                if (SuaSP()) {
                    System.out.println("Sửa thành công");
                }
                break;
            case 3:
                if (XoaSP()) {
                    System.out.println("Xóa thành công");
                }
                break;
            case 4:
                ArrayList<SanPham> sp = SanPham();
                for (SanPham n : sp) {
                    System.out.println(n);
                }
                break;
        }
        System.out.println("=====================================");
    }

    public static ArrayList<SanPham> SanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham";
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String MaSP = rs.getString("MaSP");
                String TenSanPham = rs.getString("TenSP");
                String DonViTinh = rs.getString("DonVi");
                int Gia = rs.getInt("Gia");
                list.add(new SanPham(MaSP, TenSanPham, DonViTinh, Gia));
            }
        } catch (SQLException throwables) {
            System.out.println("error: " + throwables.getMessage());
        }
        return list;
    }

    public static boolean ThemSP() {
        SanPham x = new SanPham();
        System.out.println("Nhập thông tin sản phẩm");
        sn.nextLine();
        System.out.print("Nhập mã sản phẩm :");
        x.setMaSP(sn.nextLine());
        System.out.print("Nhập tên sản phẩm :");
        x.setTenSP(sn.nextLine());
        System.out.print("Nhập đơn vị  :");
        x.setDonVi(sn.nextLine());
        System.out.print("Nhập giá:");
        x.setGia(sn.nextInt());
        String sql = "insert into SanPham values(?,?,?,?)";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, x.getMaSP());
            pr.setString(2, x.getTenSP());
            pr.setString(3, x.getDonVi());
            pr.setInt(4, x.getGia());
            if (pr.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean SuaSP() {
        SanPham x = new SanPham();
        System.out.println("Nhập thông tin sản phẩm mới");
        sn.nextLine();
        System.out.print("Nhập mã sản phẩm cần sửa :");
        x.setMaSP(sn.nextLine());
        System.out.print("Nhập tên sản phẩm :");
        x.setTenSP(sn.nextLine());
        System.out.print("Nhập đơn vị  :");
        x.setDonVi(sn.nextLine());
        System.out.print("Nhập giá:");
        x.setGia(sn.nextInt());
        String sql = "update SanPham set TenSP=?,DonVi =?,Gia=? where MaSP = ?";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);

            pr.setString(1, x.getTenSP());
            pr.setString(2, x.getDonVi());
            pr.setInt(3, x.getGia());
            pr.setString(4, x.getMaSP());
            if (pr.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean XoaSP() {
        sn.nextLine();
        System.out.print("Nhập mã san pham cần xóa :");
        String ma = sn.nextLine();
        String sql = "Delete SanPham where MaSP = ?";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, ma);
            if (pr.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    // Hóa đơn
    private static void BangHD() {
        System.out.println("1.Thêm\n2.Sửa\n3.Xóa\n4.Xem");
        int i = sn.nextInt();
        switch (i) {
            case 1:
                if (ThemHD()) {
                    System.out.println("Thêm thành công !!!");
                }
                break;
            case 2:
                if (SuaHD()) {
                    System.out.println("Sửa thành công");
                }
                break;
            case 3:
                if (XoaHD()) {
                    System.out.println("Xóa thành công");
                }
                break;
            case 4:
                ArrayList<HoaDon> hd = HoaDon();
                for (HoaDon n : hd) {
                    System.out.println(n);
                }
                break;
        }
        System.out.println("=====================================");
    }

    public static ArrayList<HoaDon> HoaDon() {
        ArrayList<HoaDon> list = new ArrayList<>();
        String query = "select * from HoaDon";
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String MaHD = rs.getString("MaHD");
                String MaNV = rs.getString("MaNV");
                String LoaiHD = rs.getString("LoaiHD");
                String NgayLap = rs.getString("NgayLap");
                String NgayGiao = rs.getString("NgayGiao");
                String DienGiai = rs.getString("DienGian");
                list.add(new HoaDon(MaHD, MaNV, LoaiHD, NgayLap, NgayGiao, DienGiai));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static boolean ThemHD() {
        HoaDon x = new HoaDon();
        System.out.println("Nhập thông tin hóa đơn");
        sn.nextLine();
        System.out.print("Nhập mã hóa đơn :");
        x.setMaHD(sn.nextLine());
        System.out.print("Nhập mã nhân viên :");
        x.setMaNV(sn.nextLine());
        System.out.print("Nhập loại hóa đơn  :");
        x.setLoaiHD(sn.nextLine());
        System.out.print("Nhập ngày lập :");
        x.setNgayLap(sn.nextLine());
        System.out.print("Nhập ngày giao :");
        x.setNgayGiao(sn.nextLine());
        System.out.print("Nhập dien giai :");
        x.setDienGian(sn.nextLine());

        String sql = "insert into HoaDon values(?,?,?,?,?,?)";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, x.getMaHD());
            pr.setString(2, x.getMaNV());
            pr.setString(3, x.getLoaiHD());
            pr.setString(4, x.getNgayLap());
            pr.setString(5, x.getNgayGiao());
            pr.setString(6, x.getDienGian());
            if (pr.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean SuaHD() {
        HoaDon x = new HoaDon();
        System.out.println("Nhập thông tin hóa đơn mới ");
        sn.nextLine();
        System.out.print("Nhập mã hóa đơn cần sửa :");
        x.setMaHD(sn.nextLine());
        System.out.print("Nhập mã nhân viên :");
        x.setMaNV(sn.nextLine());
        System.out.print("Nhập loại hóa đơn  :");
        x.setLoaiHD(sn.nextLine());
        System.out.print("Nhập ngày lập :");
        x.setNgayLap(sn.nextLine());
        System.out.print("Nhập ngày giao :");
        x.setNgayGiao(sn.nextLine());
        System.out.print("Nhập dien giai :");
        x.setDienGian(sn.nextLine());

        String sql = "update HoaDon set MaNV=?,LoaiHD =?,NgayLap=?,NgayGiao=?,DienGiai = ? where MaHD = ?";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, x.getMaNV());
            pr.setString(2, x.getLoaiHD());
            pr.setString(3, x.getNgayLap());
            pr.setString(4, x.getNgayGiao());
            pr.setString(5, x.getDienGian());
            pr.setString(6, x.getMaHD());

            if (pr.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean XoaHD() {
        sn.nextLine();
        System.out.print("Nhập mã hoa don cần xóa :");
        String ma = sn.nextLine();
        String sql = "Delete HoaDon where MaHD = ?";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, ma);
            if (pr.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    // Chi Tiet HD
    private static void BangChiTiet() {
        System.out.println("1.Thêm\n2.Sửa\n3.Xóa\n4.Xem");
        int i = sn.nextInt();
        switch (i) {
            case 1:
                if (ThemCTHD()) {
                    System.out.println("Thêm thành công !!!");
                }
                break;
            case 2:
                if (SuaCTHD()) {
                    System.out.println("Sửa thành công");
                }
                break;
            case 3:
                if (XoaCTHD()) {
                    System.out.println("Xóa thành công");
                }
                break;
            case 4:
                ArrayList<ChiTietHD> cthd = ChiTietHD();
                for (ChiTietHD n : cthd) {
                    System.out.println(n);
                }
                break;
        }
        System.out.println("=====================================");
    }

    public static ArrayList<ChiTietHD> ChiTietHD() {
        ArrayList<ChiTietHD> list = new ArrayList<>();
        String query = "select * from ChiTietHoaDon";
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String MaHD = rs.getString("MaHD");
                String MaSP = rs.getString("MaSP");
                int SoLuong = rs.getInt("SoLuong");
                list.add(new ChiTietHD(MaHD, MaSP, SoLuong));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static boolean ThemCTHD() {
        ChiTietHD x = new ChiTietHD();
        System.out.println("Nhập thông tin chi hóa đơn");
        sn.nextLine();
        System.out.print("Nhập mã hóa đơn :");
        x.setMaHD(sn.nextLine());
        System.out.print("Nhập mã san pham :");
        x.setSP(sn.nextLine());
        System.out.print("Nhập số lượng:");
        x.setSoLuong(sn.nextInt());
        sn.nextLine();
        String sql = "insert into ChiTietHoaDon values(?,?,?)";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, x.getMaHD());
            pr.setString(2, x.getMaSP());
            pr.setInt(3, x.getSoLuong());
            if (pr.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean SuaCTHD() {
        ChiTietHD x = new ChiTietHD();
        System.out.println("Nhập thông tin chi hóa đơn mới");
        sn.nextLine();
        System.out.print("Nhập mã hóa đơn cần sửa :");
        x.setMaHD(sn.nextLine());
        System.out.print("Nhập mã sản phẩm cần sửa :");
        x.setSP(sn.nextLine());
        System.out.print("Nhập số lượng:");
        x.setSoLuong(sn.nextInt());
        sn.nextLine();
        String sql = "update HoaDon set SoLuong =? where (MaHD = ? and MaSP = ?)";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setInt(1, x.getSoLuong());
            pr.setString(2, x.getMaHD());
            pr.setString(3, x.getMaSP());
            if (pr.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean XoaCTHD() {
        sn.nextLine();
        System.out.print("Nhập mã hoa don cần xóa :");
        String ma = sn.nextLine();
        System.out.print("Nhập mã nhan vien cần xóa :");
        String ma2 = sn.nextLine();

        String sql = "Delete SanPham where MaHD = ? and MaSP = ?";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, ma);
            pr.setString(2, ma2);
            if (pr.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }
}
