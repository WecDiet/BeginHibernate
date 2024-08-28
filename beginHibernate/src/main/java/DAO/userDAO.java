package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import models.userModel;
import util.hibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class userDAO implements userInterface<userModel> {


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
    public userModel selectById(userModel userModel) {
        return null;
    }

    @Override
    public boolean insert(userModel userModel) {
        return false;
    }

    @Override
    public boolean update(userModel userModel) {
        return false;
    }

    @Override
    public boolean delete(userModel userModel) {
        return false;
    }
}
