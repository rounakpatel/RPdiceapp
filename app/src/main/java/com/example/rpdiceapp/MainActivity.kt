package com.example.rpdiceapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.random


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private val spinner: Spinner? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.DiceSide)



        roll_button.setOnClickListener {
            diceRoll()
        }
        val adapter =
            ArrayAdapter.createFromResource(this, R.array.diceside, android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
    }

    private fun diceRoll() {
        var randomNo = (1..6).random()
        var imageDice: Int
        when (randomNo) {
            1 -> {
                imageDice = R.drawable.dice_1
            }
            2 -> {
                imageDice = R.drawable.dice_2
            }
            3 -> {
                imageDice = R.drawable.dice_3
            }
            4 -> {
                imageDice = R.drawable.dice_4
            }
            5 -> {
                imageDice = R.drawable.dice_5
            }
            else -> {
                imageDice = R.drawable.dice_6
            }
        }

        Dice_image.setImageResource(imageDice)

        Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()

    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        val choice = adapterView.getItemAtPosition(i).toString()
        Toast.makeText(getApplicationContext(),choice, Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(adapterView: AdapterView<*>?) {}
}

