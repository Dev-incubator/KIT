package com.devincubator.keepintime.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.devincubator.keepintime.domain.models.Description
import com.devincubator.keepintime.domain.models.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks JOIN descriptions"
            + " ON tasks.id = descriptions.id"
    )
    fun getAllTasks(): Flow<Map<Task, Description>>

    @Query("SELECT * FROM tasks WHERE id = :id")
    fun getTaskById(id: Int): Flow<Task>

    @Insert
    fun insertTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}