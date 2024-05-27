package com.example.cleanarchitecturenoteapp.feature.domain.usecase

import com.example.cleanarchitecturenoteapp.feature.domain.model.Note
import com.example.cleanarchitecturenoteapp.feature.domain.reposiotory.NoteRepository

class DeleteNote (
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNote(note)
    }
}