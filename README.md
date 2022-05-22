# University
REST API application for creation a new student in the database,
search all students in the database and delete the student by id.
 
## How to build
1) clone this repository
2) create schema in database MySQL by script from db.sql file
3) change such values as driver.class.name, db.url, db.user, db.password, server.port 
in application.properties file to match your database and port
4) run command mvn package (you create jar file application)
5) run command java -jar target/studenttask-0.0.1-SNAPSHOT.jar (you run application)

## How to work


You should use HTTP-client (Postman) for work and use port which your have written in application.properties

1) to create a new student you should do http://localhost:8081/api/v1/students (POST)
and to write your data as body in JSON format
   ![create_student_2](https://user-images.githubusercontent.com/61760081/169706194-0a475bd8-8608-4361-b2a6-509c319e61b9.jpg)
2) to find all students from DB you should do http://localhost:8081/api/v1/students (GET)
   ![get_all_students_2](https://user-images.githubusercontent.com/61760081/169705067-3115caaf-7a5d-4787-9aa3-05be81f032aa.jpg)
3) to delete a student by id you should do http://localhost:8081/api/v1/students/{id} (DELETE)

   If such student's id is in DB:
   ![deleted_2](https://user-images.githubusercontent.com/61760081/169706029-6c0d9d52-a624-4228-8bcc-ce5f341aa5e0.jpg)
   If such student's id isn't in DB:
   ![id_not_found_2](https://user-images.githubusercontent.com/61760081/169706086-45578d37-2141-413b-95f1-ccd43562dd45.jpg)

