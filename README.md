# Maceta-REST
## Description

## User Routes
### POST methods
* http://url/api/users
This method is used to register a new user in to the database, it has to receive a JSON with the following information:
  * email --> Obligatory
  * name --> Optional
  * firstSurname --> Optional
  * secondSurname --> Optional
  * password --> Obligatory
  * country --> Optional
### GET methods
* http://url/api/users
This method is used to get all the users of the database.
### PUT methods
* http://url/api/users/id
### DELETE methods
* http://url/api/users/id
This method is used to delete a user by its ID.
### Routes Flowerpot
