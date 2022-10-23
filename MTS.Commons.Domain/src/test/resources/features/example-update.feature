# language: en
@example-update
Feature: Example Update

  Scenario: Update Example
    Given a valid Example
    When save Example
    Then Example is saved

  Scenario: Valide Example Required Fields
    Given an empty Example
    When trying to save Example
    Then throws 3 validation errors
      | validation.example.id.not_null    |
      | validation.example.name.not_blank |
      | validation.example.type.not_blank |

  Scenario: Valide Example Id Format
    Given a valid Example
    And with the Id -1
    When trying to save Example
    Then throws the validation error 'validation.example.id.must_not_be_negative'

  Scenario: Valide Example Name Format
    Given a valid Example
    And with the Name 'Example1'
    When trying to save Example
    Then throws the validation error 'validation.example.name.must_not_contain_digits'

  Scenario: Valide Example Type Format
    Given a valid Example
    And with the Type 'Z'
    When trying to save Example
    Then throws the validation error 'validation.example.type.must_be_ABC'

