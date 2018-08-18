# EndToEndSpringJpa

Technologies:
1. Spring JPA
2. RestFul
3. JSP, HTML, CSS
4. Angular

Project: locationweb

*Main Layers:
1. Data Access layer
  -to extend functionlality from JPARepository for CRUD operation
  -DAO interface and DOA implemenation
2. service layer
  -to apply business logic
  -service interface and service implemenation
3. Controller layer
  -for UI view and handling requests
  
*other layers/classes:
4. Model class
  -to create entity(POJO)
5. Utility class
  -to perform special operation across layers
  -In this example, i)sending email from the application. ii)Use JFree Chart Api in our application in utility class to generate reports.
6. Integration Layer:
  -To perform REST CRUD calls
