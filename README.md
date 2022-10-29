# Overview


This is my attempt at simulating a producer-consumer model using Kotlin. 
The program is heavily inspired by my current employment in which I operate a CNC machine in a production plant that creates custom cabinets for garages. 
The program first gets input from the user such as color and quantity. It then creates "Boards" inside the Factory, depending on the user input, and adds the boards to an order. Once the order is produced, the order details and the boards are passed to the fulfillment stage of the Factory. Once fulfilled, the Order is shipped to the Dealer who receives and assembles the order for the customer. 
The end result of the program will utilize shared data between classes (queues) and threads to increase speed. The purpose of the program was primarily to explore Kotlin and its syntax (classes, loops, immutable variables, etc.) compared to other languages.


[Software Demo Video](https://youtu.be/v28goyYDSzU)

# Development Environment


- IntelliJ IDE
- Kotlin


# Useful Websites

* [Kotlin Docs](https://kotlinlang.org/docs/home.html)
* [Programiz](https://www.programiz.com/kotlin-programming/for-loop)
* [W3Schools](https://www.w3schools.com/kotlin/index.php)

# Future Work

* In its current state, it only mimics the passing of data over a queue. In the future it will actually utilize threads and queues
* I need to finish the Dealer class and I need to restructure the classes so that the correct data type will be returned so that it can be passed from Factory to Dealer.
