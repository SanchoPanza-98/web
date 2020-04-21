package ru.omsu.imit.dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import ru.omsu.imit.model.Buyer;

import java.util.List;

public interface BuyerDAO {
    List<Buyer> getAllLazy();
    Buyer getById(int id);
    Buyer insert(Buyer buyer) throws MySQLIntegrityConstraintViolationException;
    Buyer delete (Buyer buyer);
    void deleteAll();
    Buyer updateBuyer(Buyer buyer);


}
