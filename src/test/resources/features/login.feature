Feature: Amazon Application Search

  @login
  Scenario: Search a product in amazon and add it in the cart
    Given user launch the amazon application
    When user search the product "Titan Watch" in search box
    Then user added a item into cart
    And verify the cart has an item
