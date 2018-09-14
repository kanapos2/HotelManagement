package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class User {
    private SimpleIntegerProperty iDentify;
    private SimpleStringProperty userName;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty eMail;
    private SimpleStringProperty passWord;

    public User(SimpleIntegerProperty iDentify, SimpleStringProperty userName, SimpleStringProperty firstName, SimpleStringProperty lastName, SimpleStringProperty eMail, SimpleStringProperty passWord) {
        this.iDentify = iDentify;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.passWord = passWord;
    }

    public int getiDentify() {
        return iDentify.get();
    }

    public SimpleIntegerProperty iDentifyProperty() {
        return iDentify;
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return userName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public String geteMail() {
        return eMail.get();
    }

    public SimpleStringProperty eMailProperty() {
        return eMail;
    }

    public String getPassWord() {
        return passWord.get();
    }

    public SimpleStringProperty passWordProperty() {
        return passWord;
    }

    public void setiDentify(int iDentify) {
        this.iDentify.set(iDentify);
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void seteMail(String eMail) {
        this.eMail.set(eMail);
    }

    public void setPassWord(String passWord) {
        this.passWord.set(passWord);
    }
}
