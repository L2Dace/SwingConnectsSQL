/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswinglinksql;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import users.users;
/**
 *
 * @author ADMIN
 */
public class JavaSwingLinkSQL {

    public List<users> getAllUsers(){
        List<users> users = new ArrayList<users>();
        Connection connection = SQLconnection.getConnection();
        
        String sql = "SELECT * FROM NguoiDung";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while( rs.next()) {
                users user = new users();
                
                user.setId(rs.getInt("id"));
                user.setTen(rs.getString("ten"));
                user.setSdt(rs.getString("sdt"));
                user.setTenTK(rs.getString("tenTK"));
                user.setMatKhau(rs.getString("matKhau"));
                user.setGioiThieu(rs.getString("gioiThieu"));
                user.setVaiTro(rs.getString("vaiTro"));
                user.setSoThich(rs.getString("soThich"));
                
                users.add(user);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }
    
    /**
     *
     * @param user
     */
    public void addUser (users user){
            Connection connection = SQLconnection.getConnection();
            
            String sql = "INSERT INTO NguoiDung (Ten,Sdt,TenTK,Matkhau,GioiThieu,VaiTro,SoThich) "
                    + "values (?,?,?,?,?,?,?) "
                    ;
            
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getTen());
                preparedStatement.setString(2, user.getSdt());
                preparedStatement.setString(3, user.getTenTK());
                preparedStatement.setString(4, user.getMatKhau());
                preparedStatement.setString(5, user.getGioiThieu());
                preparedStatement.setString(6, user.getVaiTro());
                preparedStatement.setString(7, user.getSoThich());
                
//                int rs = preparedStatement.executeUpdate();
//                System.out.println(rs);
                preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        
    public void updateUser (users user){
            Connection connection = SQLconnection.getConnection();
            
            String sql = "UPDATE users SET TEN = ?, SDT = ?, TENTK = ?, MATKHAU = ?, GIOITHIEU = ?, VAITRO = ?, SOTHICH = ?";
            
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getTen());
                preparedStatement.setString(2, user.getSdt());
                preparedStatement.setString(3, user.getTenTK());
                preparedStatement.setString(4, user.getMatKhau());
                preparedStatement.setString(5, user.getGioiThieu());
                preparedStatement.setString(6, user.getVaiTro());
                preparedStatement.setString(7, user.getSoThich());
                preparedStatement.setInt(8, user.getId());
                
                int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

    public void deleteUser(int id){
        Connection connection = SQLconnection.getConnection();
        
        String sql = "delete from NguoiDung where ID = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   static void main(String[] args) {
    //TODO code application logic here
    }
    
}
