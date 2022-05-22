package cn.edu.whut.sept.zuul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    Admin admin;

    void setAdmin(Admin admin) {
        this.admin=admin;
        //System.out.println(this.admin.getPassword()+"   " + this.admin.getID());
    }
    /*
     * JudgeAdmin()方法
     * 判断Admin的ID和密码是否正确，如果正确，显示登录成功
     * 如果错误，弹出一个窗口，显示账号或密码错误
     */
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/user?serverTimezone=UTC&characterEncoding=utf-8";
    private String user = "root";
    private String sqlpassword = "Liu172032";



    public boolean login(Admin admin) throws SQLException, ClassNotFoundException {
        String sql="select * from user where name=? and password=?;";

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName(driver);

        Connection conn = DriverManager.getConnection(url, user, sqlpassword);
        PreparedStatement ps = conn.prepareStatement(sql);

//        System.out.println(admin.getName());
//        System.out.println(admin.getPassword());
        ps.setString(1, admin.getName());
        ps.setString(2, admin.getPassword());
        ResultSet rs = ps.executeQuery();
        int ans = 0;
        if(rs.next()) {
            ans = 1;
        }
        rs.close();
        ps.close();
        conn.close();
        if(ans == 1) {
            return true;
        }
        else return false;
    }
    int JudgeAdmin() {

        try {
            if(login(this.admin)) {
                System.out.println("Successful Login!");
                return 1;
            }else {
                return 0;
            }
        }catch(Exception e) {
//            e.printStackTrace();
//            System.out.println("!!!!!!!!!");

        }
        return 0;

    }

    public static void main(String[] args) {
        Admin user = new Admin();
        user.setName("hh");
        user.setPassword("123");
        Login loginObj = new Login();
        loginObj.JudgeAdmin();
    }
}

