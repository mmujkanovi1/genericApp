# genericApp

BarbersShop app without real implementation, just with
* entities,
* Relations between them,
* JWT token authentication,
* RestException handling
* CRUD for every entity

  
The main purpose of this application is that you can easily integrate it and use it for your application because
everything in this application has been done in a generic way without repetitive boilerplate code for each controller and service:
* GenericController, which has an instance of the GenericService interface. GenericServiceImpl is the class that contains the CRUD implementation.
* Other controllers extend ControllerGeneric, and with that, we can send our call to them and execute CRUD operations for each entity.

ERD diagram: 

