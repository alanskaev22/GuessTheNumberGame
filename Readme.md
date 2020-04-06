# Guess The Number Game

This game can be played in **Console** version, as well as **Web** version.
*****
_Simple game "Guess the number" that works by specifying lower_ 
_and upper boundaries of input range (in game.properties, inside core module), and user_ 
_providing a guess that has to be between the numbers specified in properties file._
_Number of guesses can be customized via game.properties file inside core module._

_Default values are set to: Range -> 0 to 100. Number of guesses -> 5._
*****

## How to run

To run **Console version** of the game, run Main class inside Console module.
To run **Web version** of the game, run WebMain class inside Web module.
Web version of the game is available in two languages, English & Spanish which
was achieved by internationalization.

English version of the game will be created on port 8080:

`http://localhost:8080/?lang=en`

Spanish Version of the game:

`http://localhost:8080/?lang=es`
*****

## High level overview
* **Java 11**
* **Multi-module Maven project**
* **Spring Boot**
* **Thymeleaf**
* **Dependency Injection**
* **Lombok**
* **Slf4j & logback**

Lombok must be installed from marketplace
*****



