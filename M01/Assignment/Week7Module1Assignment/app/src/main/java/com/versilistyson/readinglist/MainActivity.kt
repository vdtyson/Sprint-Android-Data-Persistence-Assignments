package com.versilistyson.readinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.versilistyson.readinglist.model.Book
import com.versilistyson.readinglist.ui.EditBookActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var bookList = MainActivityVM().books.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle :Bundle? =intent.extras
        if (bundle!= null) {
            val editedBook = bundle.getSerializable(EditBookActivity.EDITED_BOOK) as Book
            val editedBookIndex = bundle.getInt(EditBookActivity.EDITED_BOOK_INDX)
            bookList[editedBookIndex] = editedBook
            initRecyclerView(bookList)
        } else {
            initRecyclerView(bookList)
        }


    }

    fun initRecyclerView(itemList: List<Book>) {

        mainActivity_recyclerView.apply {
            val bookRVLayoutManager = LinearLayoutManager(this@MainActivity)
            val bookItemRVAdapter = BookItemRecyclerViewListAdapter(itemList, this@MainActivity)
            layoutManager = bookRVLayoutManager
            adapter = bookItemRVAdapter
        }
    }
}
