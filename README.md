## Jets
---
My third weekend project for Skill Distillery, a coding boot camp

### Overview
---
This project to a small degree simulates a air field. The program starts with 5 preset 'Jets' located in the air field to play around with when you run the program. It does this by reading from a external file located on the file system, then storing it into a array list. The user can add or remove jets from their field by entering in the right displayed choice. They also have a number of other options such as calling for the information on each jet, see which is the fastest, or even save all the jets to a file for future use when the program is launched again.

### Technologies/Topics Used
---
The whole program is made of 6 classes;
* One for each type of jet (passenger, fighter, and cargo)
* The jet abstract super class
* The air field class which most of the processes and storage reside
* The application class which is in charge of always dealing with the user.
It is also made up of 3 interfaces;
* A Passenger jet interface
* A Fighter jet interface
* A Cargo jet interface
These interfaces are to help provide a additional 'blue print' for future jet classes if any are added.

The program first starts by calling the launch method which takes in all the planes from the local file and places them out into their proper object class before handing them over to the air field class. From there on the air field class is the only one that can access that information directly. Most of the methods in air field are simple for each loops separating the list of jets and comparing them to one another or for calling a method such as fly() that all the jet objects share.

Adding a jet also works very similarly to when the program first initializes the from the local file.  Using the menu a user can pick which type of plane they wish to add, the program then asks for the fields it needs to create the object itself. The save method also works similarly to the launch method, but instead of building the objects, it tears them down into their individual fields and then writes it back to a clean copy of the file. All so the user now has more planes at their disposal when the program is launched again in the future, giving it a constantly growing list for future users.

### Lessons Learned
---
This project was very difficult to get much further after you got the basic classes coded out. A big issue I had when creating this was just getting the program to read the file and separate out the planes into their proper object classes, I ended up just adding a char value at the beginning of the line of text to hold a value for actually sorting them out. I also did this for when I am saving the new planes to a file, which was another big road block for me. Basically sorting the jets apart by using a for each loop and using instanceof to compare to their classes and adding that char value in so the code doesn't crash on boot up.

Also just having to work with so many classes at once within one program became a bit overwhelming for a beginner like me at times, trying to remember where certain calls are and what they call next or what came before became a challenge towards the end. Needless to say the debugging tool on Eclipse came in handy over and over again to figure out why something wasn't reading right, or storing the right information, or for even simply figuring out why it prints one of my error messages when it should be waiting for user input.
