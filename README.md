# Wish90

Wish90 project devided into 4 modules. Each module's work is delivered under various braches by the module owners. 
Evenentually all the code will be mearged into one branch after interation 2. 

Branches To Check:
#### Branch: master: skeleton and data module 
+ Authors: Rrazarta & Raghu
+ Rrezarta: The integral part of the Wish90 app is to divide the schema of entire application into 4 different layers. I'm specifically responsible handling the data layer of the Wish90 app. My role is to ensure that the the flow of data is coordinated and streamed correctly from other layers and vice-versa. You will see in the code that a data mappers is needed in order to accomplish data transformation and the creation of objects to allow the integration of data visible to the application entire design 
+ Description - App Skeleton : App Skeleton is the project refered  
+ [Executable Project Location](https://github.com/visumagic/wish90/tree/master/Wish90App/wish90-android-mvp)

#### Branch: convey-a-wish:  
+ Author: Deepti
+ [Executable Project Location](https://github.com/visumagic/wish90/tree/convey-a-wish-module/Wish90App/android)
+ Description: 
The module is built using a driver which accepts friend name and displays a notification showing that friend has a birthday. When user clicks the notification a dynamic image is composed. After integration with UI timer and other modules (when it gets actual event name, friend name, time etc.), this module will be fully functional. 

#### Branch: Contacts Gathering
+ Author: Venkatesh 
+ [Executable Project Location](https://github.com/visumagic/wish90/tree/contacts-module/Wish90App/android-contacts-app-module/mobile)
+ Description:
This module gathers information from phone contacts and displays contact name and Date of birth.

#### Branch: ui-timer-module
+ Author: Siva Kiran
+ [Executable Project Location](https://github.com/visumagic/wish90/tree/ui-timer-module/Wish90App/agecalculatorapp)
+ Description:
This module takes the date of birth as the input and calculates and displays the current age. 

References:
+ [Architecting Android The Clean Way](http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/)
+ [Material Page Viewer](https://github.com/florent37/MaterialViewPager)
+ [Age Calculator Reference](http://freeprojectscode.com/android-projects/age-calculator/814/)
+ [Facebook Connectivity](http://stackoverflow.com/questions/6236251/android-get-facebook-friends-list)
+ [Compose Dynamic Image](https://gist.github.com/andrei-mak/8573359)


