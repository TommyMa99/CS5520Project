---
layout: post
title: "To-Do-App-Version2-Writeup"
date: 2021-10-13
---


**Latest Updates!!!!!: Test for App available to join:**

Join on Android: [link](https://play.google.com/store/apps/details?id=edu.neu.khoury.madsea.majianqing)

Join on the Web: [link](https://play.google.com/apps/testing/edu.neu.khoury.madsea.majianqing)

Link for a brief demo of this App: [link](https://youtu.be/FLZE0s2Xv60)

----------------------------------------------------------------------------------------------------

* **Link to code for To-Do_List_app**: [link](https://github.com/TommyMa99/TodoApp_Final_Version)
* **Link to the app-release.apk for To-Do_List_app**: [link](https://github.com/TommyMa99/CS5520Project/blob/apkFile/app-release.apk)

**Summarize**: 

*New Features Added:* 

1. Implemented MVC struture in the app's artitecture by seperating the app's structure into UI Controller(Activity/Fragment), View model, repository and room database with DAO and entity.
1. Created user entity that describes a SQL databse table which includes detailed data of the user's to-do item.
1. Created UserDao which maps SQL queries including update, delete, and insert items to functions
1. Used room database to access and initialize SQL database when needed.
1. Implemented repository which abstract data from SQL local database while providing a clear API for the rest of the app to access the data.
1. Constructed ViewModel which holds communication between UI components and the repository. Used Live data and observer to notify changes when data is updated, deleted , and inserted.
1. Implemented Recycler view and a ListAdapter to populate the screen with todo item while holds the connection with viewModel.
1. Replaced Firebase real-time database with SQL local database accessed from a Room database
1. Implemented data and time picker with a calender and animated clock shown up which allows the user to set up reminder time in a easy and clear way.
1. Created Notifiction channel and set the content of the notification to the to-do item description.
1. Integrated work manager to schedule works to send out notification to the user at their specified reminder time for each task.
1. Modifying reminder work from the worker queue in the work manager when user delete and edit to-do item.
1. Used item description as the tag for the work which allows the user to cancel and edit ther to-do task without worrying about reminder mulfunctioning but with certain trade offs.
1. User has to use the same item title when editting the to-do item, else the reminder for previous item would not be deleted.
1. Implemented Search View which enables users to search for a todo-item in the search box using the title of the to-do item.
1. Integrated option menu for each created to-do item where users can view, delete or edit items.
1. Created safe delete functions for users when deleting an item to make sure the user doesn't click it by accident.  

![image](https://user-images.githubusercontent.com/90421186/147965938-eb5960f2-a2de-4a4f-ba3b-66dd9699c19a.png)

![image](https://user-images.githubusercontent.com/90421186/147966061-ffc4bb74-446d-4447-9b0e-74ec87113e68.png)

![image](https://user-images.githubusercontent.com/90421186/147966083-607ce1f8-4739-4af6-a787-162dd151b579.png)

![image](https://user-images.githubusercontent.com/90421186/147966100-fc715dbc-f8bd-4a3a-9e2e-af4c4c80218a.png)

![image](https://user-images.githubusercontent.com/90421186/147966132-c40dd5b5-efa8-476c-bbd6-c9a850146de7.png)
