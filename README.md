Image
# Maceta-REST

## Table of contents
* [Description](#description)
* [Installation](#installation)
* [Security](#installation)
* [JSON structure](#json)
* [License](#license)

## Description <a name="description"></a>
All the information is given in JSON format and the server has to receive all the data in JSON fromat too.

## Installation <a name="installation"></a>


## Security <a name="security"></a>
## JSON Structure <a name="json"></a>
Flowerpot structure with example:  
<p align="center"><img src="https://github.com/Rodaja/Maceta-REST/blob/master/doc/img/JSON_Flowerpot.png" height="400"/></p>
User structure with example adding flowerpots to it:  
<p align="center"><img src="https://github.com/Rodaja/Maceta-REST/blob/master/doc/img/JSON_User.png" height="500"/></p>  

## User Routes
### POST methods
**Save a user in the database**.  
http://url/api/users  
This method is used to register a new user in to the database, it has to receive a JSON with the following information:  
<p align="center"><img src="https://github.com/Rodaja/Maceta-REST/blob/master/doc/img/JSON_User_Type.png" height="400"/></p> 
It returns a JSON that has all the information provided.
### GET methods
**Get all the users saved in the database**.  
http://url/api/users  
This method is used to get all the users of the database, it doesn´t have to receive anything from the body and it returns a list with all the users found.
```
Example
```

### PUT methods
**Modify a user by its ID**.  
http://url/api/users/id  
This method is used to modify a user by its ID, it recives in the URL the user ID and if the ID exists it returns a JSON with the new user modified, if the ID doesn´t exist it doesn´t return anything only a BAD REQUEST. It needs a JSON with the new user in the body.

### DELETE methods
**Delete a user from the database by its ID**.  
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

## License <a name="license"></a>
