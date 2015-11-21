# Wish90

Iteration 4: 

Steps To Configure Project:

1) This project needs JDK 1.7 and 1.8. Install JDK 1.7 and JDK 1.8 and onfigure system environment variables. <br>
JAVA_HOME=[JDK installation Directory 1.7]<br>
JAVA7_HOME=[JDK installation Directory 1.7]<br>
JAVA8_HOME=[JDK installation Directory 1.8]<br>
<p>

2) There are 2 basic pre-requisites for the project to run on your phone:
+ Your phone should have contacts with Birthdays (either manually added birthdays or synced through some app like Facebook)
+ Wish90 should be granted permissions to access your phone contacts
+ The minimum SDK of the device should be 17

3) Notes:
+ To run the main project- Clone and open wish90-android-mvp in AndroidStudio
+ In the main project, the drop down with each contact will just display options (Wish Now!, Alert Me!, etc.), no functions have been added for those options
+ Clicking on the '+' button goes to another page to add new moments but no functionality has been added to actually save moments, it is just a page transition
+ lib/starnumber-lib is a Java project to check special numbers like 12345, 98765, 11111, etc. It needs to be integrated with the Main project
+ iteration4-irene/Sampleproject is an independent project that allows you to change preferences for the app

Team Member Contributions:
+ Raghu:
  * Integration of modules
  * Mentoring the team
+ Siva:
  * Age Display UI improvements
  * Star number algorithm
+ Rrezarta:
  * App skeleton
  * Database development improvements
+ Irene:
  * Settings module
  * Add Notifications option
+ Venky:
  * New moment module
+ Deepti:
  * Options on each card
  * Integration of Venky’s module

References:
+ [Architecting Android The Clean Way](http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/)
+ [Material Page Viewer](https://github.com/florent37/MaterialViewPager)
+ [Age Calculator Reference](http://freeprojectscode.com/android-projects/age-calculator/814/)
+ [Facebook Connectivity](http://stackoverflow.com/questions/6236251/android-get-facebook-friends-list)
+ [Compose Dynamic Image](https://gist.github.com/andrei-mak/8573359)
+ [Icon Images (Purchases are pending)] (http://www.123rf.com/photo_15567696_stock-photo.html)


