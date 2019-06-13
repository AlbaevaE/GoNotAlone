URL - 
  http://localhost:8080/

GET: /user/getAll                                    -return all users
GET: /user/getById/{id}                              -return user by id

GET: /event/getAllEvent                              -return all events
GET: /event/getEventById/{id}                        -return event by id
GET: /event/getEventsByUser/{id}                     -return all user's event
GET: /event/getEventsByPlace/{id}                    -return all event by place
GET: /event/getEventByCategory/{eventId}/{category}  -return all event by category

GET: /place/getAllPlaces                             -return all places
GET: /place/getPlaceById/{id}                        -return place by id

GET: /sights/getAllSights                            -return all sights
GET: /sights/getSightsById/{id}                      -return sights by id


POST: /user/add                                      -create User

{
 
   "name": "Almira",
       
   "phoneNumber": "98759300",
   
   "email": "almira@gmail.com",
   "login": "almira",
   
   "password": "Abdysheva60"

}

POST: /event/addEvent                                   -create Event Application

{
	
 "name": "Aijamal",
    
 "userId": 1,
    
 "placeId": 1,
 
 "description": "asdf",
    
 "category": "TRAVEL"

}

POST: /place/addPlace                              -create Place
 {
    
    
   "place": "Osh",
    
   "map": null,
    
   "user": null

  }
 
POST: /sights/addSights                           -create Sights
{
       
       
  "name": "square",
       
  "place": {
           
  "id": 2,
            
  "place": "Bishkek",

  "map": null,
            
  "user": null
       
 }
    
}

DELETE:  /user/deleteById/{id}                   -delete User by id
DELETE:  /user/deleteAll                         -delete all Users

DELETE:  /sights/deleteSightsById/{id}           -delete Sights by id
DELETE:  /sights/deleteAllSights                 -delete all Sights

DELETE:  /place/deletePlaceById/{id}             -delete Place by id
DELETE:  /place/deleteAllPlaces                  -delete all Place

DELETE:  /event/deleteEvent/{id}                 -delete Event by id
DELETE:  /event/deleteAllEvent                   -delete all Event
 
PUT:     /event/click                            -respond to the event

{
	
   "userId": 1,
	
   "appId": 2

}

PUT:    /evet/confirm                           -confirm Event application

{
	
  "userId":1,
	
  "appId":1

}



