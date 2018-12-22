package Model;

public class User {
    private String iDentify;
    private String userName;
    private String firstName;
    private String lastName;
    private String phone;
    private String eMail;
    private String passWord;

    public static User instance;

    public static User getInstance(){
        if (instance == null){
            instance = new User();
        }
        return instance;
    }

    public User(String iDentify, String userName, String firstName, String lastName,String phone, String eMail, String passWord) {
        this.iDentify = iDentify;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.eMail = eMail;
        this.passWord = passWord;
    }

    public User(){

    }

    public static User getUserObject() {
        return instance;
    }

    public String getiDentify() {
        return iDentify;
    }

    public void setiDentify(String iDentify) {
        this.iDentify = iDentify;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "ID= " + iDentify + "| Username= " + userName + "| Firstname= " + firstName +
                "| Lastname= " + lastName +"| Phone= "+ phone + "| E-mail= " + eMail + "| Password= " + passWord ;
    }


}
