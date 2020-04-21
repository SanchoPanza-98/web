package ru.omsu.imit.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import ru.omsu.imit.model.Basket;
import ru.omsu.imit.model.Buyer;

public interface BasketMapper {

    @Insert("INSERT INTO basket ( buyerid ) VALUES " +
            "( #{basket.buyer.id} )" )
    @Options(useGeneratedKeys = true)
    public Integer insert(@Param("basket")Basket basket);

    @Select("SELECT * from basket WHERE id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "buyer", column = "buyerid", javaType = Buyer.class,
                    one = @One(select = "ru.omsu.imit.mappers.BuyerMapper.getById", fetchType = FetchType.LAZY))})
    public Basket getById(int id);

    @Select("SELECT * from basket WHERE buyerid = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "buyer", column = "buyerid", javaType = Buyer.class,
                    one = @One(select = "ru.omsu.imit.mappers.BuyerMapper.getById", fetchType = FetchType.LAZY))})
    public Basket getByBuyer(@Param("id") int buyerId );

    @Delete("DELETE FROM basket WHERE id=#{id} ")
    public Integer deleteBasket(@Param("id") Integer id);

    @Delete("DELETE FROM basket")
    public void deleteAll();






}
