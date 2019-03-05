First off for the GameWorld i decided to use ArrayList, i first started with Vector but i noticed its performance when it came to add and remove were bit slacking compare to the ArrayList.
-With the arraylist i was able to create "spaceObject" where i basically stored my objects when adding them to the GameWorld from the other classes.

getters and setters: i actually got to look back to my CSC 20 project - Coins, where i was first introduced to getters and setters, and it helped me to review them and use them in this assignment.

Also in GameWorld i got to use "InstanceOf", this one was a new one for me but was recommended to me by a friend. 
-What is essentially does is create a logical expression. What it truely helps for is when you have an abstract class like, "MoveableObject" for instance we don't know or at least the 
computer doesn't know what exactly is considered a moving object. Therefore we give it a meaning by comparing it to another class. So by saying MoveableObject instanceof Ship, the computer 
knows that a Ship belongs to MoveableObject.
-And youll notice in my assignment i used it with my arraylist: spaceObject as the reference variable. Basically i was asking the program to look and point into "MoveableObject"/the instance or object 
and returns true if it does point to it. 
-This allowed for easy communication between the Gameworld with the other classes.

Another big thing i had to really wrap my head to incorporate was the remove process. This assignment we dealt with a lot of remove cases.
-for this i once again used the instanceof. The concept behind it is, if the spaceObject points to the Ship (For example) then remove the ship from the GameWorld, however if it does not because
it does not already exist in the game world, it will simple break and move on. And to make sure i can delete both the Ship and Flying Saucer/Asteroid, i repeated the same step as with the ship
but pointed the spaceObject to the Flying Saucer/Asteroid to check.
-The thing to note for this, is that this will not work well or work at all once we start introducing "collision", because these are just pointing and checking if its true or false and not
neccessairly checking if they are within it boundaries, they will become obsolete later on. However in this assignement/situation i found it to be one of the best, after testing out many different
loops like a while loop but with no success.
-You will also notice in a lot of my remove lines, you will also find lot of crossed out println statements, they were basically my test to see and make sure they are going through parts of the codes
and not just skipping them over.

I also added in additional Switch method for the quit. I decided to keep the 'q' as a println statement asking the User if they want to quit, they should press 'o' as an Okay to confirm.
Basically i created another switch for the key 'o' that allows the user to confirm and quit the game.