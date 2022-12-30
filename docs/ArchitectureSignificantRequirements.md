# Architecture Significant Requirements (ASR)

Here you can find our [utility tree](https://github.com/DarkressX/Common/blob/main/docs/SAD/Utility_tree_template.pdf)

# Architecture tactics and design decisions

Our project will follow the service based architecture.

## Security 
We decide to focus on the quality attribute security, because we want to offer the user a secure communication platform. 
As you see, is the Ddos scenario the one with the highest priority, but we want to focus as well on the man in the middle scenario. 
If there is a limit of requests, we could avoid Ddos attacks. The man in the middle attack should be preventable with a ssl encryption between server and client.

We already implemented the authentication and authorization of users in our project. 
Moreover, we decided to have an admin so that the user has limited access to our website.

## Availability 
Availability is also important. If the website is not available, the user can no longer chat. That leads to less use, less users and to worse matches. 
That misses the idea of the whole project.

## Usability
A big number of users is significant for the matchmaking. Because of this, the app should be userfriendly. This will be realized with an intuitive frontend design.

## Performance


