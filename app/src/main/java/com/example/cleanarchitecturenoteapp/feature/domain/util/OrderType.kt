package com.example.cleanarchitecturenoteapp.feature.domain.util

sealed class OrderType {
    data object Ascending : OrderType()
    data object Descending : OrderType()
}