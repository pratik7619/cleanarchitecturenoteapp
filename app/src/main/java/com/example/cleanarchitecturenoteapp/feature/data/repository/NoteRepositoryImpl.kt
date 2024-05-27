package com.example.cleanarchitecturenoteapp.feature.data.repository

import com.example.cleanarchitecturenoteapp.feature.data.datasource.NoteDao
import com.example.cleanarchitecturenoteapp.feature.domain.model.Note
import com.example.cleanarchitecturenoteapp.feature.domain.reposiotory.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl (
    private val noteDao: NoteDao
): NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
       return noteDao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
       noteDao.deleteNote(note)
    }
}