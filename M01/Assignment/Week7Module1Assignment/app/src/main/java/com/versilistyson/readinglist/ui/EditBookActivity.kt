package com.versilistyson.readinglist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.versilistyson.readinglist.BookItemRecyclerViewListAdapter
import com.versilistyson.readinglist.MainActivity
import com.versilistyson.readinglist.MainActivityVM
import com.versilistyson.readinglist.R
import com.versilistyson.readinglist.model.Book
import kotlinx.android.synthetic.main.activity_edit_book.*

class EditBookActivity : AppCompatActivity() {

    companion object {
        const val EDITED_BOOK = "EDITED_BOOK"
        const val EDITED_BOOK_INDX = "EDITED_BOOK_INDX"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_book)

        val bookList = MainActivityVM().books
        var book = intent.getSerializableExtra(BookItemRecyclerViewListAdapter.BOOK_OBJECT) as Book
        val bookItemIndex = intent.getIntExtra(BookItemRecyclerViewListAdapter.BOOK_INDEX, 0)

        editBookActivity_favImgBttn.setOnClickListener {
            when (book.hasBeenFaved) {
                true -> {
                    book.hasBeenFaved = false
                    editBookActivity_favImgBttn.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                }
                false -> {
                    book.hasBeenFaved = true
                    editBookActivity_favImgBttn.setImageResource(R.drawable.ic_favorite_black_24dp)
                }
            }
        }

        editBookActivity_isReadImgttn.setOnClickListener {
            when (book.hasBeenRead) {
                true -> {
                    book.hasBeenRead = false
                    editBookActivity_isReadImgttn.setImageResource(R.drawable.ic_book_not_read_24dp)
                }
                false -> {
                    book.hasBeenRead = true
                    editBookActivity_isReadImgttn.setImageResource(R.drawable.ic_book_black_24dp)
                }
            }
        }

        editBookActivity_materialBttnSaveChanges.setOnClickListener {

            if(editBookActivity_bookNameET.text.toString().isNotBlank()) {
                book.title = editBookActivity_bookNameET.text.toString()
            }

            if(editBookActivity_bookDescriptionET.text.toString().isNotBlank()) {
                book.reasonToRead = editBookActivity_bookDescriptionET.text.toString()
            }



            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(EDITED_BOOK, book)
            intent.putExtra(EDITED_BOOK_INDX, bookItemIndex)
            startActivity(intent)
        }
        editBookActivity_materialBttnCancel.setOnClickListener {
            finish()
        }
    }

    fun returnData() {

    }
}
