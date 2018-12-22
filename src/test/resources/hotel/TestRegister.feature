Feature: TestRegister
  for test add new Staff account

  Scenario: Admin Create New Account #1 // true
    Given Admin want to create new account
    And Admin enter a ID : 1234567890000
    And Admin enter a username : testAdd
    And Admin enter a password : test1234
    And Admin enter a firstname : FirstNameTest
    And Admin enter a lastname : LasNameTest
    When Admin confirm
    Then The account has been created and record to database



  Scenario: Admin Create Duplicate Account #2 // false
    Given Admin want to create duplicate account
    And Admin enter duplicate ID : 1234567890000
    And Admin enter duplicate username : testAdd
    And Admin enter duplicate password : test1234
    And Admin enter duplicate firstname : FirstNameTest
    And Admin enter duplicate lastname : LasNameTest
    When Admin confirm
    Then The account has not create because it duplicate in database : false