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

![ComponentSequenceDiagram](/docs/component_diagrams/ComponentSequenceDiagram.png)

As you can see from our diagram, we have four processes here. The authentication and the chat thread use Session Management. To start a session, matchmaking also uses the Session Management. Matchmaking is the logic to connect users together.

# 7. Deployment View

# 8. Implementation View

## 8.1 Overview

![ComponentDiagram](/docs/component_diagrams/ComponentDiagram.png)

## 8.2 Layers

# 9. Data View

Only personal data is saved in our database. Personal data means the data to create an account for example email address and password.  
Data that is shared in the chat is lost after leaving.

# 10. Size and Performance

# 11. Quality

![SecurityTacticsTree](/docs/SAD/SecurityTacticsTree.png)

A DDoS attack could theoretically disrupt our service by flooding our servers with requests they cannot handle. To avoid this, we first have to detect them. By the very nature of a DDoS attack, they are easily identified since much more requests than usual are coming into the server. Due to the fact that it is a distributed attack, it would be useless to simply block the IP address of the attacker. Therefore we decided to enable rate limiting in the case of such an attack. This allows us to still provide a limited version of our service in the event of an attack.
To avoid third parties and malicious actors to read chat data and information, we will use a TLS encryption between the server and client.
Through authentication and authorization we ensure that only verified users have access to our service. This not only helps with the issues stated above, but also helps keeping our users safe.
