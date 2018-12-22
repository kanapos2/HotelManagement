package csku.hotel;

import Model.Room;
import Model.User;
import Store.DBConnector;
import Store.RoomDBConnector;
import Store.UserDBControl;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefIncome {
    User user = new User();
    UserDBControl dbControl;

    @BeforeEach
    public void initial(){
        user = User.getInstance();
    }

    @Given("^Admin want to create new account$")
    public void admin_want_to_create_new_account() throws Throwable {
        dbControl = DBConnector.openUserDB();
    }

    @And("^Admin enter a ID : (.*)")
    public void admin_enter_a_ID(int arg1) throws Throwable {
         user.setiDentify(String.valueOf(arg1));
    }

    @And("^Admin enter a username : (.*)")
    public void admin_enter_a_username_testAdd(String username) throws Throwable {
        user.setUserName(username);
    }

    @And("^Admin enter a password : (.*)")
    public void admin_enter_a_password_test(String pass) throws Throwable {
        user.setPassWord(pass);
    }

    @And("^Admin enter a firstname : (.*)")
    public void admin_enter_a_firstname_test(String first) throws Throwable {
        user.setFirstName(first);
    }

    @And("^Admin enter a lastname : (.*)")
    public void admin_enter_a_lastname_test(String last) throws Throwable {
        user.setLastName(last);
    }

    @When("^Admin confirm$")
    public void admin_confirm() throws Throwable {
    }

    @Then("^The account has been created and record to database$")
    public void the_account_has_been_created_and_record_to_database() throws Throwable {
        dbControl.addUser(user);
    }

    ////////////////////////////////////

    @Given("^Admin want to create duplicate account$")
    public void admin_want_to_create_duplicate_account() throws Throwable {
        dbControl = DBConnector.openUserDB();
    }

    @And("^Admin enter duplicate ID : (.*)")
    public void admin_enter_duplicate_ID(int arg1) throws Throwable {
        user.setiDentify(String.valueOf(arg1));
    }

    @And("^Admin enter duplicate username : (.*)")
    public void admin_enter_duplicate_username_testAdd(String username) throws Throwable {
        user.setUserName(username);
    }

    @And("^Admin enter duplicate password : (.*)")
    public void admin_enter_duplicate_password_test(String pass) throws Throwable {
        user.setPassWord(pass);
    }

    @And("^Admin enter duplicate firstname : (.*)")
    public void admin_enter_duplicate_firstname_FirstNameTest(String first) throws Throwable {
        user.setFirstName(first);
    }

    @And("^Admin enter duplicate lastname : (.*)")
    public void admin_enter_duplicate_lastname_LasNameTest(String last) throws Throwable {
        user.setLastName(last);
    }

    @Then("^The account has not create because it duplicate in database : (.*)")
    public void the_account_has_not_create_because_it_duplicate_in_database_false(String result) throws Throwable {
        Assert.assertEquals(result,String.valueOf(dbControl.addUser(user)));
    }


    ////////////////////////////////////////////////////////////

    Room room = new Room();
    RoomDBConnector dbControl_Add;

    @BeforeEach
    public void initialize(){
        room.setRoomNumber("B202");
    }

    @Given("^Customer want to reserve room$")
    public void customer_want_to_reserve_room() throws Throwable {
    }

    @Then("^Staff click the room to reserve$")
    public void staff_click_the_room_to_reserve() throws Throwable {
        dbControl_Add = DBConnector.openRoomDB() ;
    }

    @And("^Staff enter a FirstName : (.*)")
    public void staff_enter_a_FirstName(String firstName) throws Throwable {
        room.setFirstName(firstName);
    }

    @And("^Staff enter a LastName : (.*)")
    public void staff_enter_a_lastName(String lastName) throws Throwable {
        room.setLastName(lastName);
    }

    @And("^Staff enter a Passport : (.*)")
    public void staff_enter_a_passport(String passport) throws Throwable {
        room.setPassport(passport);
    }

    @And("^Staff enter a Sex : (.*)")
    public void staff_enter_a_sex(String sex) throws Throwable {
        room.setSex(sex);
    }

    @And("^Staff enter a Email : (.*)")
    public void staff_enter_a_email(String email) throws  Throwable {
        room.setEmail(email);
    }

    @And("^Staff enter a PhoneNumber : (.*)")
    public void staff_enter_a_phoneNumber(String phoneNumber) throws  Throwable {
        room.setPhoneNumber(phoneNumber);
    }

    @And("^Staff enter a Check-in : (.*)")
    public void staff_enter_a_checkIn(String CheckIn) throws  Throwable {
        room.setCheckIn(CheckIn);
    }

    @And("^Staff enter a Check-out : (.*)")
    public void staff_enter_a_checkOut(String CheckOut) throws  Throwable {
        room.setCheckOut(CheckOut);
    }

    @When("^Staff click confirm$")
    public void staff_confirm() throws Throwable {
    }

    @Then("^The room has been created and record to database$")
    public void the_room_has_been_created_and_record_to_database() throws Throwable {
        dbControl_Add.addInformation(room,1);
    }


}
