package com.example.edittextlesson

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /* create function for result button clicked
    1. create function
    2. take text from all 3 edit text - you may want to create variables for that
    3. set text for result text
    4. make result text visible
    5. hide keyboard
     */

    fun resultButtonClicked(view: View) {
        val name = name_input.text.toString()
        val age = age_input.text.toString()
        val hobby = hobby_input.text.toString()
        result_text.text = "Twoje imię to $name. Masz $age lat. Twoje zainteresowania to $hobby"
        result_text.visibility = View.VISIBLE
        hideKeyboard(this)
    }

    // from: https://stackoverflow.com/a/17789187/7586488
    private fun hideKeyboard(activity: Activity) {
        val imm: InputMethodManager =
            activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}