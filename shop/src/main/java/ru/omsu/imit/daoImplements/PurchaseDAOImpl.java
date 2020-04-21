package ru.omsu.imit.daoImplements;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.dao.PurchaseDAO;
import ru.omsu.imit.model.*;
import java.sql.Timestamp;
import java.util.List;

public class PurchaseDAOImpl extends BaseDAOImpl implements PurchaseDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseDAOImpl.class);

    @Override
    public Purchase insert(Purchase purchase) {

            LOGGER.debug("DAO Insert Purchase {}", purchase);
            try (SqlSession sqlSession = getSession()) {
                try {
                   getPurchaseMapper(sqlSession).insert(purchase);
                } catch (RuntimeException ex) {
                    LOGGER.debug("Can't insert purchase {} {}", purchase, ex);
                    sqlSession.rollback();
                    throw ex;
                }
                sqlSession.commit();
            }
        return purchase;
    }

    @Override
    public Purchase getById(int id) {
        LOGGER.debug("DAO get purchase by id {}", id);
        try (SqlSession sqlSession = getSession()) {
            return getPurchaseMapper(sqlSession).getById(id);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get purchase by id {}{}",id, ex);
            throw ex;
        }
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("DAO Delete All Purchases");
        try (SqlSession sqlSession = getSession()) {
            try {
                getPurchaseMapper(sqlSession).deleteAll();
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete all Purchases {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public int getSumPurchase(Purchase purchase) {
        LOGGER.debug("DAO get sumPurchase ");
        try (SqlSession sqlSession = getSession()) {
            return sqlSession.selectOne("PurchaseMapper.getSumPurchase",purchase.getId());


        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get sumPurchase {}", ex);
            throw ex;
        }
    }

    @Override
    public Purchase updateSum(Purchase purchase,int sum) {
        LOGGER.debug("Update purchase's sum {}", purchase);
        try (SqlSession sqlSession = getSession()) {
            try {
                purchase.setSum(sum);
                getPurchaseMapper(sqlSession).updatePurchaseSum(purchase,sum);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't update purchase's sum {} {} ", purchase, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return purchase;
    }


    @Override
    public List<Purchase> getByBuyer(Buyer buyer) {
        LOGGER.debug("DAO get Purchases by buyer {}", buyer);
        try (SqlSession sqlSession = getSession()) {
            return getPurchaseMapper(sqlSession).getByBuyer(buyer);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get Purchases by buyer {}{}",buyer, ex);
            throw ex;
        }
    }

    @Override
    public List<Purchase> getByPurchaseDate(Timestamp purchaseDate) {
        LOGGER.debug("Can't get Purchases by purchaseDate {}",purchaseDate);
        try (SqlSession sqlSession = getSession()) {
            return getPurchaseMapper(sqlSession).getByPurchaseDate(purchaseDate);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get Purchases by purchaseDate{}{}",purchaseDate, ex);
            throw ex;
        }
    }

    @Override
    public List<Purchase> getByPurchaseDateAndBuyer(Timestamp purchaseDate, Buyer buyer) {
        LOGGER.debug("DAO get Purchases by purchase date and buyer {}{}",purchaseDate,buyer);
        try (SqlSession sqlSession = getSession()) {
            return getPurchaseMapper(sqlSession).getByPurchaseDateAndBuyer(buyer,purchaseDate);
    }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get Purchases by purchase date and buyer {}{}{}",purchaseDate,buyer, ex);
            throw ex;
        }
    }

    @Override
    public List<Purchase> getByBuyerAndPayment(Buyer buyer, Payment payment) {
        LOGGER.debug("Can't get Purchases by buyer And payment{}{}",buyer,payment);
        try (SqlSession sqlSession = getSession()) {
            return getPurchaseMapper(sqlSession).getByBuyerAndPayment(buyer, payment);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get Purchases by buyer And payment{}{}{}",buyer,payment, ex);
            throw ex;
        }
    }

    @Override
    public List<SelectedProductInPurchase> getProductsInPurchase(Integer buyerId) {
        LOGGER.debug("DAO get selected Products in purchase ");
        try (SqlSession sqlSession = getSession()) {
            return sqlSession.selectList("PurchaseMapper.getProductsInPurchase",buyerId);

        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get selected Products  in purchase  {}", ex);
            throw ex;
        }
    }
}
