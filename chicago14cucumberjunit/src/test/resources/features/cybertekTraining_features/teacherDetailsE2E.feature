Feature: Teacher Details End to End for UI and API

  # Scenario Scenario Outline would be better for this project
  # Ctrl + Alt + L (Be careful on UBUNTU LINUX)


  Scenario Outline: UI vs. API cross data validation
    Given User gets teacher at "<resource>"
    And user goes to cybertek training application
    Then user opens teacher profile details page "<teacherID>"
    And user cross validates teacher details on API and UI


    Examples:
      | resource      | teacherID |
      | /teacher/9804 | 9804      |
      | /teacher/8982 | 8982      |
      | /teacher/8985 | 8985      |

  @e2e
  Scenario Outline: UI vs API cross data validation with name
    Given user gets teacher at "<resource>"
    And user goes to cybertek training application
    Then user searches for teachers with name "<teacherName>"
    And user cross validates teacher name result on API and on UI with "<teacherName>"


    Examples:
      | resource            | teacherName |
      | /teacher/name/Rahul | Rahul       |
