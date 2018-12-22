Feature: TestReserve
  for test reserve room

  Scenario: Staff reserve the room
    Given Customer want to reserve room
    Then Staff click the room to reserve
    And Staff enter a FirstName : Kanapos
    And Staff enter a LastName : La-orsuwan
    And Staff enter a Passport : 1100501383813
    And Staff enter a Sex : male
    And Staff enter a Email : kanapas.l@ku.th
    And Staff enter a PhoneNumber : 0855670555
    And Staff enter a Check-in : 2018-12-20
    And Staff enter a Check-out : 2018-12-22
    When Staff click confirm
    Then The account has been created and record to database

