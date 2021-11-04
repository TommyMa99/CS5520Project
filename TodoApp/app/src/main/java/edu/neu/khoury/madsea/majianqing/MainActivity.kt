package edu.neu.khoury.madsea.majianqing

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() ,UpdateandDelete  {

    private lateinit var itemSummary : String
    private lateinit var deadline : String
    private lateinit var details : String
    private lateinit var tags : String
    private lateinit var time_to_remind : String
    private var savedDay : Int = 0
    private var savedYear : Int = 0
    private var savedMonth : Int = 0
    private var savedHour : Int = 0
    private var savedMinute : Int = 0
    private var done : Boolean? = null
    private var id : Int = 0
    private var reminderCheck : Boolean? = null

    private val newWordActivityRequestCode = 1
    private val editActivityCode = 2
    private val todoViewModel: TodoViewModel by viewModels {
        WordViewModelFactory((application as TodoApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = todoListAdapter(this as UpdateandDelete)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewItemActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }

        todoViewModel.users.observe(this, Observer { users ->
            users?.let { adapter.submitList(it) }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewItemActivity.EXTRA_ITEM_DATA_TEXT)?.let { reply ->
                itemSummary = reply
            }
            data?.getStringExtra(NewItemActivity.EXTRA_DEADLINE)?.let { reply ->
                deadline = reply
            }
            data?.getExtras()?.getBoolean(NewItemActivity.EXTRA_DONE).let { reply ->
                done = reply
            }
            data?.getStringExtra(NewItemActivity.EXTRA_MORE_DETAILS)?.let { reply ->
                details = reply
            }
            data?.getExtras()?.getBoolean(NewItemActivity.EXTRA_REMINDER).let { reply ->
                reminderCheck = reply
            }
            data?.getStringExtra(NewItemActivity.EXTRA_TAGS)?.let { reply ->
                tags = reply
            }
            data?.getStringExtra(NewItemActivity.EXTRA_TIME_TO_REMIND)?.let { reply ->
                time_to_remind = reply
            }
            data?.getExtras()?.getInt(EditActivity.EXTRA_YEAR)?.let { reply ->
                savedYear = reply
            }
            data?.getExtras()?.getInt(EditActivity.EXTRA_MONTH)?.let { reply ->
                savedMonth = reply
            }
            data?.getExtras()?.getInt(EditActivity.EXTRA_DAY)?.let { reply ->
                savedDay = reply
            }
            data?.getExtras()?.getInt(EditActivity.EXTRA_HOUR)?.let { reply ->
                savedHour = reply
            }
            data?.getExtras()?.getInt(EditActivity.EXTRA_MINUTE)?.let { reply ->
                savedMinute = reply
            }
            val user : UserEntity = UserEntity(itemSummary, details, tags, deadline, reminderCheck as Boolean, time_to_remind, done as Boolean)
            todoViewModel.insert(user)
            if(reminderCheck as Boolean){
                val c = Calendar.getInstance()
                c.set(savedYear, savedMonth, savedDay, savedHour, savedMinute, 0)
                val today = Calendar.getInstance()
                val diff = (c.timeInMillis/1000L)-(today.timeInMillis/1000L)

                val myWorkRequest = OneTimeWorkRequestBuilder<TodoWorker>()
                    .addTag(user.id.toString())
                    .setInitialDelay(diff, TimeUnit.SECONDS)
                    .setInputData(
                        workDataOf(
                        "title" to itemSummary.toString(),
                        "message" to "Reminder!")
                    )
                    .build()
                WorkManager.getInstance(this).enqueue(myWorkRequest)
            }
        } else if(requestCode == editActivityCode && resultCode == Activity.RESULT_OK){
            data?.getStringExtra(EditActivity.EXTRA_ITEM_DATA_TEXT)?.let { reply ->
                itemSummary = reply
            }
            data?.getStringExtra(EditActivity.EXTRA_DEADLINE)?.let { reply ->
                deadline = reply
            }
            data?.getExtras()?.getBoolean(EditActivity.EXTRA_DONE).let { reply ->
                done = reply
            }
            data?.getStringExtra(EditActivity.EXTRA_MORE_DETAILS)?.let { reply ->
                details = reply
            }
            data?.getExtras()?.getBoolean(EditActivity.EXTRA_REMINDER).let { reply ->
                reminderCheck = reply
            }
            data?.getStringExtra(EditActivity.EXTRA_TAGS)?.let { reply ->
                tags = reply
            }
            data?.getStringExtra(EditActivity.EXTRA_TIME_TO_REMIND)?.let { reply ->
                time_to_remind = reply
            }
            data?.getExtras()?.getInt(EditActivity.EXTRA_ID)?.let { reply ->
                id = reply
            }
            data?.getExtras()?.getInt(EditActivity.EXTRA_YEAR)?.let { reply ->
                savedYear = reply
            }
            data?.getExtras()?.getInt(EditActivity.EXTRA_MONTH)?.let { reply ->
                savedMonth = reply
            }
            data?.getExtras()?.getInt(EditActivity.EXTRA_DAY)?.let { reply ->
                savedDay = reply
            }
            data?.getExtras()?.getInt(EditActivity.EXTRA_HOUR)?.let { reply ->
                savedHour = reply
            }
            data?.getExtras()?.getInt(EditActivity.EXTRA_MINUTE)?.let { reply ->
                savedMinute = reply
            }
            val user : UserEntity = UserEntity(itemSummary, details, tags, deadline, reminderCheck as Boolean, time_to_remind, done as Boolean)
            user.id = id
            todoViewModel.update(user)
            WorkManager.getInstance(this).cancelAllWorkByTag(user.id.toString())
            if(reminderCheck as Boolean){
                val c = Calendar.getInstance()
                c.set(savedYear, savedMonth, savedDay, savedHour, savedMinute, 0)
                val today = Calendar.getInstance()
                val diff = (c.timeInMillis/1000L)-(today.timeInMillis/1000L)

                val myWorkRequest = OneTimeWorkRequestBuilder<TodoWorker>()
                    .addTag(user.id.toString())
                    .setInitialDelay(diff, TimeUnit.SECONDS)
                    .setInputData(
                        workDataOf(
                            "title" to itemSummary.toString(),
                            "message" to "Reminder!")
                    )
                    .build()
                WorkManager.getInstance(this).enqueue(myWorkRequest)
            }

        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }
    override fun modifyItem(item:UserEntity) {
        item.done = !item.done
        todoViewModel.update(item)
    }

    override fun onItemDelete(item: UserEntity) {
        WorkManager.getInstance(this).cancelAllWorkByTag(item.id.toString())
        todoViewModel.delete(item)

    }

    override fun onItemEdit(item:UserEntity) {
        val intent = Intent(this@MainActivity, EditActivity::class.java)
        intent.putExtra("item", item.id)
        startActivityForResult(intent, editActivityCode)
    }

}