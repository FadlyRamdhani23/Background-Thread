package org.d3if3127.mybackgroundthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.d3if3127.mybackgroundthread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var liveDataTimeViewModel: MainViewModel
    private lateinit var activityMainBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        liveDataTimeViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        subscribe()

    }

    private fun subscribe(){
        val elapsedTimeObserver = Observer<Long?> { aLong ->
        val newText = this@MainActivity.resources.getString(R.string.seconds, aLong)
            activityMainBinding.timerTextview.text = newText
        }

        liveDataTimeViewModel.getElapsedTime().observe(this, elapsedTimeObserver)
    }
}