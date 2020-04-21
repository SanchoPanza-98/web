package ru.omsu.imit.mappers;


import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import ru.omsu.imit.model.Buyer;
import java.util.List;

public interface BuyerMapper {
    @Insert("INSERT INTO buyer ( firstName, secondName, patronymic, birthday, email, telephoneNumber, userId ) " +
            "VALUES "
            + "( #{firstName}, #{secondName}, #{patronymic}, #{birthday}, #{email}, #{telephoneNum}, #{userId} )")
    @Options(useGeneratedKeys = true)
    public Integer insert(Buyer buyer) throws MySQLIntegrityConstraintViolationException;

    @Select("SELECT buyer.id as id, buyer.firstName as firstName, buyer.secondName as secondName, buyer.patronymic as patronymic, " +
            "buyer.birthday as birthday, buyer.email as email, buyer.telephoneNumber as telephoneNum, " +
            "user.id as userId, user.login as login, user.password as password FROM buyer JOIN user " +
            "ON buyer.userId = user.id WHERE buyer.id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result (property = "purchases" ,column = "id" , javaType = List.class,
                    many = @Many(select = "ru.omsu.imit.mappers.PurchaseMapper.getByBuyer" , fetchType = FetchType.LAZY) )})
    Buyer getById(int id);

    @Delete("DELETE FROM buyer")
    void deleteAll();

    @Select("SELECT buyer.id as id, buyer.firstName as firstName, buyer.secondName as secondName, buyer.patronymic as patronymic, " +
            "buyer.birthday as birthday, buyer.email as email, buyer.telephoneNumber as telephoneNum, " +
            "user.id as userId, user.login as login, user.password as password FROM buyer JOIN user " +
            "ON buyer.userId = user.id WHERE buyer.id = #{id}")
    @Results({
            @Result(property = "id", column = "id")
             })
    public List<Buyer> getAllLazy();

    @Delete("DELETE FROM buyer WHERE id = #{buyer.id}")
    public int delete(@Param("buyer") Buyer buyer);

    @Update("UPDATE buyer SET firstName = #{buyer.firstName},secondName = #{buyer.secondName}, " +
            "patronymic = #{buyer.patronymic}, telephoneNumber = #{buyer.telephoneNum}, email = #{buyer.email} " +
            "WHERE id = #{buyer.id} ")
    public void updateBuyer(@Param("buyer") Buyer buyer);
}
