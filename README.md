# software-maintenanace-cw2

##Synopsis
This project is about creating a stand-alone map viewer application for the game Diamond Hunter using the **_JavaFX SceneBuilder_**. The project is itself a Java project with an integrated JavaFX application package and a TileEngine package to display the 2D map alone.
##Code
The executable main function is in the application package in src as Main.java. It is responsible for running the code that has been integrated with the GUI made using SceneBuilder. Compiling and running this Main.java should display a dialogue box with fucntionalities which then can be used to navigate around the application. It is also worth noting that, the game and map can be operated separately in their respective classes (DiamondHunter/Main/Game.java and DiamondHunter/TileEngine/Main.java respectively).
##Changing coordinates
The second chunk of this project is to be able to **change the positions of Boat and Axe** in the game. This can be done by clicking on Edit Map in the application and keying in the coordinates. Note that the coordinates must only be entered as whole numbers (no floating points) and must be separated by a **blank space** (no commas inbetween coordinates). This is also brought to the attention of the user via the ToolTip in the CSS if the cursor is hovered long enough over the corresponding text fields. Clicking on the Save and Play button will then allow the user to play the game with **_updated_** positions for Boat and Axe.
