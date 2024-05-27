package com.example.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.example.cleanarchitecturenoteapp.feature.data.datasource.NoteDatabase
import com.example.cleanarchitecturenoteapp.feature.data.repository.NoteRepositoryImpl
import com.example.cleanarchitecturenoteapp.feature.domain.reposiotory.NoteRepository
import com.example.cleanarchitecturenoteapp.feature.domain.usecase.DeleteNote
import com.example.cleanarchitecturenoteapp.feature.domain.usecase.GetNotes
import com.example.cleanarchitecturenoteapp.feature.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app : Application) : NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteRepository(db : NoteDatabase) : NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun providesNoteUseCase(repository: NoteRepository) : NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(noteRepository = repository),
            deleteNote = DeleteNote(noteRepository = repository)
        )
    }
}