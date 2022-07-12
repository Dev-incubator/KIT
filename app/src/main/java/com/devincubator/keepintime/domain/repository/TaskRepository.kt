package com.devincubator.keepintime.domain.repository

import com.devincubator.keepintime.domain.models.Description
import com.devincubator.keepintime.domain.models.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun getAllTasks(): Flow<Map<Task, Description>>

    suspend fun getTaskById(id: Int): Flow<Task>

    suspend fun insertTask(task: Task)

    suspend fun deleteTask(task: Task)
}