package com.lambdaschool.sharedprefs.database

import androidx.room.Room
import com.lambdaschool.sharedprefs.JournalRepoInterface
import com.lambdaschool.sharedprefs.model.JournalEntry
import android.content.Context

// TODO 5: Create the Database repo and implement the methods
class JournalDBRepo(context: Context) : JournalRepoInterface {

    private val contxt = context.applicationContext

    override fun createEntry(entry: JournalEntry) {
        database.entriesDao().createEntry(entry)
    }

    override fun readAllEntries(): MutableList<JournalEntry> {
        return database.entriesDao().readAllEntries()
    }

    override fun updateEntry(entry: JournalEntry) {
        database.entriesDao().updateEntry(entry)
    }

    override fun deleteEntry(entry: JournalEntry) {
        database.entriesDao().deleteEntry(entry)
    }

    // TODO 15: Build the Room database
    // lazy vs lateinit: If you have a lateinit variable you can change something in the variable. If there's nothing there
    private val database by lazy {
        Room.databaseBuilder(
            contxt,
            JournalEntryDB::class.java,
            "entry_database"
        ).fallbackToDestructiveMigration().build()
    }
}

