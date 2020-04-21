package ru.omsu.imit.daoImplements;

import org.apache.ibatis.session.SqlSession;
import ru.omsu.imit.mappers.*;
import ru.omsu.imit.model.User;
import ru.omsu.imit.utils.MyBatisUtils;

public class BaseDAOImpl {
	protected SqlSession getSession() {
		return MyBatisUtils.getSqlSessionFactory().openSession();
	}
	protected BuyerMapper getBuyerMapper(SqlSession sqlSession) {
		return sqlSession.getMapper(BuyerMapper.class);
	}
	protected BasketMapper getBasketMapper(SqlSession sqlSession){return sqlSession.getMapper(BasketMapper.class);}
	protected ProductMapper getProductMapper(SqlSession sqlSession){return sqlSession.getMapper(ProductMapper.class);}
	protected PurchaseMapper getPurchaseMapper(SqlSession sqlSession){return sqlSession.getMapper(PurchaseMapper.class);}
	protected SelectedProductInBasketMapper getSelectedProductsMapper(SqlSession sqlSession){
		return sqlSession.getMapper(SelectedProductInBasketMapper.class);
	}
	protected SelectedProductInPurchaseMapper getSelectedProductsInPurchaseMapper(SqlSession sqlSession){
		return sqlSession.getMapper(SelectedProductInPurchaseMapper.class);
	}
	protected UserMapper getUserMapper(SqlSession sqlSession){
		return sqlSession.getMapper(UserMapper.class);
	}
}