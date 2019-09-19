package com.versilistyson.readinglist.model

import java.io.Serializable

data class Book (
    var title: String,
    var reasonToRead: String,
    var hasBeenRead: Boolean = false,
    var hasBeenFaved: Boolean = false,
    var id: Int
) : Serializable