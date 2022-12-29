# 1. Introduction
## 1.1 Purpose

This document provides a comprehensive architectural overview of the system, using a number of different architectural views to depict different aspects of the system. It is intended to capture and convey the significant architectural decisions which have been made on the system.

## 1.2 Scope

## 1.3 Definitions, Acronyms, Abbreviations

## 1.4 References

## 1.5 Overview

We decided that a Services-Based-Architecture suits best for our project.
The focus of Commons Architecture is on security. Because the sent messages should only be read by the sender and recipient.
In the further course of the document, you can find the explanations to this decisions.

# 2. Architectural Representation

# 3. Architectural Goals and Constraints

Common is a communication platform that allows a secure exchange between two users. Therefore, the focus of this project is security. The sent messages can only be read by the sender and recipient. The interception of messages should be avoided at all costs.
A backup of data is not intended. That means if the chat is closed, the data isn't saved in the database. Only personal data that is used to create an account is saved.
Availability is also important. If the website is not available, the user can no longer chat. That leads to less use, less users and to worse matches. That misses the idea of the whole project.
The team of common splits into two workgroups. One is working on the frontend and the other one on the backend.
As a framework we have chosen to use Spring. Spring allows for a streamlined development process for backends as well as frontends.

# 4. Use-Case View

![Use Case Diagram](/docs/use_cases/images/SoftwareRequirementsSpecification.png)

Use-Case Realizations:

[CreateAccount](/docs/use_cases/UseCaseRealizationSpecifiaction/CreateAccount.md)

[StartChat](/docs/use_cases/UseCaseRealizationSpecifiaction/StartChat.md)

# 5. Logical View

## 5.1 Overview

## 5.2 Architecturally Significant Design Packages

# 6. Process View

