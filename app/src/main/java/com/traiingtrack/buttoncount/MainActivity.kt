package com.traiingtrack.buttoncount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

private val TAG: String = "MainActivity"

class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById<EditText>(R.id.userInput)
        val button: Button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.editTextMain)
        var numTimesClicked: Int = 0
        var name: String = ""

        userInput?.setText("")
        userInput?.setHint("Enter a name")
        textView?.setText("")

        button?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick called")
                val toast: Toast = Toast.makeText(applicationContext, "You tapped me, ouch!", Toast.LENGTH_SHORT);
                numTimesClicked++;
                name = userInput.text.toString()
                val s: String = if(numTimesClicked > 1) "s" else ""
                textView?.append("$name clicked the button $numTimesClicked time$s.\n")
                textView?.append("\n")
                userInput.setText("")
            }

        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}
