package ru.omsu.imit.daoImplements;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.omsu.imit.dao.CommonDAO;

public class CommonDAOImpl extends BaseDAOImpl implements CommonDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseDAOImpl.class);
	
	@Override
	public void clear() {
		LOGGER.debug("Clear Database");
		try (SqlSession sqlSession = getSession()) {
			try {

				getBuyerMapper(sqlSession).deleteAll();

			} catch (RuntimeException ex) {
				LOGGER.debug("Can't clear database");
				sqlSession.rollback();
				throw ex;
			}
			sqlSession.commit();
		}
	}

}
