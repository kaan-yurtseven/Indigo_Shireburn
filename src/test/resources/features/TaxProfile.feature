Feature: Tax Profile Page
  Background:
    Given As a user should be on login page
    Given user enters the valid username
    Given user enters the valid password
    Given user clicks the login button
    Given user clicks the Tax Profile button
    Given user should be on Tax Profile page

  Scenario: Tax Profile Page menu buttons
    Then verify submenu under the Tax profile page
    Then verify buttons are not clickable below
      |save       |
      |cancel     |
      |paste      |

    Scenario: enable buttons after clicking add button
      When user clicks the add button
      Then verify buttons are clickable below
        | save         |
        | cancel       |
        | filterSearch |



  Scenario:  Verify error message when user adds data without Tax Profile description data
    When user clicks the add button
    And user enter Tax profile description below
      |FSS MAIN METHOD|
    Then Verify the error message

  Scenario: Verify error message when user adds data without Tax Profile data
    When user clicks the add button
    And user enter Tax profile data below
      |KAAN1 |
    Then Verify the error message

  Scenario Outline: Delete Tax Profile Menu

    And User selects this "<Tax profile data>" and deletes it.
    Then Verify the error message

    Examples:
      | Tax profile data |
      | KAAN110       |
      | KAAN20            |
      | KAAN30            |

    @Add
  Scenario Outline: Add Tax Profile Menu
    When user clicks the add button
    And user enter some "<Tax profile data>","<Tax profile description>","<FSS Status>","<Tax on annual gross>"
    And user enters the accept button
    Then Verify the error message
    Examples:
      | Tax profile data | Tax profile description | FSS Status    | Tax on annual gross |
      | KAAN110         | FSS MAIN METHOD         | FSS MAIN      | CHECKED             |
    | KAAN20           | SPECIAL TAX             | FSS MAIN      | UNCHECKED           |
      | KAAN30           | PARENT TAX              | FSS PART TIME | CHECKED             |

  Scenario Outline: Delete Tax Profile Menu

    And User selects this "<Tax profile data>" and deletes it.
    Then Verify the error message

    Examples:
      | Tax profile data |
      | KAAN110       |
      | KAAN20            |
      | KAAN30            |

  Scenario Outline: Add Tax Profile Menu with same code name
    When user clicks the add button
    And user enter some "<Tax profile data>","<Tax profile description>","<FSS Status>","<Tax on annual gross>"
    And user enters the accept button
    And user enter some "<Tax profile data>","<Tax profile description>","<FSS Status>","<Tax on annual gross>"
    And user enters the accept button
    Then Verify the error message
    Examples:
      | Tax profile data | Tax profile description | FSS Status    | Tax on annual gross |
      | KAAN112          | FSS MAIN METHOD         | FSS MAIN      | CHECKED             |
      | KAAN2            | SPECIAL TAX             | FSS MAIN      | UNCHECKED           |
      | KAAN3            | PARENT TAX              | FSS PART TIME | CHECKED             |
