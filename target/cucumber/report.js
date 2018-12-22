$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("hotel/TestRegister.feature");
formatter.feature({
  "line": 1,
  "name": "TestRegister",
  "description": "for test add new Staff account",
  "id": "testregister",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Admin Create New Account #1 // true",
  "description": "",
  "id": "testregister;admin-create-new-account-#1-//-true",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Admin want to create new account",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Admin enter a ID : 1234567890000",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Admin enter a username : testAdd",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Admin enter a password : test1234",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Admin enter a firstname : FirstNameTest",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Admin enter a lastname : LasNameTest",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Admin confirm",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "The account has been created and record to database",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefIncome.admin_want_to_create_new_account()"
});
formatter.result({
  "duration": 834577331,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1234567890000",
      "offset": 19
    }
  ],
  "location": "StepDefIncome.admin_enter_a_ID(int)"
});
formatter.result({
  "duration": 33100605,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testAdd",
      "offset": 25
    }
  ],
  "location": "StepDefIncome.admin_enter_a_username_testAdd(String)"
});
formatter.result({
  "duration": 2207311,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test1234",
      "offset": 25
    }
  ],
  "location": "StepDefIncome.admin_enter_a_password_test(String)"
});
formatter.result({
  "duration": 126458,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "FirstNameTest",
      "offset": 26
    }
  ],
  "location": "StepDefIncome.admin_enter_a_firstname_test(String)"
});
formatter.result({
  "duration": 116061,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LasNameTest",
      "offset": 25
    }
  ],
  "location": "StepDefIncome.admin_enter_a_lastname_test(String)"
});
formatter.result({
  "duration": 742114,
  "status": "passed"
});
formatter.match({
  "location": "StepDefIncome.admin_confirm()"
});
formatter.result({
  "duration": 136511,
  "status": "passed"
});
formatter.match({
  "location": "StepDefIncome.the_account_has_been_created_and_record_to_database()"
});
formatter.result({
  "duration": 14667627,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Admin Create Duplicate Account #2 // false",
  "description": "",
  "id": "testregister;admin-create-duplicate-account-#2-//-false",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "Admin want to create duplicate account",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "Admin enter duplicate ID : 1234567890000",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "Admin enter duplicate username : testAdd",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Admin enter duplicate password : test1234",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "Admin enter duplicate firstname : FirstNameTest",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Admin enter duplicate lastname : LasNameTest",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Admin confirm",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "The account has not create because it duplicate in database : false",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefIncome.admin_want_to_create_duplicate_account()"
});
formatter.result({
  "duration": 666877,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1234567890000",
      "offset": 27
    }
  ],
  "location": "StepDefIncome.admin_enter_duplicate_ID(int)"
});
formatter.result({
  "duration": 217524,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testAdd",
      "offset": 33
    }
  ],
  "location": "StepDefIncome.admin_enter_duplicate_username_testAdd(String)"
});
formatter.result({
  "duration": 409146,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test1234",
      "offset": 33
    }
  ],
  "location": "StepDefIncome.admin_enter_duplicate_password_test(String)"
});
formatter.result({
  "duration": 111553,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "FirstNameTest",
      "offset": 34
    }
  ],
  "location": "StepDefIncome.admin_enter_duplicate_firstname_FirstNameTest(String)"
});
formatter.result({
  "duration": 97495,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LasNameTest",
      "offset": 33
    }
  ],
  "location": "StepDefIncome.admin_enter_duplicate_lastname_LasNameTest(String)"
});
formatter.result({
  "duration": 94386,
  "status": "passed"
});
formatter.match({
  "location": "StepDefIncome.admin_confirm()"
});
formatter.result({
  "duration": 36688,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 62
    }
  ],
  "location": "StepDefIncome.the_account_has_not_create_because_it_duplicate_in_database_false(String)"
});
formatter.result({
  "duration": 5518266,
  "status": "passed"
});
formatter.uri("hotel/TestReserve.feature");
formatter.feature({
  "line": 1,
  "name": "TestReserve",
  "description": "for test reserve room",
  "id": "testreserve",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Staff reserve the room",
  "description": "",
  "id": "testreserve;staff-reserve-the-room",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Customer want to reserve room",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Staff click the room to reserve",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Staff enter a FirstName : Kanapos",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Staff enter a LastName : La-orsuwan",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Staff enter a Passport : 1100501383813",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Staff enter a Sex : male",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Staff enter a Email : kanapas.l@ku.th",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Staff enter a PhoneNumber : 0855670555",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Staff enter a Check-in : 2018-12-20",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Staff enter a Check-out : 2018-12-22",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Staff click confirm",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "The account has been created and record to database",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefIncome.customer_want_to_reserve_room()"
});
formatter.result({
  "duration": 98936,
  "status": "passed"
});
formatter.match({
  "location": "StepDefIncome.staff_click_the_room_to_reserve()"
});
formatter.result({
  "duration": 8953806,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Kanapos",
      "offset": 26
    }
  ],
  "location": "StepDefIncome.staff_enter_a_FirstName(String)"
});
formatter.result({
  "duration": 1075769,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "La-orsuwan",
      "offset": 25
    }
  ],
  "location": "StepDefIncome.staff_enter_a_lastName(String)"
});
formatter.result({
  "duration": 553479,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1100501383813",
      "offset": 25
    }
  ],
  "location": "StepDefIncome.staff_enter_a_passport(String)"
});
formatter.result({
  "duration": 126077,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "male",
      "offset": 20
    }
  ],
  "location": "StepDefIncome.staff_enter_a_sex(String)"
});
formatter.result({
  "duration": 845553,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "kanapas.l@ku.th",
      "offset": 22
    }
  ],
  "location": "StepDefIncome.staff_enter_a_email(String)"
});
formatter.result({
  "duration": 124966,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0855670555",
      "offset": 28
    }
  ],
  "location": "StepDefIncome.staff_enter_a_phoneNumber(String)"
});
formatter.result({
  "duration": 109437,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2018-12-20",
      "offset": 25
    }
  ],
  "location": "StepDefIncome.staff_enter_a_checkIn(String)"
});
formatter.result({
  "duration": 1022141,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2018-12-22",
      "offset": 26
    }
  ],
  "location": "StepDefIncome.staff_enter_a_checkOut(String)"
});
formatter.result({
  "duration": 331800,
  "status": "passed"
});
formatter.match({
  "location": "StepDefIncome.staff_confirm()"
});
formatter.result({
  "duration": 39596,
  "status": "passed"
});
formatter.match({
  "location": "StepDefIncome.the_account_has_been_created_and_record_to_database()"
});
formatter.result({
  "duration": 652566,
  "error_message": "java.lang.NullPointerException\n\tat csku.hotel.StepDefIncome.the_account_has_been_created_and_record_to_database(StepDefIncome.java:64)\n\tat ✽.Then The account has been created and record to database(hotel/TestReserve.feature:16)\n",
  "status": "failed"
});
});