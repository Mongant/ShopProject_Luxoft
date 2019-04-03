package com.gorbunov.dao.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.domain.Product;
import com.gorbunov.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Autowired
    Product product;

    @Override
    public void addProduct(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Product> productList() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Product> products = (List<Product>) session.createQuery("from Product ").list();
        session.close();
        return products;
    }

    @Override
    public Product getProduct(long id) {
        Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();

        return product;
    }

    @Override
    public void updateProduct(long id, Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        product.setId(id);
        session.update(product);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteProduct(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        product.setId(id);
        session.delete(product);
        transaction.commit();
        session.close();
    }
}
