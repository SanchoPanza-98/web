package ru.omsu.imit.mappers;

import org.apache.ibatis.annotations.*;
import ru.omsu.imit.model.*;
import java.sql.Timestamp;
import java.util.List;

public interface PurchaseMapper {
    @Insert("INSERT INTO purchase ( buyerid, purchaseDate, payment , sum) VALUES " +
            "( #{buyer.id},#{purchaseDate},#{payment},#{sum} )" )
    @Options(useGeneratedKeys = true)
    public Integer insert(Purchase purchase);

    @Select("SELECT * from purchase WHERE id= #{id}")
    public Purchase getById(@Param("id") Integer id);

    @Select("SELECT * from purchase WHERE buyerid= #{buyer.id}")
    public List<Purchase> getByBuyer(@Param("buyer") Buyer buyer);

    @Select("SELECT * from purchase")
    public List<Purchase> getAll();

    @Select("SELECT * from purchase WHERE purchaseDate= #{purchaseDate}")
    public List<Purchase> getByPurchaseDate(@Param("purchaseDate") Timestamp purchaseDate);

    @Select("SELECT * from purchase WHERE buyerid= #{buyer.id} AND purchaseDate= #{purchaseDate}")
    public List<Purchase> getByPurchaseDateAndBuyer(@Param("buyer") Buyer buyer,
                                                    @Param("purchaseDate") Timestamp purchaseDate);

    @Select("SELECT * from purchase WHERE buyerid= #{buyer.id} AND payment= #{payment}")
    public List<Purchase> getByBuyerAndPayment(@Param("buyer") Buyer buyer,
                                               @Param("payment") Payment payment);
    @Delete("DELETE FROM purchase")
    public void deleteAll();

    @Update("UPDATE purchase SET sum = #{sumPurchase} WHERE id = #{purchase.id} ")
    public void updatePurchaseSum(@Param("purchase") Purchase purchase, @Param("sumPurchase") int sumPurchase);
}
