package org.d3if3127.mybackgroundthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import org.d3if3127.mybackgroundthread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResults()

        activityMainBinding.btnCalculate.setOnClickListener {

            val width = activityMainBinding.edtWidth.text.toString()
            val height = activityMainBinding.edtHeight.text.toString()
            val length = activityMainBinding.edtLength.text.toString()

            when {
                width.isEmpty() -> {
                    activityMainBinding.edtWidth.error = "Masih kosong"
                }
                height.isEmpty() -> {
                    activityMainBinding.edtHeight.error = "Masih kosong"
                }
                length.isEmpty() -> {
                    activityMainBinding.edtLength.error = "Masih kosong"
                }
                else -> {
                    viewModel.calculate(width, height, length)
                    displayResults()
                }
            }
        }
    }

    private fun displayResults() {
        activityMainBinding.tvResult.text = viewModel.result.toString()
    }
}