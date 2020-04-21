package ru.omsu.imit.dto.response;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BuyerResponse {
    private int id;
    private String firstName;
    private String secondName;
    private String patronymic;
    private Date birthday;
    private String login;
    private String telephoneNum,email;

    private BasketResponse basket;
    private List<PurchaseResponse> purchases;


    public BuyerResponse(int id, String firstName, String secondName, String patronymic, Date birthday, String email
            , String login){
        this.id=id;
        this.firstName=firstName;
        this.secondName=secondName;
        this.patronymic=patronymic;
        this.birthday=birthday;
        this.email=email;
        this.login = login;
        this.purchases = new ArrayList<>();
    }
    public BuyerResponse(){}
    public BuyerResponse(int id, String firstName, String secondName, String patronymic, Date birthday, String email,
                         String login, String telephoneNum){
        this(id, firstName, secondName, patronymic, birthday, email,login);
        this.telephoneNum = telephoneNum;
    }

    public BuyerResponse(int id, String firstName, String secondName, String patronymic, Date birthday,String email,
                         String login, String telephoneNum, BasketResponse basket) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.telephoneNum = telephoneNum;
        this.email = email;
        this.login = login;
        this.basket = basket;
        this.purchases = new ArrayList<>();
    }

    public BuyerResponse(int id, String firstName, String secondName, String patronymic, Date birthday,String email,
                         String login,String telephoneNum,  BasketResponse basket, List<PurchaseResponse> purchases) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.telephoneNum = telephoneNum;
        this.email = email;
        this.login = login;
        this.basket = basket;
        this.purchases = purchases;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public BasketResponse getBasket() {
        return basket;
    }

    public void setBasket(BasketResponse basket) {
        this.basket = basket;
    }

    public List<PurchaseResponse> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseResponse> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuyerResponse)) return false;

        BuyerResponse that = (BuyerResponse) o;

        if (getId() != that.getId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getSecondName() != null ? !getSecondName().equals(that.getSecondName()) : that.getSecondName() != null)
            return false;
        if (getPatronymic() != null ? !getPatronymic().equals(that.getPatronymic()) : that.getPatronymic() != null)
            return false;
        if (getBirthday() != null ? !getBirthday().equals(that.getBirthday()) : that.getBirthday() != null)
            return false;
        if (getLogin() != null ? !getLogin().equals(that.getLogin()) : that.getLogin() != null) return false;
        if (getTelephoneNum() != null ? !getTelephoneNum().equals(that.getTelephoneNum()) : that.getTelephoneNum() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
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
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (getTelephoneNum() != null ? getTelephoneNum().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getBasket() != null ? getBasket().hashCode() : 0);
        result = 31 * result + (getPurchases() != null ? getPurchases().hashCode() : 0);
        return result;
    }

    /*@Override
    public String toString() {
        return "Buyer [" +
                "id=" + id +
                ", firstName='" + firstName  +
                ", secondName='" + secondName  +
                ", patronymic='" + patronymic +
                ", birthday='" + birthday  +
                ", telephoneNum='" + telephoneNum +
                ", email='" + email  +
                ", basket=" + basket +
                ", purchases=" + purchases +
                "]";
    }*/

    @Override
    public String toString() {
        return "BuyerResponse{" +
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
