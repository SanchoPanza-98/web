package ru.omsu.imit.daoImplements;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.dao.SelectedProductInPurchaseDAO;
import ru.omsu.imit.model.*;

public class SelectedProductInPurchaseDAOImpl extends BaseDAOImpl implements SelectedProductInPurchaseDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAOImpl.class);

    @Override
    public SelectedProductInPurchase insert(SelectedProductInPurchase selectedProduct) {
        LOGGER.debug("DAO Insert selected product{}", selectedProduct);
        try (SqlSession sqlSession = getSession()) {
            try {
               getSelectedProductsInPurchaseMapper(sqlSession).insert(selectedProduct);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert selected product {} {}", selectedProduct, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }

        return selectedProduct;

    }

    @Override
    public SelectedProductInPurchase getById(int id) {
        LOGGER.debug("DAO Get selected product in basket by id {}",id);
        try (SqlSession sqlSession = getSession()) {
            return getSelectedProductsInPurchaseMapper(sqlSession).getById(id);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get Buyer{}", ex);
            throw ex;
        }
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("DAO Can't delete all selected products");
        try (SqlSession sqlSession = getSession()) {
           getSelectedProductsInPurchaseMapper(sqlSession).deleteAll();
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't delete all selected products{}", ex);
            throw ex;
        }
    }

    @Override
    public void deleteByPurchase(Purchase purchase) {
        LOGGER.debug("DAO delete selected product by basket{}", purchase);
        try (SqlSession sqlSession = getSession()) {
            getSelectedProductsInPurchaseMapper(sqlSession).deleteByPurchase(purchase);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't delete selected product by basket{}", ex);
            throw ex;
        }
    }


}
