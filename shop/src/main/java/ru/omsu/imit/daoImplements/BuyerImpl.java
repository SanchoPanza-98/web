package ru.omsu.imit.daoImplements;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.dao.BuyerDAO;
import ru.omsu.imit.model.Buyer;
import ru.omsu.imit.model.Role;
import ru.omsu.imit.model.User;

import java.util.List;

public class BuyerImpl extends BaseDAOImpl implements BuyerDAO {

        private static final Logger LOGGER = LoggerFactory.getLogger(BuyerImpl.class);

        @Override
        public Buyer insert(Buyer buyer) throws MySQLIntegrityConstraintViolationException {
            LOGGER.debug("DAO Insert Buyer {}", buyer);

            try (SqlSession sqlSession = getSession()) {
                try {
                    User user = new User(buyer.getUserId(),buyer.getLogin(),buyer.getPassword(), Role.BUYER);
                    getUserMapper(sqlSession).insert(user);
                    buyer.setUserId(user.getUserId());
                    getBuyerMapper(sqlSession).insert(buyer);
                } catch (RuntimeException ex) {
                    LOGGER.debug("Can't insert buyer {} {}", buyer, ex);
                    sqlSession.rollback();
                    throw ex;
                } catch (MySQLIntegrityConstraintViolationException e) {
                    LOGGER.debug("Duplicate email or telephone's number {} {}",buyer,e);
                    sqlSession.rollback();
                    throw e;

                }
                sqlSession.commit();
            }
            return buyer;
        }

        @Override
        public Buyer getById(int id){
            LOGGER.debug("DAO Get buyer by id {}",id);
            try (SqlSession sqlSession = getSession()) {
                return getBuyerMapper(sqlSession).getById(id);
            }
            catch (RuntimeException ex) {
                LOGGER.debug("Can't get Buyer{}", ex);
                throw ex;
            }
        }

    @Override
    public void deleteAll() {
        LOGGER.debug("DAO Delete All Buyers");
        try (SqlSession sqlSession = getSession()) {
            try {
                getBuyerMapper(sqlSession).deleteAll();
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete all Buyers {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public Buyer updateBuyer(Buyer buyer) {
        LOGGER.debug("Update buyer {}", buyer);
        try (SqlSession sqlSession = getSession()) {
            try {
                Buyer updateBuyer = getById(buyer.getId());
                User user = new User(updateBuyer.getUserId(),updateBuyer.getLogin(),updateBuyer.getPassword(),Role.BUYER);
                getUserMapper(sqlSession).update(user);
                getBuyerMapper(sqlSession).updateBuyer(buyer);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't update buyer {} {} ", buyer, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return buyer;
    }

    @Override
    public List<Buyer> getAllLazy() {
        LOGGER.debug("DAO get All Lazy ");
        try (SqlSession sqlSession = getSession()) {
            return getBuyerMapper(sqlSession).getAllLazy();
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get All Lazy {}", ex);
            throw ex;
        }
    }


    @Override
    public Buyer delete(Buyer buyer) {
        LOGGER.debug("DAO Can't delete Buyer {}", buyer);
        try (SqlSession sqlSession = getSession()) {
            try {
                Buyer deleteBuyer = getById(buyer.getId());
                User user = new User(deleteBuyer.getUserId(),deleteBuyer.getLogin(),deleteBuyer.getPassword(),Role.BUYER);
                getUserMapper(sqlSession).delete(user);
                getBuyerMapper(sqlSession).delete(buyer);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete Buyer {} {}", buyer, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return buyer;
    }

}
