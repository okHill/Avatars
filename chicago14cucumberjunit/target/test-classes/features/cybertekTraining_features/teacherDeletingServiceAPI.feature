Feature: Deleting teacher service

  @teacherDelete
  Scenario: Positive teacher deleting
    Given user deletes teacher at "/teacher/delete/10665"
    And user gets teacher at "/teacher/10665"
    Then user verifies response message with "Teacher with id = 10665 NOT FOUND!"