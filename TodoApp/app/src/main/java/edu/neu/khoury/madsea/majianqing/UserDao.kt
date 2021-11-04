package edu.neu.khoury.madsea.majianqing

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM userInfo_table")
    fun getList(): Flow<List<UserEntity>>

    @Insert()
    suspend fun insert(todo: UserEntity)

    @Delete()
    suspend fun delete(todo: UserEntity)

    @Update()
    suspend fun update(todo: UserEntity)
}