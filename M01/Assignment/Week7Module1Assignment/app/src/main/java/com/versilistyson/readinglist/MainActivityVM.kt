package com.versilistyson.readinglist

import com.versilistyson.readinglist.model.Book

class MainActivityVM {
    val books = listOf<Book>(
        Book(
            "In Search of Lost Time",
            "Swann's Way, the first part of A la recherche de temps perdu, Marcel Proust's seven-part cycle, was published in 1913",
             id = 1
        ),
        Book(
            title = "Ulysses",
            reasonToRead = "Ulysses chronicles the passage of Leopold Bloom through Dublin during an ordinary day, June 16, 1904",
            id = 2
        ),
        Book(
            title = "Don Quixote",
            reasonToRead = "Alonso Quixano, a retired country gentleman in his fifties, lives in an unnamed section of La Mancha with his niece and a housekeeper. ",
            id = 3
        ),
        Book(
            title = "The Great Gatsby",
            reasonToRead = "The novel chronicles an era that Fitzgerald himself dubbed the \"Jazz Age\".",
            id = 4
        ),
        Book(
            title = "Moby Dick",
            reasonToRead = "irst published in 1851, Melville's masterpiece is, in Elizabeth Hardwick's words, \"the greatest novel in American literature.\" ",
            id = 5
        )
    )
}