package com.devincubator.keepintime.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devincubator.keepintime.core.Constants.Companion.KEEP_IN_TIME_DB
import com.devincubator.keepintime.data.network.MeetingDao
import com.devincubator.keepintime.domain.models.Meeting

@Database(
    entities = [
    //Contact::class,
    //Task::class,
    Meeting::class,
    //Description::class,
    ],
    version = 2,
    exportSchema = false
)

abstract class KeepInTimeDb: RoomDatabase() {
    abstract fun meetingDao(): MeetingDao
    /*abstract fun contactDao(): ContactDao
    abstract fun taskDao(): TaskDao*/

    companion object {
        @Volatile
        private var INSTANCE: KeepInTimeDb? = null

        fun getDatabase(context: Context): KeepInTimeDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        KeepInTimeDb::class.java,
                        KEEP_IN_TIME_DB
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
