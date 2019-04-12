# Overview
This was my first project in a Java course. The requirements asked for a one-dimensional array for a BattleShip game, but that didn't sit well with me because it's not technically "real" BattleShip. In light of this, I opted for a matrix. **This exercise was completed before I learned about abstract classes, interfaces, and polymorphism. These newfound skills are likely to influence how I would re-work this (when I find the time to do so).**

# Requirements 
* An IDE capable of running Java (e.g.,Eclipse or Intellij).
  
* House all of the code in the same package. I happened to use a package called battle_ship which I've commented out at the top of each file. Feel free to use that name and uncomment the package declaration.

# Unique Quirks and Efficient? Approaches
It's been awhile since I've looked at this, but I have some decent commentary on how this is supposed to behave/run. My plan is to come back later and do a more thorough code-cleanup of it. In it's current state, it's playable.

* I try to use the most efficient runttime complexities and space complexities where possible. I'm generous with leveraging data structures and caching previously calculated/visited values to accomplish this.
   
* I use new String() syntax to work around the JVM's automatic [String interning](https://www.geeksforgeeks.org/interning-of-string/). I previously had no knowledge of this and learned it during the duration of the project. More details 

# Most Challenging Aspects
* See Matrix.java, this was the most challenging area for me. I do things like randomize placement of ship segments onto the board and cache what coordinates have already been "randomized", so we don't "re-reandomize" them (feel free to test the randomizer's runtime complexity, it's located in HelperFunctions.java in the "specialRandom" method).
  
* Another challenge was making Strings like "X" and "O" have their own unique occurrences. I worked around this via bypassing JVM automatic interning.

* Another challenge I faced was that I saw duplicated code for methods responsible for branching out in all cardinal directions. I tried to address this, but I couldn't find a way to do it with the time constraints I had for this project. **I COULD ACCOMPLISH THIS IN JavaScript, BECAUSE OF IT's FUNCTIONAL PROGRAMMING ASPECTS.** I'm not entirely sure if this is something I want to abstract away, since it might be harder to test each piece, and it might obfuscate the intent to code readers.


## To Do 
* Code-cleanup
* Move a hefty portion of logic out of Battleship.java into Game.java
* Convert Tests.java into JUnit testing.
* More built-in IDE documentation of methods and classes (cmd + alt + j)!
* More test coverage!
* See if this approach still makes sense and isn't overly complex.
* **Polish the user's interaction. Currently the way they pick coordinates on the matrix is not set up in an intuitive way (this will become clear when you play with it)**

### Etc
* Please reach out to me to give feedback or ways I can improve!