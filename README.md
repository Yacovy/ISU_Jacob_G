# ISU_Jacob_G
	Hi helo
   
   
   
   
Welcome to Disc Golf on Java, this will be a quick breakdown of key variables in this game
First there is menuState, which is the main menu controller for all parts of the game. 1 represent the core gameplay. 2 represents the disc creation section, 3 represents the intro sequence and 4 exits the program. To return to the user selecting the menuState, a placeholder value is used at the end of every loop.
To create the map of the game I used an array called course that had a fixed size of 50 by 30. By then printing it out in rows of 30, it allowed the illusion of a 2d map. The variable location then allowed me to track the players position within the map. Position is simply an integer that gets modified by specific values to move the player in a certain direction(Ex: subtracting by 50 will move the player up one row, adding one will move the player to the right). Also obstacles are defined at this stage with the specific course selection following code that modifies course to have out of bounds “/”, trees “t” and open space ”o”.

fadeTurnCounter is used in a for loop that counts to two and is used to determine if it is the first or second half of the throw so that fade or turn can be properly applied. The integer speedCalc was used to move the disc until it got to its speed number twice.

The discs moved twice the distance of their speed in the direction thrown. Fade and turn were managed by making it so that a disc would turn one direction then fade the other direction. Fade and turn were controlled through creating a bunch of factors, of which the current counter of speed calc only needed to be divisible by one to turn or fade. However if the discs turn is higher each of the divisors are subtracted so that it is more likely that the disc will turn of fade. Discs with a zero in a catergory will not turn or fade.

The two integers locationBeforeCheck and locationAfterCheck were used together to create a detection system for out of bounds throws. If the throw was successful all the way, locationAfterCheck was used at the end. If at any point it went OB or hit a tree locationBefore was used to bring the disc to a legal position to keep course integrity.
The variable strokes was used to keep count of strokes and penalties such as OB.

The menu subsystem was accessed by menuState 2. It then initialized creationMenu a variable that controls the creation sub menu. Disc creation and usage was created by using 4 arraylists discNames (string), discFade (int), discTurn (int), discSpeed (int). I organized spefic discs by their location within discNames. For example, if a user create 3 discs A, B and C and then accessed B the index of B would allow me to find its speed, fade and turn. The removal of a disc removed its variables from all 4 lists. creationMenu = 1 meant creation of a disc, creationMenu = 2 meant deletion and 3 exited the submenu

The intro was just printed out and then menuState was set to another nnumber.
