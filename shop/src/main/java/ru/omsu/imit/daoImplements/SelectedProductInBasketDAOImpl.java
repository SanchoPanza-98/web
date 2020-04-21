package ru.omsu.imit.daoImplements;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.dao.SelectedProductInBasketDAO;
import ru.omsu.imit.model.Basket;
import ru.omsu.imit.model.Product;
import ru.omsu.imit.model.SelectedProductInBasket;
import java.util.List;

public class SelectedProductInBasketDAOImpl extends BaseDAOImpl implements SelectedProductInBasketDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAOImpl.class);

    @Override
    public SelectedProductInBasket insert(SelectedProductInBasket selectedProduct) {
        LOGGER.debug("DAO Insert selected product in basket{}", selectedProduct);
        try (SqlSession sqlSession = getSession()) {
            try {
               getSelectedProductsMapper(sqlSession).insert(selectedProduct);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert selected product in basket {} {}", selectedProduct, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }

        return selectedProduct;

    }

    @Override
    public SelectedProductInBasket getById(int id) {
        LOGGER.debug("DAO Get selected product in basket by id {}",id);
        try (SqlSession sqlSession = getSession()) {
            return getSelectedProductsMapper(sqlSession).getById(id);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get selected product in basket by id{}", ex);
            throw ex;
        }
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("DAO Can't delete all selected products");
        try (SqlSession sqlSession = getSession()) {
           getSelectedProductsMapper(sqlSession).deleteAll();
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't delete all selected products{}", ex);
            throw ex;
        }
    }

    @Override
    public void deleteByBasket(Basket basket) {
        LOGGER.debug("DAO delete selected product by basket{}", basket);
        try (SqlSession sqlSession = getSession()) {
            getSelectedProductsMapper(sqlSession).getByBasket(basket);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't delete selected product by basket{}", ex);
            throw ex;
        }
    }

    @Override
    public SelectedProductInBasket deleteById(SelectedProductInBasket productInBasket) {
        LOGGER.debug("DAO Can't delete selected product in basket{}", productInBasket);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSelectedProductsMapper(sqlSession).deleteById(productInBasket.getId());
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete selected product in basket{} {}",productInBasket, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return productInBasket;
    }

    @Override
    public SelectedProductInBasket deleteByBasketAndProduct(Basket basket, Product product) {
        LOGGER.debug("DAO delete selected product by basket and product{}{}", basket, product);
        try (SqlSession sqlSession = getSession()) {
            getSelectedProductsMapper(sqlSession).deleteByBasketAndProduct(basket,product);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't delete selected product by basket and product{}", ex);
            throw ex;
        }
        return new SelectedProductInBasket(1,basket,product,1);
    }


    @Override
    public List<SelectedProductInBasket> getByProduct(Product product) {
        LOGGER.debug("DAO get selectedProducts by product{}", product);
        try (SqlSession sqlSession = getSession()) {
            return getSelectedProductsMapper(sqlSession).getByProduct(product);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get selectedProducts by product{}", ex);
            throw ex;
        }
    }

    @Override
    public List<SelectedProductInBasket> getByBasket(Basket basket) {
        LOGGER.debug("DAO get selectedProducts by basket{}", basket);
        try (SqlSession sqlSession = getSession()) {
            return getSelectedProductsMapper(sqlSession).getByBasket(basket);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get selectedProducts by basket{}", ex);
            throw ex;
        }
    }






}
