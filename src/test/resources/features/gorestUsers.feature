Feature : User Management API
  As a user
  I want to retrieve a list of users
  So that I can view all users in the system

  @getAllUsers
  Scenario: Get all users
    Given there are at least 10 users in the system
    And all users are requested
    When a status code 200 is returned
    Then 10 users are returned

#  @createUser
#  Scenario: Create user
#    When the following user is created
#      | name     | email                | status | gender |
#      | John Doe | john.doe10@gmail.com | Active | Male   |
#    Then a status code 200 is returned
#    And the following user is returned
#      | name     | email                | status | gender |
#      | John Doe | john.doe10@gmail.com | Active | Male   |