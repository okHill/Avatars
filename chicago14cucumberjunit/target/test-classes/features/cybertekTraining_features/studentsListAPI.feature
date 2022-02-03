Feature: Student list by Batch Number


  @batchId

  Scenario Outline: Getting list of Students By Batch Number

    Given user get student at "<resource>"
    And user validates data from response bu "<batchID>"

    Examples:
      | resource          | batchID |
      | /student/batch/14 | 14      |



  @studentDelete
  Scenario Outline: Deleting Student End to End Scenario

    Given user deletes student with "<resource>"
    And user goes to cybertek training application
    Then user searches for student with "<studentID>"
    And user verifies that no result is shown

    Examples:

      | resource              | studentID |
      | /student/delete/17262 | 17262     |


  @createStudent
  Scenario: Student creation with API E2E scenario

    Given user creates student with the following data "/student/create"

      | firstName        | Cristiano       |
      | lastName         | Ronaldo         |
      | emailAddress     | messi@gmail,com |
      | joinDate         | 01/01/2010      |
      | password         | 123jbr          |
      | subject          | Math            |
      | phone            | 3210989876      |
      | gender           | Male            |
      | admissionNo      | 10              |
      | birthDate        | 01/01/1990      |
      | major            | Football        |
      | batch            | 14              |
      | section          | WorldCup        |
      | premanentAddress | 123 Main St     |
      | companyName      | Barcelona       |
      | title            | Goatie          |
      | startDate        | 01/02/2010      |
      | city             | Barcelona       |
      | street           | 123 Main        |
      | zipCode          | 373878          |
      | state            | IL              |

    And user goes to cybertek training application
    Then user searches for student with newly created student ID
    And user verifies that student created




