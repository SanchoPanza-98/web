package ru.omsu.imit.daoImplements;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.model.User;
import ru.omsu.imit.model.Role;
import ru.omsu.imit.model.User;

public class UserDao extends BaseDAOImpl{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    public User getById(int id){
        LOGGER.debug("DAO Get user by id {}",id);
        try (SqlSession sqlSession = getSession()) {
            return getUserMapper(sqlSession).getById(id);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get User{}", ex);
            throw ex;
        }
    }

    public User getByLogin(String login){
        LOGGER.debug("DAO Get user by login {}",login);
        try (SqlSession sqlSession = getSession()) {
            return getUserMapper(sqlSession).getByLogin(login);
        }
        catch (RuntimeException ex) {
            LOGGER.debug("Can't get User by login{}", ex);
            throw ex;
        }
    }

    public User updateUser(User user) {
        LOGGER.debug("Update user {}", user);
        try (SqlSession sqlSession = getSession()) {
            try {
                getUserMapper(sqlSession).update(user);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't update user {} {} ", user, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return user;
    }

}
