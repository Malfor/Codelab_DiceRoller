package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.model.Dice

/**
 * Esta actividad permite cargar la vista principal y darle accion al boton de la misma
 * para mostrar un numero aleatorio a partir de la clase dado que se le pasa el numero de
 * lados en su constructor
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Este metodo inicializa el textView y genera un objeto de la clase Dice
     * luego mediante su metodo roll se le setea el resultado al textView
     */
    private fun rollDice() {
        val myDice = Dice(6)
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = myDice.roll().toString()
    }

}