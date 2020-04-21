package ru.omsu.imit.dto.request.buyer;

import ru.omsu.imit.dto.request.BasketRequest;
import ru.omsu.imit.dto.request.PurchaseRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BuyerRequest {
    private int id;
    private String firstName;
    private String secondName;
    private String patronymic;
    private Date birthday;
    private String telephoneNum;
    private String email;
    private String login;
    private String password;
    private BasketRequest basket;
    private List<PurchaseRequest> purchases;

    public BuyerRequest() {
    }



    public BuyerRequest(int id, String firstName, String secondName, String patronymic, Date birthday, String email,
                        String login, String password){
        this.id=id;
        this.firstName=firstName;
        this.secondName=secondName;
        this.patronymic=patronymic;
        this.birthday=birthday;
        this.email=email;
        this.login = login;
        this.password = password;
        this.purchases = new ArrayList<>();
    }

    public BuyerRequest(int id, String firstName, String secondName, String patronymic, Date birthday, String email,
                        String login, String password, String telephoneNum){
        this(id, firstName, secondName, patronymic, birthday, email,login,password);
        this.telephoneNum = telephoneNum;
    }

    public BuyerRequest(int id, String firstName, String secondName, String patronymic, Date birthday,String email,
                        String login, String password , String telephoneNum, BasketRequest basket) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.telephoneNum = telephoneNum;
        this.email = email;
        this.login = login;
        this.password = password;
        this.basket = basket;
        this.purchases = new ArrayList<>();
    }

    public BuyerRequest(int id, String firstName, String secondName, String patronymic, Date birthday,
                        String email,String login, String password ,String telephoneNum,  BasketRequest basket, List<PurchaseRequest> purchases) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.telephoneNum = telephoneNum;
        this.email = email;
        this.login = login;
        this.password = password;
        this.basket = basket;
        this.purchases = purchases;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BasketRequest getBasket() {
        return basket;
    }

    public void setBasket(BasketRequest basket) {
        this.basket = basket;
    }

    public List<PurchaseRequest> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseRequest> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuyerRequest)) return false;

        BuyerRequest that = (BuyerRequest) o;

        if (getId() != that.getId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getSecondName() != null ? !getSecondName().equals(that.getSecondName()) : that.getSecondName() != null)
            return false;
        if (getPatronymic() != null ? !getPatronymic().equals(that.getPatronymic()) : that.getPatronymic() != null)
            return false;
        if (getBirthday() != null ? !getBirthday().equals(that.getBirthday()) : that.getBirthday() != null)
            return false;
        if (getTelephoneNum() != null ? !getTelephoneNum().equals(that.getTelephoneNum()) : that.getTelephoneNum() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getLogin() != null ? !getLogin().equals(that.getLogin()) : that.getLogin() != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (getBasket() != null ? !getBasket().equals(that.getBasket()) : that.getBasket() != null) return false;
        return getPurchases() != null ? getPurchases().equals(that.getPurchases()) : that.getPurchases() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getSecondName() != null ? getSecondName().hashCode() : 0);
        result = 31 * result + (getPatronymic() != null ? getPatronymic().hashCode() : 0);
        result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        result = 31 * result + (getTelephoneNum() != null ? getTelephoneNum().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (getBasket() != null ? getBasket().hashCode() : 0);
        result = 31 * result + (getPurchases() != null ? getPurchases().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BuyerRequest{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday='" + birthday + '\'' +
                ", telephoneNum='" + telephoneNum + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
