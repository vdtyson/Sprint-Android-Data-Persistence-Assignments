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
import android.widget.Toast

class BookItemRecyclerViewListAdapter(var items: List<Book>, val context: Context) : RecyclerView.Adapter<BookItemRecyclerViewListAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val bookCardView = view.bookCV as MaterialCardView
        val bookNameTextView = view.bookCV_nameTV as TextView
        val reasonToReadTextView = view.bookCV_reasonToReadTV as TextView
        //var favButton = view.bookCV_favBttn as ImageButton
        var editButton = view.bookCV_editBttn as MaterialButton
        //var isReadButton = view.bookCV_isItReadBttn as ImageButton
        // onClickListeners
        /*fun isReadButtonOnClickListener(position: Int) {
            isReadButton.setOnClickListener{
                when(items[position].hasBeenRead) {
                    true -> items[position].hasBeenRead = false
                    false -> items[position].hasBeenRead = true
                }
            }
        } */

        /*fun isFavedOnClickListener(position: Int) {
            favButton.setOnClickListener {

                when(items[position].hasBeenFaved) {
                    true -> {
                        items[position].hasBeenFaved = false
                        favButton.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                        Toast.makeText(context, "${items[position].title} was unfavorited!", Toast.LENGTH_SHORT).show()
                    }
                    false -> {
                        items[position].hasBeenRead = true
                        favButton.setImageResource(R.drawable.ic_favorite_black_24dp)
                        Toast.makeText(context, "${items[position].title} was favorited!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        fun isReadOnClickListener(position: Int) {
            isReadButton.setOnClickListener {
                when(items[position].hasBeenRead) {
                    true -> {
                        items[position].hasBeenRead = false
                        isReadButton.setImageResource(R.drawable.ic_book_not_read_24dp)
                        Toast.makeText(context, "${items[position].title} has been unread!", Toast.LENGTH_SHORT).show()
                    }
                    false -> {
                        items[position].hasBeenRead = true
                        isReadButton.setImageResource(R.drawable.ic_book_not_read_24dp)
                        Toast.makeText(context, "${items[position].title} has been read!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        */
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.book_cv, parent,  false)
        val holder = ViewHolder(viewGroup)
        return holder
    }


    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: BookItemRecyclerViewListAdapter.ViewHolder, position: Int) {

        //holder.isReadButton.setImageResource(R.drawable.ic_book_not_read_24dp)
       // holder.favButton.setImageResource(R.drawable.ic_favorite_border_black_24dp)
        holder.bookNameTextView.text = items[position].title
        holder.reasonToReadTextView.text = items[position].reasonToRead
        //holder.favButton.setOnClickListener { holder.isFavedOnClickListener(position) }
        //holder.isReadButton.setOnClickListener { holder.isReadOnClickListener(position) }
    }


    fun update(itemList:List<Book>){
        items = itemList
        notifyDataSetChanged()
    }

}