package com.example.cleanarchitecturenoteapp.feature.domain.usecase

import com.example.cleanarchitecturenoteapp.feature.domain.model.Note
import com.example.cleanarchitecturenoteapp.feature.domain.reposiotory.NoteRepository
import com.example.cleanarchitecturenoteapp.feature.domain.util.NoteOrder
import com.example.cleanarchitecturenoteapp.feature.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes (
    private val noteRepository: NoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ) : Flow<List<Note>> {
        return noteRepository
            .getNotes()
            .map {
                when (noteOrder.orderType) {
                    is OrderType.Ascending -> {
                        it.sortedBy(noteOrder)
                    }
                    is OrderType.Descending -> {
                        it.sortedByDescending(noteOrder)
                    }
                }
            }
    }
}

fun List<Note>.sortedBy(noteOrder: NoteOrder) : List<Note> {
    return when (noteOrder) {
        is NoteOrder.Date -> this.sortedBy { it.timestamp }
        is NoteOrder.Title -> this.sortedBy { it.title.toLowerCase() }
        is NoteOrder.Color -> this.sortedBy { it.color }
    }
}

fun List<Note>.sortedByDescending(noteOrder: NoteOrder) : List<Note> {
    return when (noteOrder) {
        is NoteOrder.Date -> this.sortedByDescending { it.timestamp }
        is NoteOrder.Title -> this.sortedByDescending { it.title.toLowerCase() }
        is NoteOrder.Color -> this.sortedByDescending { it.color }
    }
}