# Design Document

## Instructions

## Group 3 - Midstone Design

## 1. Problem Statement

I will be creating a web app that will allow you to store monthly and yearly expenses to help track expenses and budget for future purchases. This will be a simple way to view expenses and make better financial decisions

## 2. Top Questions to Resolve in Review

_List the most important questions you have about your design, or things that you are still debating internally that you might like help working through._

1. 
2.
3.

## 3. Use Cases

_This is where we work backwards from the customer and define what our customers would like to do (and why). You may also include use cases for yourselves (as developers), or for the organization providing the product to customers._

U1. As a user, I would like to be able to know how much money I have to spend at the end of the month, so that I do not overspend.

U2. As a user, I would like to be able to add a monthly/yearly expense to deduct from my spending income, so I know how much I have to spend.

U3. As a user, I would like to be able to edit/delete an expense to represent my current budget, so that my budget is correct.

U4. As a user, I would like to be able to create a budget, so that I can complete my financial goals

U5. As a user, I would like to be able to edit/delete a budget, so that it reflects my ideal budget.

U6. As a user, I would like to be able to create and manage multiple budgets, so I can budget for multiple things over time.

## 4. Project Scope

This BudgetTracker will provide an easy way to track spending money to budget for a users personal goals

### 4.1. In Scope

Providing a simple pay to budget for future financial goals

_The functionality described above should be what your design is focused on. You do not need to include the design for any out of scope features or expansions._

### 4.2. Out of Scope

Providing financial advice or recommendations.

Connecting to a bank for financial information.



_The functionality here does not need to be accounted for in your design._

# 5. Proposed Architecture Overview

I will be setting up my classes based on the DAO Pattern. This will allow me to separate my back end from databases I 
use and will properly facilitate the functionality I want. My application will have general CRUD functionality and 
will use multiple dynamoDB tables for budgets, user information, and expenses. I will use Request and Result objects 
to represent this information, so I may receive and process that information.

# 6. API

## 6.1. Public Models

UserModel BudgetModel ExpenseModel

Get Monthly income endpoint: accepts get request a returns the corresponding UserModel 

Get Budget endpoint: accepts get request and return the corresponding BudgetModel 

Create Budget: accepts a post request to create a budget:

Create Income: accepts a post request to clarify monthly income in user table

Update Budget/Income: accepts a put request to update monthly income/budget 

delete Budget/Income: accepts a delete request that will delete monthly income/budget

Create Expense: accepts a post request to create an expense

Update Expense: accepts a put request to update an expense

Delete Expense: accepts a delete request to delete an expense

## 6.2. Get MonthlyIncome Endpoint
Describe the behavior of the first endpoint you will build into your service API.

(You should have a separate section for each of the endpoints you are expecting to build...)

- *Accepts GET requests to /:userId/*
- *Accepts userID and returns the corresponding UserModel.*
    - *If the given user ID is not found, will throw a UserNotFoundException.*

## 6.3 Get Budget Endpoint
- *Accepts GET requests to /:userId/budgets/:budgetId*
- *Accepts userID and a budgetId and returns the corresponding BudgetModel.*
    - *If the given user ID is not found, will throw a BudgetNotFoundException.*

## 6.3 Create Budget Endpoint 
- *Accepts POST requests to /:userId/budgets*
- *Accepts userID and creates a budgetId and a budget*
    - *If the given user ID is not found, will throw a UserNotFoundException.*

## 6.4 Create Income Endpoint
- *Accepts POST requests to /:userId/*
- *Accepts userID and updates income related to that user. Returns the corresponding UserModel.*
    - *If the given user ID is not found, will throw a UserNotFoundException.*

## 6.5 Update Income Endpoint
- *Accepts PUT requests to /:userId/*
- *Accepts userID and updates income.*
    - *If the given user ID is not found, will throw a UserNotFoundException.*

## 6.6 Update Budget Endpoint
- *Accepts Put Requests to /:userId/budgets/:budgetId*
- *Accepts userID and budgetId updates budget related to that user. Returns the corresponding BudgetModel.*
    - *If the given user ID is not found, will throw a UserNotFoundException.*
    - *If the given budget ID is not found, will throw a BudgetNotFoundException.*

## 6.7 Delete Budget Endpoint
- *Accepts DELETE Requests to /:userId/budgets/:budgetId*
- *Accepts userID and budgetId updates budget related to that user. Deletes the corresponding budget.*
    - *If the given user ID is not found, will throw a UserNotFoundException.*
    - *If the given budget ID is not found, will throw a BudgetNotFoundException.*

## 6.8 Create Expense Endpoint
- *Accepts POST requests to /:userId/budgets/:budgetId/*
- *Accepts userID and a budgetId then creates an expense*
    - *If the given user ID is not found, will throw a UserNotFoundException.*
    - *If the given budget ID is not found, will throw a BudgetNotFoundException.*

## 6.9 Update Expense Endpoint
- *Accepts Post Requests to /:userId/budgets/:budgetId/expenses/:expenseId*
- *Accepts userID and budgetId updates expense related to that budget. Returns the corresponding ExpenseModel.*
    - *If the given user ID is not found, will throw a UserNotFoundException.*
    - *If the given budget ID is not found, will throw a BudgetNotFoundException.*
    - *If the given expense ID is not found, will throw an ExpenseNotFoundException.*

## 6.91 Delete Expense Endpoint
- *Accepts DELETE Requests to /:userId/budgets/:budgetId/expenses/:expenseId*
- *Accepts userID and budgetId and deletes expense related to that budget.*
    - *If the given user ID is not found, will throw a UserNotFoundException.*
    - *If the given budget ID is not found, will throw a BudgetNotFoundException.*
    - *If the given expense ID is not found, will throw an ExpenseNotFoundException.*

# 7. Tables


### ***7.1 UserTable***

| Field         | Type              |
|---------------|-------------------|
| userId        | String (Hash Key) |
| budgetId      | String            |
| MonthlyIncome | String            |

### ***7.2 UserTableGSI***

| Field         | Type              |
|---------------|-------------------|
| userId        | String (Hash Key) |
| budgetId      | String (Sort Key) |
| MonthlyIncome | String            |


### ***7.3 BudgetTable***

| Field         | Type                |
|---------------|---------------------|
| budgetId      | String (Hash Key)   |
| budget        | String              | 


### ***7.4 ExpenseTable***

| Field    | Type                |
|----------|---------------------|
| budgetId | String (Hash Key)   |
| expenses | String              | 





# 8. Pages

_Include mock-ups of the web pages you expect to build. These can be as sophisticated as mockups/wireframes using drawing software, or as simple as hand-drawn pictures that represent the key customer-facing components of the pages. It should be clear what the interactions will be on the page, especially where customers enter and submit data. You may want to accompany the mockups with some description of behaviors of the page (e.g. “When customer submits the submit-dog-photo button, the customer is sent to the doggie detail page”)_