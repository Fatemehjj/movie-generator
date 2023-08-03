# movie-generator-with-microservices

📹 this is a movie generator app, which would help you to find your proper movie!

##What I used  

 java 17,
 maven as a build tool (3.8.1 v)
 spring boot as my framework (3.1.2 v)
 spring mvc
 spring data JPA

 ## Explain the  Architecture
💡 Every microservice will register into the Eureka server and Eureka server
 knows all the client applications running on each port and IP address.

💡i also added api gateway API gateway which sits between the client apps and the microservices
and registered it to Eureka server.

💡so the request will go from user to api gateway and then it will manage the user requests
and send them to a proper microservice.
finally we will return the data.

💡the user DB is seperated from movies DB

## Features   
1: get movie by release date🌟

2: get movie by name (you do not need to enter the full name, even with some alphabets it will work)🌟

3: get movie by length (in some cases where the entered length is not found in the DB we return all movies with higher length)🌟

4: get random movies order by number of movies which user will request🌟

5: get by category and imdb also order by number of movies which user will request(we return movies with greater than or equal to imdb scale request)🌟

6: get by imdb and order by number of movies which user will request(return movies with greater than or equal to imdb scale request)🌟

7: get by category🌟

8: save user review and rating for a particular movie🌟

9: get review/es and rating/s by entering a movie name(even if user enter a few alphabets it will work)🌟

10: get review/es  by entering a movie name🌟

11: get rating/s by entering a movie name🌟

12: get top reviews and ratings for a movie(eg: user entered "The Truman Show" and he wants to get top 3(or any other num) reviews gor that movie)🌟 

 
