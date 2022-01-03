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
