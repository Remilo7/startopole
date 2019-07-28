# startopole
Spring MVC webapp of fencing club, presenting details of the club, helping admins to manage website and introducing many features for coaches and members of the club.

## Features
 - Bootstrap based front-end
 - Navbar with affix
 - Presenting sections
    - News
    - Short history of the club
    - Trainings details
    - Coaches
    - Members
    - Image gallery
    - Contact
 - Articles page
 - Contact form
 - Login and registration system
 - Connection to the MySQL database
 - Administrator panel 
    - Articles management
      - Adding articles with photos
      - Editing articles
      - Deleting articles
    - Users management
      - Activating accounts
      - Deactivating accounts
    - Image galleries management
      - Adding new galleries 
      - Editing galleries
      - Deleting galleries
    - Info-sections management
      - Club history section
      - Trainings section
      - Coaches section
      - Members section
      - Contact section
    - Calendar
      - Events adding
      - Events edition 
      - Events removing
    - List fencers
      - Showing details of fencer
      - Sending messages
        - Sending messages of two categories to fencers
        - Deleting sent messages
  - Coach panel
    - Same calendar functionalities as in admin panel
    - Same funcionalities connected to listing fencers
  - User panel
    - Displaying details of user(fencer)
    - Calendar with events responding to the age category of fencer
    - Displaying messages from coaches and admins divided into two categorries
      
## Running the application locally

You need to have installed Java and Maven. 
Enter the directory where you downloaded the code and run:
```
mvn package
```
And then 
```
java -jar target/dependency/webapp-runner.jar target/*.war
```
After few seconds, the web application is available on http://localhost:8080/

You can also check it on https://startopole.herokuapp.com

