# 1. Introduction
## 1.1 Purpose
This Software Requirements Specification (SRS) describes functional and non-functional requirements for the application "Common". It includes an overview about this project and its vision, detailed information about the planned features and boundary conditions of the development process. It also describes the correctness, uniqueness, and completeness of our project.

## 1.2 Scope
The project is going to be realized as a Web Application (Web-App).

Actors of the Website are the Users.

Planned Subsystems are:
  -	User interface:  
    The user interface is a website with chat room. 
  -	Account System:  
    To be able to use the Website you must creat an account. After you creat a account you are able log in and log out. 
  -	Block a User:  
    During a Session a User can block and unblock an other User. 
  -	Connecting People:  
    After two User choose the same topic in the web application, they get connected and start to chat together. User can also quit a chat. 
  -	Storing Data:  
    The Data will be stored in a Database System. 
  - Topic
    If a topic is in the same category of an other topic for example banane and apple are both fruts, then they also will get connected.
    There will also be same recommendations for the Users if they don't know what kind of topic they schoud choose. 
    

## 1.3 Definitions
| Abbreviation | Explanation                         |
|--------------|-------------------------------------|
| SRS          | Software Requirements Specification |
| UC           | Use Case                            |
| Web-App      | Web-Application                     |
| UCD          | Use Case Diagram                    |
| tbd          | to be determined                    |
| FAQ          | Frequently asked questions          |
| API          | Application programming interface   |

## 1.4 References
| Title                                         | Date        | Publishing organization  |
|-----------------------------------------------|-------------|--------------------------|
| [Common Blog](https://blog.common-chat.de/)   | 13.10.2022	 | Common Team              |
| [GitHub](https://github.com/DarkressX/Common) | 13.10.2022  | Common Team              |

## 1.5 Overview
The following chapter provides an overview of this project with vision and Overall Use Case Diagram (UCD). The third chapter (Requirements Specification) delivers more details about the specific requirements in terms of functionality, usability, and design parameters. Finally, there is a chapter with supporting information.


# 2. Overall Description
## 2.1 Vision

The corona pandemic caused reduced personal contact with our fellow human beings. That is why we have set ourselves the goal of reuniting people in times of isolation. 

Common enables the exchange of “common” topics through a chatportal. This will be set up in a web application. The user chooses their preferred topic of conversation using an input option that allows them to define their topic of interest. Users with the same interests are matched by a random system and can exchange via a chat.

### 2.2 Use Case Diagram

![Use Case Diagram](/docs/use_cases/images/SoftwareRequirementsSpecification.png)

### 2.3 Technology Stack

The technology we use is:
Backend:
* SpringFramework

Frontend:
* tbd

IDE:
* IntelliJ

Project Management:
* Jira
* GitHub
* Discord

Deployment:
* Java

Testing:
* tbd


# 3. Specific Requirements
## 3.1 Functionality

This section will explain the different use cases, you could see in the Use Case Diagram, and their functionality

* 3.1.1 Create Account
* 3.1.2 Choose username / Choose topic text
* 3.1.3 Chat
* 3.1.4 Quit chat/disconnect
* 3.1.5 Block another user  

3.1.1 [Create Account](/docs/use_cases/CreateAccount.md)

This will be the beginning for every interaction on our platform.
To initiate a chat the user first has to create an account.

3.1.2 [Choose username / Choose topic text](/docs/use_cases/ChooseUsernameAndTopic.md)

The user will be able to choose a username which will be visible to the chat partner, once a successful match has been made.
Additionally, a topic of interest has to be entered. This will be used as a basis to make a match with another person.

3.1.3 [Chat](/docs/use_cases/Chat.md)

This will be the main activity and will be automatically visible to the user, once a successful match has been made.
Here the user can chat with the matched partner.

3.1.4 [Quit chat / disconnect](/docs/use_cases/QuitChatOrDisconnect.md)

To provide an option to leave the session, the user can click a button and the session will be terminated.
Once the session has been terminated, the users will both respectively be dropped back to the "Choose topic" window described in 3.1.1.

3.1.5 [Block user](/docs/use_cases/BlockAnotherUser.md)

If one of the opposing partners is going against our user guidelines, the user has the option to report the user.
Should this happen, the IP address of the opposing partner and the IP address of the user will be logged, and ensured that a match between those partners can no longer happen.
The session will be terminated.

## 3.2 Usability

Due to the simplicity and design decisions made, our Web Service will be practically self-explanatory.

3.2.1 User friendliness

The Ui has a very simple design. The thought is that the user feels a sense of familiarity with other known webservices.
This will spare the user the hassle of trying to find simple functions since it will be intuitive.

## 3.3 Reliability

3.3.1 Availability

Load balancing and redundancy can be achieved using services like traefik, although this is not mandatory for this project.

## 3.4 Performance

3.4.1 Capacity

The System should be able to manage thousands of requests. Perhaps even more, if we can achieve to optimise the database connection.

3.4.2 Storage

Storage requirements are very small since no data will be kept long term except for reported IP addresses.

## 3.5 Supportability

3.5.1 Coding standards

We will be using modern coding standards. This will ensure that the team and future developers have an easier time understanding the code and providing future functionality.

3.5.2 Testing

Unit tests will be written to ensure system stability.

## 3.6 Design constraints

Back-End and Front-End will be kept separately. The Back-End will provide a RESTful API which the Front-End can use to communicate with the Back-End.
The Back-End will provide data using the JSON format. The RESTful API will not be exposed to the public internet, but will rather be kept in an internal network. This will provide an additional security layer against attackers.

## 3.7 On-line User Documentation and Help System Requirements

The usage of the app should be as intuitive as possible so it won't need any further documentation. If the user needs some help we will implement a "Help"-Button in the App which includes a FAQ and a formular to contact the developement team.

## 3.8 Interfaces

3.8.1 User Interfaces

The User interfaces we will implement:
* Dashboard - Adds the possibility to set a name and choose a topic the user wants to talk about.
* Chat Page - Shows information about the session and a chat window.
* Settings - Shows the settings

3.8.2 Software Interfaces

The application will be available as a website with primary focus on desktop users.

3.8.3 Communication Interfaces

The users can communicate with the webpage using the http/https protocol.

## 3.9 Licensing Requirements

tbd

## 3.10 Legal, Copyright, and Other Notices

The logo is licensed to the Common Team and is only allowed to use for the application. We do not take responsibility for any incorrect data or errors in the application.

## 3.11 Applicable Standards

The development will follow the common clean code standards and naming conventions.

## 4. Supporting Information

For any further information you can contact the Common Team via Discord Common Blog.
The Team Members are:
* Leon Schoch
* Erika Frank
* Lea Schablack
* Emina Yilmaz
* Christian Misch
