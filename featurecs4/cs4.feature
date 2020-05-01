Feature: scenario outline

Scenario Outline: For searching product user must registered and login using valid credentials

Given Megha has registered into TestmeApp
When Megha enters username as "<username>" and password as "<password>"

Examples: -
| username | password |
| lalitha | password123 |

Scenario Outline: the one where the user moves to cart without adding any item in it
When user search for a particular product and enter product as "<name>"
And try to proceed to payment without adding product into cart
Then TestmeApp doesn't display the cart icon

Examples: -
| name |
| head |