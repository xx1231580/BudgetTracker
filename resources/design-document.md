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

U1. As a user, I would like to be able to know how much money I have to spend at the end of the month

U2. As a user, I would like to be able to add a monthly/yearly expense to deduct from my spending income

U3. As a user, I would like to be able to edit/delete an expense to represent my current budget

U4. As a user, I would like to be able to create a budget

U5. As a user, I would like to be able to edit/delete a budget

U6. As a user, I would like to be able to create and manage multiple budgets

## 4. Project Scope

This BudgetTracker will provide an easy way to track spending money to budget for a users personal goals

### 4.1. In Scope

Providing a simple pay to budget for future financial goals

_The functionality described above should be what your design is focused on. You do not need to include the design for any out of scope features or expansions._

### 4.2. Out of Scope

Will not be providing financial advice or recommendations

_The functionality here does not need to be accounted for in your design._

# 5. Proposed Architecture Overview

_Describe broadly how you are proposing to solve for the requirements you described in Section 2. This may include class diagram(s) showing what components you are planning to build. You should argue why this architecture (organization of components) is reasonable. That is, why it represents a good data flow and a good separation of concerns. Where applicable, argue why this architecture satisfies the stated requirements._

# 6. API

## 6.1. Public Models

IncomeModel BudgetModel ExpenseModel

Get Monthly income endpoint: accepts get request a returns the corresponding IncomeModel

Get Budget endpoint: accepts get request and return the corresponding BudgetModel 

Create Budget: accepts a post request to create a budget:

Create Income: accepts a post request to clarify monthly income

Update Budget/Income: accepts a put request to update monthly income/budget 

delete Budget/Income: accepts a delete request that will delete monthly income/budget

Create Expense: accepts a post request to create an expense

Update Expense: accepts a put request to update an expense

Delete Expense: accepts a delete request to delete an expense

# 7. Tables
UserTable:
hashkey: userid
attribute: string BudgetId
attribute: int monthly income

GSI Table:
hashkey: userid
sort: string BudgetId
attribute: int monthly income

BudgetTable:
hashkey: BudgetId
attribute: Budget

ExpenseTable: 
hashkey: BudgetId
attribute: String array of expenses


# 8. Pages

_Include mock-ups of the web pages you expect to build. These can be as sophisticated as mockups/wireframes using drawing software, or as simple as hand-drawn pictures that represent the key customer-facing components of the pages. It should be clear what the interactions will be on the page, especially where customers enter and submit data. You may want to accompany the mockups with some description of behaviors of the page (e.g. “When customer submits the submit-dog-photo button, the customer is sent to the doggie detail page”)_