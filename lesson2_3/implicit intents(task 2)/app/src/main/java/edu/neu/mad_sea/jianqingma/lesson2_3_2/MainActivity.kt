package edu.neu.mad_sea.jianqingma.lesson2_3_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView

import android.content.Intent
import android.net.Uri
import android.net.Uri.parse
import kotlin.Unit.toString


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = intent
        val uri: Uri? = intent.data
        if (uri != null) {
            val uristring = (getString(R.string.uri_label) + uri.toString())
            val textView = findViewById<TextView>(R.id.text_uri_message)
            textView.text = uristring
        }
    }
}