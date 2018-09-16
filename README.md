# CEG-4110-HW-1
Jackson Bush
9/16/2018
WSU CEG 4110

The purpose of this application is to complete homework assignment 1 for CEG 4110. The app uses two different activities representing part one and part two of the assignment. 

## Usage
### Part 1

The first part of the assignment is to create a single UI screen having one text field, and one button. A user can type into this text field and their typed text will be displayed in the field. The function of the button is to randomize the color of the text in the field. I have labeled this button "CHANGE COLOR". When this button is pressed, a label beneath the button becomes visible and displays the random color both as rgb values and as a hex color value. 

![Imgur](https://i.imgur.com/SkqW1p1.png "Part 1") 
![Imgur](https://i.imgur.com/POmOe7l.png "Part 1")

This part of the application is the main activity. The activity can be changed by clicking the button labeled "TOGGLE ACTIVITY".

### Part 2

The second part of the application is a drawing panel. Here, the user can draw on the screen and lines will be created where the user drags their finger. The user can move back to the first activity by activating the back button on their mobile device. Going back to the first activity will also clear their drawing. The user can then click the toggle activity button again to begin a new drawing. 

![Imgur]( https://i.imgur.com/SJLBH11.png "Part 2")

## Design
### Part 1

The functional elements of part one are the text field and the "CHANGE COLOR" button. All of the elements of part one are instantiated in the onCreate method of MainActivity.java. Here, the button is given an onClick event handler which does a few things:
* Creates a random int color which is bound by xFFFFFF or the max hex value.
* Changes the color of the text field text using the textInput.setTextColor() method.
* A assigns three variables r g and b to the appropriate bytes of color.
* Creates a string of all the color information and changes the content of the label colorInfo using the setText() method. 

The "TOGGLE ACTIVITY" button also has an onClick event which instantiates a new activity using `startActivity(new Intent(MainActivity.this, MainActivityDrawing.class));`


### Part 2

Once "TOGGLE ACTIVITY" button is pressed, intent is transferred from MainActivity.java to MainActivityDrawing.java and a new activity covers the screen. Since part two convers the entire screen and is not dependent on any part of the first activity, it made sense to have it be a new activity rather than an extension of the first activity. Also, because of the way activities work on android devices, hitting the hardware back button on the phone in the second activity returns the user to the first activity. This functionality made the project easier because I did not need to code a "go back" button. 

The drawing panel works by using two classes, MainActivityDrawing, which extends activity, and the child class MyView, with extends view. Much of this part of the project was derived from and similar to examples like [this](https://github.com/Miserlou/Android-SDK-Samples/blob/master/ApiDemos/src/com/example/android/apis/graphics/FingerPaint.java) one. The way it works is by creating a MyView object which is instantiated with appropriate values in the onCreate method of the MainActivityDrawing class. This object is passed to the setContentView() method which is what causes it to cover the entire screen. The onDraw(), touch_start(), touch_move(), touch_up(), and onTouchEvent() methods all deal with the concept of drawing lines to the canvas. 
* onDraw() - (Overridden) This method deals with drawing on the canvas as a bitmap using the other functions.
* touch_start() - This method deals with the original position of any finger drag across the screen.
* touch_move() - This method deals with the exact location that the user is touching on the screen and changes class variables mX and mY to keep track of lines being made.
* touch_up() - This method draws individual lines on the canvas. The way this class works is that the lines draw on the canvas are a combination straight lines connected end to end to give the impression of an organic flowing line.
* onTouchEvent() - This method handles the specific movement of the lines on the canvas and invalidates on each event so that the canvas updates in real time.


### Installation 

To install the application, copy app-debug.apk from the install folder onto your mobile device and install.  
There are no external libraries and resource files used in this project. 

## References 
These references were used to make this application:
* https://www.instructables.com/id/How-To-Create-An-Android-App-With-Android-Studio/
* https://www.youtube.com/watch?v=V0AETAjxqLI
* https://www.c-sharpcorner.com/article/how-to-be-working-with-multiple-activities-and-navigate-the-activities-in-androi/
* https://github.com/Miserlou/Android-SDK-Samples/blob/master/ApiDemos/src/com/example/android/apis/graphics/FingerPaint.java
* https://www.youtube.com/watch?v=6RtF_mbHcEc
* https://androidride.com/what-is-setcontentview-in-android/
