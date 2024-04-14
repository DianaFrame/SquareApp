package com.example.squarteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isEmpty
import com.example.squarteapp.databinding.ActivityCalculateBinding
import kotlin.math.pow
import kotlin.math.sqrt

class CalculateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculateBinding
    private var figure = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        figure = intent.getStringExtra(Constants.FIGURE_SELECT)!!
        when(figure){
            Constants.FIGURE_SQUARE->{
                editTextToGone()
            }
            Constants.FIGURE_TRIANGLE->{
                editTextToGone()
                binding.imFigure.setImageResource(R.drawable.triangle)
            }
            Constants.FIGURE_CIRCLE->{
                editTextToGone()
                binding.apply {
                    edA.hint = resources.getString(R.string.fieldR)
                    imFigure.setImageResource(R.drawable.circle)
                }
            }
            Constants.FIGURE_RECTANGLE->{
                binding.imFigure.setImageResource(R.drawable.rectangle)
            }
            Constants.FIGURE_HEXAGON->{
                editTextToGone()
                binding.imFigure.setImageResource(R.drawable.hexagon)
            }
        }
    }
    private fun editTextToGone() {binding.edB.visibility = View.GONE}
    private fun squareOfSquare(a: Double):Double = a.pow(2)
    private fun squareOfTriangle(a: Double):Double = a.pow(2)*sqrt(3.0)/4
    private fun squareOfCircle(r: Double):Double = Math.PI*r.pow(2)
    private fun squareOfRectangle(a: Double, b: Double):Double = a*b
    private fun squareOfHexagon(a: Double):Double = 3*sqrt(3.0)*a.pow(2)/2
    private fun printOnTextView(result: Double){
        val resultString = binding.tVResult.text.toString() + result.toString()
        binding.tVResult.text = resultString
    }
    private fun emptyFieldA(){
        if(binding.edA.text.isNullOrEmpty()) binding.edA.error = resources.getString(R.string.error)
    }
    private fun emptyFieldB(){
        if(binding.edB.text.isNullOrEmpty()) binding.edB.error = resources.getString(R.string.error)
    }
    fun onClickBack(view: View){
        finish()
    }
    fun onClickCalculate(view: View){
        when(figure){
            Constants.FIGURE_SQUARE->{
                emptyFieldA()
                printOnTextView(squareOfSquare(binding.edA.text.toString().toDouble()))
            }
            Constants.FIGURE_TRIANGLE->{
                emptyFieldA()
                printOnTextView(squareOfTriangle(binding.edA.text.toString().toDouble()))
            }
            Constants.FIGURE_CIRCLE->{
                emptyFieldA()
                printOnTextView(squareOfCircle(binding.edA.text.toString().toDouble()))
            }
            Constants.FIGURE_RECTANGLE->{
                emptyFieldA()
                emptyFieldB()
                printOnTextView(squareOfRectangle(binding.edA.text.toString().toDouble(),
                    binding.edB.text.toString().toDouble()))
            }
            Constants.FIGURE_HEXAGON->{
                emptyFieldA()
                printOnTextView(squareOfHexagon(binding.edA.text.toString().toDouble()))
            }
        }
    }
}