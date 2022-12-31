# Architecture Significant Requirements (ASR)

Here you can find our [utility tree](https://github.com/DarkressX/Common/blob/main/docs/SAD/Utility_tree_template.pdf)

# Architecture tactics and design decisions

Our project will follow the service based architecture.

## Security

We decided to focus on the quality attribute security, because we want to offer our users a secure communication platform. 
Visible in our [utility tree](https://github.com/DarkressX/Common/blob/main/docs/SAD/Utility_tree_template.pdf), the DDoS attack scenario is the one with the highest priority, but we want to focus as well on the man in the middle attack scenario. 
If we implement a rate limiting on our HTTP endpoint, we could mitigate the effect of a DDoS attack. The man in the middle attack can be prevented with an SSL/TLS encryption between server and client.

We already implemented the authentication and authorization of users in our project. 
Moreover, we decided to have an admin so that the user has limited access to our website.

## Availability

Availability is also important. If the website is not available, our users are no longer able to chat.
This would lead to less use of the platform, which will worsen the matching capability since the probability of a successful match is proportional to the amount of users. 
That misses the idea of the whole project.

## Usability

A big number of users is significant for the matchmaking. Because of this, the app should be user-friendly. This will be realized with an intuitive frontend design.

## Performance

