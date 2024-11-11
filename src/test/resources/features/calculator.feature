Feature: VAT Calculator

  Scenario: Basic VAT Calculation with Net Amount as Input
    When I select the country "Germany"
    And I select the VAT rate "19"
    And I enter the net amount "100.00"
    Then I should see the gross amount "119.00" and the VAT amount "19.00"

 Scenario: Negative Value Input
    When I select the country "United Kingdom"
    And I enter the net amount "-100.00"
    Then I should see an error message "Negative values are invalid for a pie chart."