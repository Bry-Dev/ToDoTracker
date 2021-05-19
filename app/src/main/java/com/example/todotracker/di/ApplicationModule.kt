package com.example.todotracker.di

import android.content.Context
import androidx.room.Room
import com.example.todotracker.BaseApplication
import com.example.todotracker.database.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApplicationModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext appContext: Context) : BaseApplication {
        return appContext as BaseApplication
    }

    @Singleton
    @Provides
    fun provideCompleted() : Int {
        return 7
    }

    @Singleton
    @Provides
    fun provideInWork() : Int {
        return 25
    }

    @Singleton
    @Provides
    fun provideOverdue() : Int {
        return 31
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) : ToDoDatabase {
        return Room.databaseBuilder(
            appContext.applicationContext,
            ToDoDatabase::class.java,
            "to_do_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}