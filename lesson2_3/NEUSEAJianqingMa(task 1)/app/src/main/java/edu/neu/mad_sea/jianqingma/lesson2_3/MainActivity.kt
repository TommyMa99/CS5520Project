package edu.neu.mad_sea.jianqingma.lesson2_3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import androidx.core.app.ShareCompat


class MainActivity : AppCompatActivity() {
    private var mWebsiteEditText: EditText? = null
    private var mLocationEditText: EditText? = null
    private var mShareTextEditText: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mWebsiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_edittext)
        mShareTextEditText = findViewById(R.id.share_edittext)
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun openWebsite(view: View) {
        // Get the URL text.
        // Get the URL text.
        val url = mWebsiteEditText!!.text.toString()

        // Parse the URI and create the intent.

        // Parse the URI and create the intent.
        val webpage: Uri = Uri.parse(url)
        intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)

        // Find an activity to hand the intent and start that activity.

        // Find an activity to hand the intent and start that activity.
        /*if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }*/
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun openLocation(view: View?) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        val loc = mLocationEditText!!.text.toString()

        // Parse the location and create the intent.
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        intent = Intent(Intent.ACTION_VIEW, addressUri)
        startActivity(intent)
        // Find an activity to handle the intent, and start that activity.
        /*if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        } */
    }

    fun shareText(view: View?) {
        val txt = mShareTextEditText!!.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle(R.string.share_text_with)
            .setText(txt)
            .startChooser()
    }
}