---
layout: post
title: "To-Do-App-Version2-Writeup"
date: 2021-10-13
---





**Update: Due to policy problem with the "Appealing to children" feature, the review for To-Do-App version 1 wasn't approved.
I reconfigured everything that is not consistent with Google console's privacy policy and updated the app bundle for version 
2 of my to-do-app. I'll keep update on the reviewing process here. I've also uploaded my to-do-app version 2 .apk/app bundle on github.**

**Latest Updates!!!!!: Test for App available to join: 

Join on Android: https://play.google.com/store/apps/details?id=edu.neu.khoury.madsea.majianqing

Join on the Web: https://play.google.com/apps/testing/edu.neu.khoury.madsea.majianqing**

----------------------------------------------------------------------------------------------------

* **Link to the app-release.abb for To-Do_List_app**: [link](https://github.com/TommyMa99/TodoApp/blob/main/app-release.aab)
* **Link to the app-release.apk for To-Do_List_app**: [link](https://github.com/TommyMa99/TodoApp/blob/main/app-release.apk)

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

*What I've learned:*

I've learned how to create and use all the features above. Seperating the app into different models that take care of different functions enables me to easily debug the app process and clarify dependencies of each model to another which gives me more flexibility in adapting to changes and making update. Another thing I think is very valuable to me is that using this artitecture enables me to implement any type of app as it acts as the foundamental structure of all kinds of app that includes interactions of UI and user input. For details of the app, I'm getting used to using base adapters, list adapters and passing an interface implemented in the main activity into adapter to modify viewModel. Besides implementing all these features learned above, I'm still confused about setting up the Room database and the call back method. The hardest part of this assignment is to integrate all the youtube videos, android studio tutorials, resources on canvas, and stackflow post to come up with a structual design that embrace all the features of my app in Kotlin. I also learned a lot from studying all the things from resources online.

Since the app's appearence and UI components are the same as version 1 app, I'm not including any screen shot here. However, the version 2 to-do-app has been largely modified in the MVC structure of the app. Please refer to post with version1 To-do-app for screenshots of the app. 
