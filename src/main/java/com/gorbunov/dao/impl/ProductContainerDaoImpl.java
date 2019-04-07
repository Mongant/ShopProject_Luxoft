package com.gorbunov.dao.impl;

import com.gorbunov.dao.ProductContainerDao;
import com.gorbunov.dao.dbcp.DataBaseConnection;
import com.gorbunov.domain.Product;
import com.gorbunov.domain.ProductContainer;
import com.gorbunov.utils.HibernateSessionFactoryUtil;
import com.gorbunov.utils.ReaderIniFile;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductContainerDaoImpl implements ProductContainerDao {

    @Autowired
    ProductContainer productContainer;

    @Autowired
    Product product;

    DataBaseConnection dbConnection = new DataBaseConnection();

    private ProductContainerDaoImpl() {
    }

    @Override
    public void addProductContainer(long id, String ref_Id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, id);
        productContainer.setProduct(product);
        productContainer.setRefId(ref_Id);
        session.save(productContainer);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteProductContainerItem(long id, String refId) {
        String sql = ReaderIniFile.iniReader("Product container operation", "DELETE_PRODUCT_CONTAINER_ITEM");

        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, refId);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductContainer> showProductContainer(String refId) {
        List<ProductContainer> productContainers = new ArrayList<>();
        Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from ProductContainer where refId = :refId");
        productContainers.add((ProductContainer) query);
        session.close();
        return productContainers;
    }
}
