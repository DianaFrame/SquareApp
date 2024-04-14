package com.example.squarteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.squarteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun createIntentAndOpenNewActivity(figure: String){
        val intent = Intent(this, CalculateActivity::class.java)
        intent.putExtra(Constants.FIGURE_SELECT, figure)
        startActivity(intent)
    }
    fun onClickSquare(view: View){
        createIntentAndOpenNewActivity(Constants.FIGURE_SQUARE)
    }
    fun onClickTriangle(view: View){
        createIntentAndOpenNewActivity(Constants.FIGURE_TRIANGLE)
    }
    fun onClickCircle(view: View){
        createIntentAndOpenNewActivity(Constants.FIGURE_CIRCLE)
    }
    fun onClickRectangle(view: View){
        createIntentAndOpenNewActivity(Constants.FIGURE_RECTANGLE)
    }
    fun onClickHexagon(view: View){
        createIntentAndOpenNewActivity(Constants.FIGURE_HEXAGON)
    }
}