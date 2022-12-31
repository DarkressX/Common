# Use-Case-Realization Specification: Create Account

## 1. Introduction
### 1.1 Purpose
Account will allow us to suggest similar topics to the user, which they have already chosen in the past.

### 1.2 Scope
To be able to use accounts, the user has to have the ability to create one.

### 1.3 Definitions, Acronyms, Abbreviations
| Abbreviation | Explanation                       |
|--------------|-----------------------------------|
| API          | Application programming interface |
| HTTP         | Hypertext transfer protocol       |
| JSON         | JavaScript Object Notation        |

### 1.4 References
*tbd*

### 1.5 Overview
This Use-Case-Realization Specification will contain a sequence diagram, explaining the internal structure and flow during a user account creation.

## 2. Flow of Events
Sequence Diagram:

![CreateAccountSequenceDiagram](/docs/sequence_diagrams/CreateAccount.png)

First the Client will connect to our Website. Here the front end will present the user the choice to create an account.
A user account is mandatory to use the site. Should the user choose to create an account, he will be asked to enter a username and password.
After he entered his data and clicked "create", the frontend will make a HTTP POST request to the backend with the entered data in JSON format.
The backend will then enter the data into a database for persistent storage.

## 3. Derived Requirements

Should we plan to require an email address during the account creation, there has to be some kind of validation for this.
Possible methods are sending a confirmation email with a link which the user has to click.