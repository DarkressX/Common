# Use-Case-Realization Specification: Start Chat

## 1. Introduction
### 1.1 Purpose
Chatting with another person is the primary objective of our application.

### 1.2 Scope
User have to have the ability to chat. 

### 1.3 Definitions, Acronyms, Abbreviations
| Abbreviation | Explanation                         |
|--------------|-------------------------------------|
| API          | Application programming interface   |

### 1.4 References
*tbd*

### 1.5 Overview
This Use-Case-Realization Specification will contain a sequence diagram, explaining the internal structure and flow during the start of a chat.

## 2. Flow of Events
Sequence Diagram:

![StartChatSequenceDiagram](/docs/sequence_diagrams/StartChat.png)

To start a chat, there have to be a number of preconditions to be met.
* The user has to have an account
* The user has to be logged in
* The user has to have chosen a topic
* The user has to have chosen a name(not to be confused with the account name)
* There has to be a successful match with another user

Have those requirements been met, the user can start to chat. Through the front end, a message can be typed in.
The message will be relayed to the backend via the REST-ful API.
Here it will be relayed to the chat partner which will then receive it via the front end.

## 3. Derived Requirements

Currently, the front end has to pull for new messages.
Once the website will be visited by many active users at once, this will have a significant impact on the backend.
One way to get around this, would be by exposing another API in the front end which will allow back calls from the backend.