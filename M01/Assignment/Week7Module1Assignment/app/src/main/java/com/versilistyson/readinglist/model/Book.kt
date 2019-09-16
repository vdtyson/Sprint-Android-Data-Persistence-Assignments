package com.versilistyson.readinglist.model

data class Book (
    val title: String,
    val reasonToRead: String,
    var hasBeenRead: Boolean = false,
    var hasBeenFaved: Boolean = false,
    val id: Int
)