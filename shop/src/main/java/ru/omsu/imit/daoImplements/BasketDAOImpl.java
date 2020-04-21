package ru.omsu.imit.daoImplements;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.dao.BasketDAO;
import ru.omsu.imit.model.Basket;
import ru.omsu.imit.model.Buyer;
import ru.omsu.imit.model.SelectedProductInBasket;

import java.util.List;

public class BasketDAOImpl extends BaseDAOImpl implements BasketDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasketDAOImpl.class);
    @Override
    public Basket insert(Basket basket) {
        LOGGER.debug("DAO Insert Basket {}", basket);

        try (SqlSession sqlSession = getSession()) {
            try {
                  getBasketMapper(sqlSession).insert(basket);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert Basket {} {}", basket, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return basket;
    }

    @Override
    public Basket getById(int id) {
        LOGGER.debug("DAO Get basket by id {}",id);
        try (SqlSession sqlSession = getSession()) {
            return getBasketMapper(sqlSession).getById(id);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get basket{}", ex);
            throw ex;
        }
    }


    @Override
    public void deleteAll() {
        LOGGER.debug("DAO Delete All Baskets ");
        try (SqlSession sqlSession = getSession()) {
            try {
                getBasketMapper(sqlSession).deleteAll();
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete all Baskets {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public Basket getByBuyer(int buyerId) {
        LOGGER.debug("DAO get Basket by buyerId {}",buyerId);
        try (SqlSession sqlSession = getSession()) {
            return getBasketMapper(sqlSession).getByBuyer(buyerId);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get Basket by buyerId{}", ex);
            throw ex;
        }
    }

    @Override
    public Basket deleteBasket(Basket basket) {
        LOGGER.debug("DAO Delete Basket {}", basket);
        try (SqlSession sqlSession = getSession()) {
            try {
                getBasketMapper(sqlSession).deleteBasket(basket.getId());
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete Basket {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return basket;
    }

    @Override
    public List<SelectedProductInBasket> getProductsInBasket(Integer buyerId) {
        LOGGER.debug("Get products from Basket");
        try (SqlSession sqlSession = getSession()) {
            return sqlSession.selectList("BasketMapper.getProductsInBasket",buyerId);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get products from Basket {}", ex);
            throw ex;
        }
    }
}
