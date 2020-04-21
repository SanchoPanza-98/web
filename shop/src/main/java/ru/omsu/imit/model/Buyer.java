package ru.omsu.imit.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Buyer extends User{
    private int id;
    private String firstName;
    private String secondName;
    private String patronymic;
    private Date birthday;
    private String email;
    private String telephoneNum;
    private Basket basket;
    private List<Purchase> purchases;

    public Buyer(){}

    public Buyer(int id,int userId, String firstName,String secondName,String patronymic,Date birthday,String email, String login,
                 String password, String telephoneNum){
        this(id,userId, firstName, secondName, patronymic, birthday, email, login , password, telephoneNum, null);
    }

    public Buyer(int id,int userId, String firstName, String secondName, String patronymic, Date birthday,
                 String email ,String login, String password, String telephoneNum,Basket basket) {
        this(id,userId,firstName,secondName,patronymic,birthday,email,login,password,telephoneNum,basket,new ArrayList<>());
    }

    public Buyer(int id,int userId, String firstName, String secondName, String patronymic, Date birthday,
                 String email,String login, String password, String telephoneNum,  Basket basket, List<Purchase> purchases) {
        super(userId, login, password,Role.BUYER);
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.telephoneNum = telephoneNum;
        this.email = email;
        this.basket = basket;
        this.purchases = purchases;
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

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buyer)) return false;

        Buyer buyer = (Buyer) o;

        if (getId() != buyer.getId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(buyer.getFirstName()) : buyer.getFirstName() != null)
            return false;
        if (getSecondName() != null ? !getSecondName().equals(buyer.getSecondName()) : buyer.getSecondName() != null)
            return false;
        if (getPatronymic() != null ? !getPatronymic().equals(buyer.getPatronymic()) : buyer.getPatronymic() != null)
            return false;
        if (getBirthday() != null ? !getBirthday().equals(buyer.getBirthday()) : buyer.getBirthday() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(buyer.getEmail()) : buyer.getEmail() != null) return false;
        if (getTelephoneNum() != null ? !getTelephoneNum().equals(buyer.getTelephoneNum()) : buyer.getTelephoneNum() != null)
            return false;
        if (getLogin() != null ? !getLogin().equals(buyer.getLogin()) : buyer.getLogin() != null) return false;
        if (getPassword() != null ? !getPassword().equals(buyer.getPassword()) : buyer.getPassword() != null)
            return false;
        if (getBasket() != null ? !getBasket().equals(buyer.getBasket()) : buyer.getBasket() != null) return false;
        return getPurchases() != null ? getPurchases().equals(buyer.getPurchases()) : buyer.getPurchases() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getSecondName() != null ? getSecondName().hashCode() : 0);
        result = 31 * result + (getPatronymic() != null ? getPatronymic().hashCode() : 0);
        result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getTelephoneNum() != null ? getTelephoneNum().hashCode() : 0);
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getBasket() != null ? getBasket().hashCode() : 0);
        result = 31 * result + (getPurchases() != null ? getPurchases().hashCode() : 0);
        return result;
    }

    @Override
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
    }
}
