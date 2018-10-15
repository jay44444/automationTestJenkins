@tag
Feature: Test Amazon site
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Test User login when valid credentials are given
    Given Open Google Chrome
    #When I entered valid "<username>" and "<password>"
    #Then User should be able to login successfully
    When I search for "<Product>"
    Then Results should be displayed
    When I clicked a specific Product
    Then its price will be printed

    Examples: 
      | username | password | Product |
      |          |          | Iphone8 |
