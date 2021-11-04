package edu.neu.khoury.madsea.majianqing

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userInfo_table")
class UserEntity(
    var itemDataText: String,
    var moreDetails: String,
    var tags: String,
    var deadline: String,
    var reminder: Boolean,
    var timeToRemind: String,
    var done: Boolean
){
    @PrimaryKey (autoGenerate = true) var id: Int = 0
}
