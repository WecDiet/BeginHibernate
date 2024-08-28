package main;

import DAO.userDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import models.userModel;
import util.hibernateUtil;

import java.sql.Date;
import java.util.List;

public class running {
    public static void main(String[] args) {
//        try {
//            EntityManagerFactory entityManagerFactory = hibernateUtil.getEntityManagerFactory();
//            if (entityManagerFactory != null) {
//                EntityManager entityManager = entityManagerFactory.createEntityManager();
//                try {
//                    entityManager.getTransaction().begin();
//                    userModel user = new userModel();
//                    user.setName("abc");
//                    user.setUserName("abc123");
//                    user.setPassword("12345");
//                    user.setEmail("abc@gmail.com");
//                    user.setAddress("quan12,HCM");
//                    user.setTelePhone("012345678");
//                    user.setSex(true);
//                    user.setCreatedDate(new Date(System.currentTimeMillis()));
//                    user.setUpdatedDate(new Date(System.currentTimeMillis()));
//                    entityManager.persist(user);  // Sử dụng persist thay vì save
//                    entityManager.getTransaction().commit(); // hiển thị và commit thông tin đối tượng xuống database
//                } finally {
//                    entityManager.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            hibernateUtil.shutdown();
//        }

        userDAO userDAO = new userDAO();
        List<userModel> listUser = userDAO.selectAll();
        for (userModel user : listUser) {
            System.out.println(user);
        }
    }
}
