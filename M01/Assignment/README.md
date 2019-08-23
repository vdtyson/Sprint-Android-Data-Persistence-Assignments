# AsyncTask File Io

## Introduction

This project will adapt your threading cypher project to load the text from asset files instead of the strings resource. This will allow for much bigger files, so be sure that your algorithm is efficient. Mine can perform a single step of the cypher in about 350ms.

## Instructions

### Part 1 - Setup

1. Download the txt files from this repo.
2. Open your Cypher project.
3. Right click the app directory in Android Studio
4. Navigate to New -> Folder -> Assets Folder
5. Copy the recently downloaded files into this directory
6. Build, test and commit your app

### Part 2 - Build a Dropdown list to select file

1. Add a `Spinner` component to your activity layout and attach a data member to it

2. You'll need to go through a few steps to add items to the spinner programmatically

3. Use `getAssets().list("")` to get a String array containing the names of the items in the assets folder

   > This will also give you sub directories for that folder, you will need to step through the array and keep all elements with ".txt" in the file names

4. Create an `ArrayAdapter<String>` object using the constructor `new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, itemArray)`

   1. the first parameter is your activity's context
   2. the layout for the spinner item
   3. the array of items (in this case `Strings`) to be used in the array

5. Call `setDropDownViewResource` on your adapter and pass it `android.R.layout.simple_spinner_dropdown_item` for the dropdown layout

6. Call `setAdapter` on your `Spinner` object and pass it your adapter

7. Test your app to make sure the items are added to the spinner list and commit

### Part 3 - Read and display the file

1. Create a `setOnItemSelectedListener` for your `Spinner`. Override the required methods for this listener. In this listener, we'll read our file

2. We're going to use a `BufferedReader` object for this task since we'll be reading in very large strings

3. Create a new `BufferedReader` object and assign it null

4. Create and initialize a `StringBuilder` object

5. Create a try block

6. In order to create a `BufferedReader` object, we'll have to create a couple of other objects

7. Retrieve the selected item by calling `adapterView.getItemAtPosition(i)` and casting it to a `String`

8. Create a new `InputStream` object.

9. Give it a value by calling `context.getAssets().open(itemString)` and passing it the `String` from your selected item 

10. Create a new `InputStreamReader` object by passing the constructor your `InputStream` object. 

11. Construct your `BufferedReader` object by passing the constructor your `InputStreamReader` object

    > This is all typically done in 1 or 2 lines of code, but it is clearer for your first time to do it like this.

12. We'll use the `BufferedReader` `readLine` method to read our file in. This method will read one line at a time and return null when the end of the file has been reached

13. Write a loop that will read each line and add it to your `StringBuilder` until the `readLine` method returns null

14. Then convert the `StringBuilder` to a `String` and display it in your scrolling view

### Part 4 - Save the File

You can keep your algorithm the same as it was before. You will notice that your string is significantly longer this time, so you'll want to make sure your algorithm is as efficient as you can make it. Once you have decrypted or encrypted the file. We'll want to save the result to a file

1. Add a save button to your layout
2. In the click listener for this button we'll need to open a file to your desired location. I'll be using the cache

> Alternately, you can save the file after the decoding is complete

1. Create a `String` filename using a combination of the number of steps in the cypher and the name of the file from the dropdown.

> You can get the filename by calling `spinner.gerSelectedItem`

1. Use `File.createTempFile` and pass it the filename, null, and the directory to use. To save in the cache directory, you can use `context.getCacheDir()`
2. Create a new `FileWriter` object by passing your file to the constructor
3. Use the `FileWriter`'s write method to write your string all at once.
4. Close the `FileWriter`

### Part 5 - Add Saved Files to the Dropdown

The last thing we'll do is add the cache directory as a source for files for our dropdown

1. In your original file list retrieval algorithm, after adding the assets to the list, use `context.getCacheDir().list()` to list all files in the cache directory.
2. Filter out everything without the `.txt` extension
3. Add to your list.
4. We'll now have to change our file reader algorithm to account for the new source.
5. In your testing, look at the name of the files you save in the temp directory. They all end with a string of characters with `.tmp` at the end. We can use that extension to determine where the file came from and where we need to read it from
6. In your reader, if the filename has this extension (use `string.contains(targetString))` to determine if the extension is there) create a new file by passing the constructor your cache directory and the filename.
7. Then use that file to construct a `FileInputStream` this will replace the `InputStream` you created previously in that specific scenario

## Challenge

- You'll probably notice that if you resave a temp file it will attach another temp extension to the name, update your save function to account for that
- Make your app more efficient and responsive by opening the file in a separate thread or task
- You really don't need to load and display the entire file to decode it. Adjust your app to only display part of the file to fill the screen. Then track the total steps the user adjusts the cypher by and apply it during the save function and either save externally or allow the user to select another app which was specifically designed to display a lot of text
