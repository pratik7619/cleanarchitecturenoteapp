package com.example.cleanarchitecturenoteapp.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cleanarchitecturenoteapp.ui.theme.BabyBlue
import com.example.cleanarchitecturenoteapp.ui.theme.LightGreen
import com.example.cleanarchitecturenoteapp.ui.theme.RedOrange
import com.example.cleanarchitecturenoteapp.ui.theme.RedPink
import com.example.cleanarchitecturenoteapp.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: String,
    val color: Int,
    @PrimaryKey val id: Int? = 0
) {
    companion object {
        val noteColors = listOf(
            RedOrange,
            LightGreen,
            Violet,
            BabyBlue,
            RedPink
        )
    }
}
