@searchProduct
Feature: Search and place the order for products

  Scenario: Search experience for product search in both home page and offer page
    Given user is on greenkart landing page
    When user searched with short name "tom" and extracted acutal name of product
    Then user search "tom" short name in offers page to check if product exist
