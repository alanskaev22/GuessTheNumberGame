_Simple game "Guess the number" that works by specifying lower_ 
_and upper boundaries of input range (in config.properties), and user_ 
_providing input via console at runtime. You can customize how many_
_guesses you can take via properties file._


* Specify minnimum number, maximum number and guess count in config.properties.
* Run Main method inside console module
* Enter number using console
* Get feedback regarding how many tries you have and how close you are 
    to the actual number
* Replay the game after you exhaust specified number of guesses by sending Y/N

*****

# High level overview
* **Maven**
* **Spring Boot**
* **Spring dependency injection**
* **Lombok**
* **Slf4j & logback**
*****

Run WebMain class inside Web module to create a server on port 8080

For English Version:
http://localhost:8080/?lang=en
For Spanish Version:
http://localhost:8080/?lang=es
