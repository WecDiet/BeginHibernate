package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import models.userModel;
import util.hibernateUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userDAO implements userInterface<userModel> {
    Scanner sc = new Scanner(System.in);
    @Override
    public List<userModel> selectAll() {
        List<userModel> list = new ArrayList<userModel>();
        EntityManager entityManager = null;
        try{
            EntityManagerFactory entityManagerFactory = hibernateUtil.getEntityManagerFactory();
            if(entityManagerFactory != null){
                entityManager = entityManagerFactory.createEntityManager();
                entityManager.getTransaction().begin();
                // Thực thi câu lệnh HQL
                String hql = "FROM userModel";
                Query query = entityManager.createQuery(hql,userModel.class); // chỉ định kiểu trả về cho query
                list = query.getResultList();
                entityManager.getTransaction().commit();
                entityManager.close();
            }
        }catch (Exception e){
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();  // Rollback nếu có lỗi xảy ra
            }
            e.printStackTrace();
        }finally {
            if (entityManager != null) {
                entityManager.close();  // Đảm bảo EntityManager được đóng
            }
        }
        return list;
    }

    @Override
    public userModel selectByName(userModel userModel,String name) {
        List<userModel> list = new ArrayList<userModel>();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = hibernateUtil.getEntityManagerFactory();
        models.userModel result = null;
        try {
            if(entityManagerFactory != null){
                entityManager = entityManagerFactory.createEntityManager();
                entityManager.getTransaction().begin();
                // Thực thi câu lệnh HQL
                String hql = "FROM userModel u WHERE u.name = : name";
                Query query = entityManager.createQuery(hql, userModel.class);
                query.setParameter("name", name);
                query.getSingleResult();
                entityManager.getTransaction().commit();
                entityManager.close();
                if (!list.isEmpty()) {
                    result = list.get(0); // Assuming you're only interested in the first match
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean insert(userModel userModel) {
        Boolean result = false;
        EntityManager entityManager = null;
        try{
            EntityManagerFactory entityManagerFactory = hibernateUtil.getEntityManagerFactory();
            if(entityManagerFactory != null){
                entityManager = entityManagerFactory.createEntityManager();
                entityManager.getTransaction().begin();
                entityManager.persist(userModel);
                entityManager.getTransaction().commit();
                entityManager.close();
                result = true;
                return result;
            }
        }catch (Exception e){
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();  // Rollback nếu có lỗi xảy ra
            }
            e.printStackTrace();
        }finally {
            if (entityManager != null) {
                entityManager.close();  // Đảm bảo EntityManager được đóng
            }
        }
        return result;
    }

    @Override
    public boolean updateByUsername(userModel userModel, String username) {
        boolean result = false;
        EntityManager entityManager = null;
        try {
            EntityManagerFactory entityManagerFactory = hibernateUtil.getEntityManagerFactory();
            if (entityManagerFactory != null) {
                entityManager = entityManagerFactory.createEntityManager();
                entityManager.getTransaction().begin();
                String hql = "FROM userModel u WHERE u.userName = :username";
                userModel existingUser = entityManager.createQuery(hql, userModel.class)
                        .setParameter("username", username)
                        .getSingleResult();
                if (existingUser != null) {
                    // Nhập các thông tin mới từ bàn phím và cập nhật
                    System.out.println("Nhập tên mới: ");
                    existingUser.setName(sc.nextLine());
                    System.out.println("Nhập Password mới: ");
                    existingUser.setPassword(sc.nextLine());
                    System.out.println("Nhập Email mới: ");
                    existingUser.setEmail(sc.nextLine());
                    System.out.println("Nhập Address mới: ");
                    existingUser.setAddress(sc.nextLine());
                    System.out.println("Nhập Telephone mới: ");
                    existingUser.setTelePhone(sc.nextLine());
                    existingUser.setCreatedDate(new Date(System.currentTimeMillis()));
                    existingUser.setUpdatedDate(new Date(System.currentTimeMillis()));
                    entityManager.merge(existingUser);
                    entityManager.getTransaction().commit();
                    entityManager.close();
                    result = true;
                    return result;
                }
            }
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return result;
    }

    @Override
    public boolean deleteByUsername(userModel userModel, String username) {
        boolean result = false;
        EntityManager entityManager = null;
        try {
            EntityManagerFactory entityManagerFactory = hibernateUtil.getEntityManagerFactory();
            if(entityManagerFactory != null){
                entityManager = entityManagerFactory.createEntityManager();
                entityManager.getTransaction().begin();
                String hql = "FROM userModel u WHERE u.userName = :username";
                userModel existingUser = entityManager.createQuery(hql, userModel.class)
                        .setParameter("username", username)
                        .getSingleResult();
                if(entityManager != null){
                    result = true;
                    entityManager.remove(existingUser);
                    entityManager.getTransaction().commit();
                    entityManager.close();
                    return result;
                }
            }else{
                System.out.println("Không tìm thấy User !!!!!");
            }
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        }finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return result;
    }
}
