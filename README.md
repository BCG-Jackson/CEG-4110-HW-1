# CEG-4110-HW-1
Jackson Bush
9/16/2018
WSU CEG 4110

The purpose of this application is to complete homework assignment 1 for CEG 4110. The app uses two different activites representing part one and part two of the assignment. 

## Usage
### Part 1

The first part of the assignment is to create a single UI screen having one text field, and one button. A user can type into this text field and their typed text will be displayed in the field. The function of the button is to randomize the color of the text in the field. I have labled this button "CHANGE COLOR". When this button is pressed, a lable beneath the button beomes visible and displayes the random color both as rgb values and as a hex color value. 

![Imgur](https://i.imgur.com/SkqW1p1.png "Part 1") 
![Imgur](https://i.imgur.com/POmOe7l.png "Part 1")

This part of the application is the main activity. The activity can be changed by clicking the button labled "TOGGLE ACTIVITY".

### Part 2

The second part of the application is a drawing panel. Here, the user can draw on the screen and lines will be created where the user drags their finger. The user can move back to the first activity by activating the back button on their mobile device. Going back to the first activity will also clear their drawing. The user can then click the toggle activity button again to begin a new drawing. 

![Imgur]( https://i.imgur.com/SJLBH11.png "Part 2")

## Design
### Part 1

The functional elements of part one are the text field and the "CHANGE COLOR" button. All of the elements of part one are instantiated in the onCreate method of MainActivity.java. Here, the button is given an onClick event handler which does a few things:
* Creates a random int color which is bound by xFFFFFF or the max hex value.
* Changes the color of the text field text using the textInput.setTextColor() method.
* A assigns three variables r g and b to the approperate bytes of color.
* Creates a string of all the color information and changes the content of the lable colorInfo using the setText() method. 

The "TOGGLE ACTIVITY" button also has an onClick event which instantiates a new activity using `startActivity(new Intent(MainActivity.this, MainActivityDrawing.class));`


### Part 2

Once "TOGGLE ACTIVITY" button is pressed, intent is transfered from MainActivity.java to MainActivityDrawing.java and a new activity covers the screen. Since part two convers the entire screen and is not dependent on any part of of the first activity, it made sense to have it be a new activity rather than an extension of the first ativity. Also, because of the way activites work on android devices, hitting the back button in the second activity returns the user to the first activity. This functionality made the project easier becuase I did not need to code a "go back" button. 

The drawing panel works by using two classes, MainActivityDrawing, which extends activity, and MyView, with extends view. Much of this part of the project was derived from and similar to examples like [this](https://github.com/Miserlou/Android-SDK-Samples/blob/master/ApiDemos/src/com/example/android/apis/graphics/FingerPaint.java) one.


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
