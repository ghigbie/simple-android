package com.traiingtrack.buttoncount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userInput: EditText = findViewById<EditText>(R.id.userInput)
        var button: Button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.editTextMain)
        var numTimesClicked: Int = 0
        var name: String = ""

        userInput?.setHint("Enter a name")
        textView?.setText("")

        button?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
            val toast: Toast = Toast.makeText(applicationContext, "You tapped me, ouch!", Toast.LENGTH_SHORT);
                numTimesClicked++;
                name = userInput.text.toString()
                val s: String = if(numTimesClicked > 1) "s" else ""
                textView?.append("$name clicked the button $numTimesClicked time$s. \n")
        }


        })
    }
}
