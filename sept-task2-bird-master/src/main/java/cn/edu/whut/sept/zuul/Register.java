package cn.edu.whut.sept.zuul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Register {
    String name;
    String ID;
    String password;
    String confirmpassword;

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/user?serverTimezone=UTC&characterEncoding=utf-8";
    private String user = "root";
    private String sqlpassword = "Liu172032";

    void setName(String name) {
        this.name = name;
    }
    void setID(String ID) {
        this.ID = ID;
    }
    void setPassword(String password) {
        this.password = password;
    }
    void setconfirmpasswd(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    /**
     *判断注册的账号是否符合规则
     */
    boolean JudgeRegister(){

        if(this.name.equals("")) {
            System.out.println("用户名不能为空！");
//            JOptionPane.showMessageDialog(null, "用户名不能为空！", "用户名", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(this.ID.equals("")) {
            System.out.println("账号不能为空！");
//            JOptionPane.showMessageDialog(null, "账号不能为空！", "账号为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(this.password.equals("")) {
            System.out.println("密码不能为空！");
//            JOptionPane.showMessageDialog(null, "密码不能为空！", "密码为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(!this.password.equals(this.confirmpassword)) {
            System.out.println("两次输入的密码不一致!");
//            JOptionPane.showMessageDialog(null, "两次输入的密码不一致!", "密码不一致", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        /**
         *符合规则，提示用户注册成功的窗口，并将账号添加数据库
         */
        try {
            addAdmin();
//            System.out.println("注册成功!");

            return true;
        }catch (Exception e){
            //            e.printStackTrace();
//            System.out.println("!!!!!!!!!");
//            System.out.println("添加用户失败！");
        }
        return false;
    }

    /**
     *向数据库添加Admin账户
     */
    void addAdmin() throws ClassNotFoundException, SQLException {
        String sql="insert into user (id, name, password) values (?,?,?)";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName(driver);

        Connection conn = DriverManager.getConnection(url, user, sqlpassword);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, this.ID);
        ps.setString(2, this.name);
        ps.setString(3, this.password);
        ps.executeUpdate();
        ps.close();
        conn.close();

    }
}