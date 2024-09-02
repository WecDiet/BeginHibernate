package main;

import DAO.userDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TemporalType;
import models.userModel;
import util.hibernateUtil;

import java.sql.Date;
import java.time.Instant;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class running {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


        // get all dữ liệu trong database
//        userDAO userDAO = new userDAO();
//        List<userModel> listUser = userDAO.selectAll();
//        for (userModel user : listUser) {
//            System.out.println(user);
//        }


        // serch dữ liệu theo tên
//        System.out.println("Nhập tên cần search: ");
//        String name = sc.nextLine();
//        userDAO userdao = new userDAO();
//        userModel user = userdao.selectByName(new userModel(), name);
//        System.out.println(user);


        // Insert dữ liệu
//        userDAO userdao = new userDAO();
//        userModel user = new userModel();
//        user.setName("Quốc Việt");
//        user.setUserName("quocviet2002");
//        user.setPassword("abc@123");
//        user.setEmail("quocviet2002@gmail.com");
//        user.setAddress("quan 12,HCM");
//        user.setTelePhone("0123456789");
//        user.setSex(true);
//        user.setCreatedDate(new Date(System.currentTimeMillis()));
//        user.setUpdatedDate(new Date(System.currentTimeMillis()));
//        boolean ischeck = userdao.insert(user);
//       if(ischeck == true){
//           System.out.println("Insert Successfully");
//       }else{
//           System.out.println("Insert Failed");
//       }


        // Update dữ liệu theo username
//        userDAO userdao = new userDAO();
//        userModel user = new userModel();
//        System.out.println("Nhập username cần update: ");
//        String username = sc.nextLine();
//        userdao.updateByUsername(user, username);
//        if(userdao.updateByUsername(user, username) == true){
//            System.out.println("Update successfully !!!");
//        }else{
//            System.out.println("Update failed!!!");
//        }


        // Delete dữ liệu theo username
//        userDAO userdao = new userDAO();
//        userModel user = new userModel();
//        System.out.println("Nhập username cần delete: ");
//        String username = sc.nextLine();
//        userdao.deleteByUsername(user, username);



    }
}
