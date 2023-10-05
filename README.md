# movie-generator-with-microservices
it doesn't support all requirements for microservices

📹 this is a movie generator app, which would help you find your proper movie!

## What I used 🍃 

 java 17
 
 maven as a build tool (3.8.1 v)
 
 spring boot as my framework (3.1.2 v)
 
  MVC design pattern
 
 spring data JPA

 MySQL as my DB

 ## Explain the  Architecture 🍃 
💡 Every microservice will be registered to Eureka server and Eureka server
 will know all the client applications running on each port and IP address.

💡i also added API gateway which sits between the client and the microservices.
 I also registered it to Eureka server.

💡so the request will go from user to api gateway, and then it will manage the user requests
and send them to a proper microservice.
finally we will return the data.

💡the user DB is separated from movies DB

## Features 🍃 

1: get movies by release date🌟

2: get movies by name (you do not need to enter the full name, even with some alphabets it will work)🌟

3: get movies by length (in some cases where the entered length is not in the DB we return all movies with higher length)🌟

4: get random movies ordered by number of movies which user will request🌟

5: get movies by category and imdb also ordered by number of movies which user will request(if we had movies with same imdb and also the number of movies were equal to user request,
we return the movies. if we didn't have any movie which could fit with the imdb we return movies with higher imdb in ascending order. if DB had movies which matched with imdb
but the number of movies weren't equal to user request, first we return movies with similar imdb, then we add movies with higher imdb with ascending order)🌟

6: get by imdb and ordered by number of movies which user will request(logic is just like option 5)🌟

7: get movies by category🌟

8: save user review and rating for a particular movie🌟

9: get review/es and rating/s by entering a movie name(even if user enter a few alphabets it will work)🌟

10: get review/es by entering a movie name🌟

11: get rating/s by entering a movie name🌟

12: get top reviews and ratings for a movie(eg: user entered "The Truman Show" and he wants to get top 3(or any other num) reviews for that movie)🌟

13: get all movies🌟

## upcoming features

🖋 I will add spring security and docker


