package ru.omsu.imit.mappers;

import org.apache.ibatis.annotations.*;
import ru.omsu.imit.model.*;


public interface SelectedProductInPurchaseMapper {

    @Insert("INSERT INTO selectedProductsInPurchase( purchaseid,productid, quantity) VALUES " +
            "( #{selectedProduct.purchase.id},#{selectedProduct.product.id}," +
            "#{selectedProduct.quantity})" )
    @Options(useGeneratedKeys = true, keyColumn = "id")
    public Integer insert(@Param("selectedProduct") SelectedProductInPurchase selectedProduct);

    @Select("SELECT * FROM selectedProductsInPurchase WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id")
    })
    public SelectedProductInPurchase getById(int id);


    @Delete("DELETE FROM selectedProductsInPurchase")
    public int deleteAll();

    @Delete("DELETE FROM selectedProductsInBasket WHERE selectedProductsInPurchase.purchaseid = #{purchase.id}" +
            " AND selectedProductsInBasket.productid = #{product.id}")
    public int deleteByPurchase(@Param("purchase")Purchase purchase);


}