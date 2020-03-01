# Maceta-REST
## Description

## User Routes
### POST methods
#### Save a user in the database
http://url/api/users  
This method is used to register a new user in to the database, it has to receive a JSON with the following information:
  * email --> Obligatory
  * name --> Optional
  * firstSurname --> Optional
  * secondSurname --> Optional
  * password --> Obligatory
  * country --> Optional
### GET methods
#### Get all the users saved in the database
http://url/api/users  
This method is used to get all the users of the database.
### PUT methods
#### Modify a user by its ID
http://url/api/users/id  
This method is used to modify a user by its ID, it recives in the URL the user ID and if the ID exists it returns a JSON with the new user modified, if the ID doesn´t exist it does´nt return anything only a BAD REQUEST. It needs a JSON with the new user in the body.
### DELETE methods
#### Delete a user from the database by its ID
http://url/api/users/id  
This method is used to delete a user by its ID, it recives in the URL the user ID and returns a String saying "**Deleted**" if the user has been deleted or "**NOT Deleted**" in the opposite case.It doesn´t need any JSON in the body.
## Flowerpot Routes 
### POST methods
http://url/api/flowerpots
### GET methods
http://url/api/flowerpots
### PUT methods
http://url/api/flowerpots/macAddress
### DELETE methods
http://url/api/flowerpots/macAddress  
This method is used to delete a flowerpot by its MAC address.
