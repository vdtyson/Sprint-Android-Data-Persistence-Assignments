package com.versilistyson.readinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.versilistyson.readinglist.model.Book
import kotlinx.android.synthetic.main.book_cv.view.*
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.versilistyson.readinglist.ui.EditBookActivity

class BookItemRecyclerViewListAdapter(var items: List<Book>, val context: Context) : RecyclerView.Adapter<BookItemRecyclerViewListAdapter.ViewHolder>() {

    companion object {
      const val BOOK_OBJECT = "BOOK_OBJECT"
      const val BOOK_INDEX = "BOOK_INDEX"
        const val BOOK_LIST = "BOOK_LIST"
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val bookCardView = view.bookCV as MaterialCardView
        val bookNameTextView = view.bookCV_nameTV as TextView
        val reasonToReadTextView = view.bookCV_reasonToReadTV as TextView
        var favButton = view.bookCV_favButtonIcon as ImageButton
        var editButton = view.bookCV_editBttn as MaterialButton
        var isReadButton = view.bookCV_isReadButtonIcon as ImageButton

        //onClickListeners
        fun isFavedOnClickListener(position: Int) {

                when (items[position].hasBeenFaved) {
                    true -> {
                        items[position].hasBeenFaved = false
                        favButton.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                        Toast.makeText(
                            context,
                            "${items[position].title} was unfavorited!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    false -> {
                        items[position].hasBeenFaved = true
                        favButton.setImageResource(R.drawable.ic_favorite_black_24dp)
                        Toast.makeText(
                            context,
                            "${items[position].title} was favorited!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

        fun isReadOnClickListener(position: Int) {
                when (items[position].hasBeenRead) {
                    true -> {
                        items[position].hasBeenRead = false
                        isReadButton.setImageResource(R.drawable.ic_book_not_read_24dp)
                        Toast.makeText(
                            context,
                            "${items[position].title} has been unread!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    false -> {
                        items[position].hasBeenRead = true
                        isReadButton.setImageResource(R.drawable.ic_book_black_24dp)
                        Toast.makeText(
                            context,
                            "${items[position].title} has been read!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

        fun editButtonOnClickListener(position: Int) {
            var bookList = ArrayList<Book>()
            val intent = Intent(context, EditBookActivity::class.java)
            intent.putExtra(BOOK_OBJECT, items[position])
            intent.putExtra(BOOK_INDEX, items.indexOf(items[position]))
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.book_cv, parent,  false)
        return ViewHolder(viewGroup)
    }


    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if(items[position].hasBeenFaved) {
            holder.favButton.setImageResource(R.drawable.ic_favorite_black_24dp)
        }
        if(items[position].hasBeenRead) {
            holder.isReadButton.setImageResource(R.drawable.ic_book_black_24dp)
        }
        holder.bookNameTextView.text = items[position].title
        holder.reasonToReadTextView.text = items[position].reasonToRead

        holder.favButton.setOnClickListener {
            holder.isFavedOnClickListener(position)
        }
        holder.isReadButton.setOnClickListener {
            holder.isReadOnClickListener(position)
        }
        holder.editButton.setOnClickListener {
            holder.editButtonOnClickListener(position)
        }
    }


    fun update(itemList:List<Book>){
        items = itemList
        notifyDataSetChanged()
    }

}