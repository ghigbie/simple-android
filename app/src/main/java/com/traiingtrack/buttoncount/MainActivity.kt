package com.traiingtrack.buttoncount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

private const val TAG: String = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

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

        button?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick called")

                if(name != "") {
                    numTimesClicked++;
                    name = userInput.text.toString()
                    val s: String = if(numTimesClicked > 1) "s" else ""
                    textView?.movementMethod = ScrollingMovementMethod()
                    textView?.append("$name clicked the button $numTimesClicked time$s.\n")
                    textView?.append("\n")
                    userInput.setText("")
                }else{
                    val toast: Toast = Toast.makeText(
                        applicationContext,
                        "You tapped me, ouch! I need a name.",
                        Toast.LENGTH_SHORT
                    );
                    toast.show()
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState called")
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "************************************")
        Log.d(TAG, savedInstanceState?.getString(TEXT_CONTENTS))
        textView?.text = savedInstanceState?.getString(TEXT_CONTENTS, "")
    }

    override fun onPause() {
        Log.d(TAG, "onPause called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.d(TAG, "onSaveInstanceState called")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS, textView?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG, "onStop called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart called")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy called")
        super.onDestroy()
    }
}
