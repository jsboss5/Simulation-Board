simulation
====

This project implements a cellular automata simulator.

Joshua Boss, Franklin Wu, Alex Chao

### Timeline 

Start Date: September 29th

Finish Date: October 20th

Hours Spent: 150 Hours total = around 5-75 hours each probably

### Primary Roles
Franklin - Backend
Josh - FrontEnd
Alex - Mostly Front end but also helped on Backend - test lead

### Resources Used

https://stackoverflow.com/questions/25409044/javafx-multiple-buttons-to-same-handler

### Running the Program

Main class: The main class is our Display class. Run Display to run our simulation.

Data files needed: You need everything that is in BoardConfig and Everything in Properties files. You also
<<<<<<< HEAD
need the images inside the resources folder if you want to add images to cell states. 
=======
need the images inside the resources folder if you want to add images to cell states.
>>>>>>> b4bd1a663411f2656aa65fb612acd32aba55d92a

Features implemented:

1. Play Button
2. Pause Button
3. Step Button
4. Load File button
5. Save File Button
6. Image adder
7. Multiple languages
8. Multiple windows
9. Speed up, slow down bar
10. Splash Screen with default properties files
11. User can click on states to set them



### Notes/Assumptions

Assumptions or Simplifications: the row and the height are equal

1. for analyasis - states versus cells - we should have used cells but were in too deep with states (strings)


2. The only files that can be read in are inside of properties files. 

3. For error handling, if they input a bad file, the game is stopped and we ~yell at them


Interesting data files:

Known Bugs:

1. As of right now, if you click the save file button, and exit out of the window, it still saves a file with the entered
information. I need to fix this but documenting for now.


2. When you exit out of LoadFile the program crashes... basically exiting out of anything where you choose
a file gives an error.

3. We are failing a couple of our tests - on the notaproperties file test, missing proeprties file test,

4. Graph updating doesnt work... it throws an error -
assumes files are in resources root


### Impressions

Overall we had a good time working on this project. It was definitely difficult and we all learned a lot through
the process. We spent a lot of time planning our code before we started, and a ton of time 
on zoom calls together. We all improved our design and utilized a lot of reflection and resource property files
to practice best design. We split up into roles fairly naturally, and did a good job at all pulling our own weight. 
That said, this was a difficult project for sure, and we spent tons of hours on this project. 
