package ru.omsu.imit.daoImplements;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.omsu.imit.dao.ProductDAO;
import ru.omsu.imit.model.Product;

import java.util.List;

@Repository
public class ProductDAOImpl extends BaseDAOImpl implements ProductDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAOImpl.class);

    @Override
    public Product insert(Product product) {
        LOGGER.debug("DAO Insert product {}", product);

        try (SqlSession sqlSession = getSession()) {
            try {
                getProductMapper(sqlSession).insert(product);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert product {} {}", product, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return product;
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("DAO Delete All Products {}");
        try (SqlSession sqlSession = getSession()) {
            try {
                getProductMapper(sqlSession).deleteAll();
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete all Products {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }

    }

    @Override
    public void delete (int id) {
        LOGGER.debug("DAO Delete Product {}",id);
        try (SqlSession sqlSession = getSession()) {
            try {
                getProductMapper(sqlSession).delete(id);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete Product {} {}",id, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }

    }

    @Override
    public Product getById(int id) {
        LOGGER.debug("DAO get Product by id {}", id);
        try (SqlSession sqlSession = getSession()) {
            return getProductMapper(sqlSession).getById(id);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get Product by id{}", ex);
            throw ex;
        }
    }

    @Override
    public List<Product> getByCost(int cost) {
        LOGGER.debug("DAO get Products by cost {}",cost);
        try (SqlSession sqlSession = getSession()) {
            return getProductMapper(sqlSession).getByCost(cost);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get Products by cost {} {}", cost,ex);
            throw ex;
        }
    }

    @Override
    public List<Product> getByProductName(String productName) {
        LOGGER.debug("DAO get Products by ProductName{}", productName);
        try (SqlSession sqlSession = getSession()) {
            return getProductMapper(sqlSession).getByProductName(productName);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get Products by ProductName{}{}",productName, ex);
            throw ex;
        }
    }

    @Override
    public List<Product> getAllLazy() {
        LOGGER.debug("DAO get all lazy Products");
        try (SqlSession sqlSession = getSession()) {
            return getProductMapper(sqlSession).getAllLazy();
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get all lazy Products{}", ex);
            throw ex;
        }
    }

    @Override
    public Product updateProduct(Product product) {
        LOGGER.debug("DAO update Product {}", product);
        try (SqlSession sqlSession = getSession()) {
            getProductMapper(sqlSession).updateProduct(product);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't update Product {}{}",product, ex);
            throw ex;
        }
        return product;
    }
}
