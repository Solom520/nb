package cn.edu.whut.sept.zuul;

import java.util.Scanner;


import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Before enter game,please login or register first!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("[1]login   [2]register   [3]Exit");
            System.out.print("please chose service:");
            String digit = scanner.next();

            if (digit.equals("1")) {
//                Game game = new Game();
//                game.play();
                System.out.print("please enter your name:");
                String name = scanner.next();
                System.out.print("please enter password:");
                String password = scanner.next();

                Admin user = new Admin();
                user.setName(name);
                user.setPassword(password);
                Login loginObj = new Login();
                loginObj.setAdmin(user);
//                Game game = new Game();
//                game.play();
                if (loginObj.JudgeAdmin() == 1) {
                    Game game = new Game();
                    game.play();
                } else {
                    System.out.println("please enter correct username or password!");
                    System.out.println("Do you want to go on?[yes/no]");
                    String instruction = scanner.next();

                    if (instruction.equals("no")){
                        System.out.println("Looking forward to your next visit!");
                        break;
                    }
                }
            } else if (digit.equals("2")) {
                Register register = new Register();
                System.out.print("Enter your name:");
                String name = scanner.next();
                System.out.print("Enter password:");
                String password = scanner.next();
                System.out.print("Confirm password:");
                String confirmpassword = scanner.next();

                register.setName(name);
                register.setID("6");
                register.setPassword(password);
                register.setconfirmpasswd(confirmpassword);

                if (register.JudgeRegister()) {
                    System.out.println("注册成功!");
                    Game game = new Game();
                    game.play();
                } else {
                    System.out.println("添加用户失败！");
                }
            } else if (digit.equals("3")) {
                System.out.println("Looking forward to your next visit!");
                break;
            } else {
                System.out.println("Wrong instruction! Please Enter correct instruction.");
            }
        }
    }
}