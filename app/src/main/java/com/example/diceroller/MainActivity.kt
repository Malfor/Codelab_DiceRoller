package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        //Se inicia una imagen aleatoria cuando se abre la app.
        rollDice()
    }

    /**
     * Este metodo inicializa el imageView y genera un objeto de la clase Dice
     * luego mediante su metodo roll se le setea el drawable al imageView
     */
    private fun rollDice() {
        val myDice = Dice(6)
        var side = myDice.roll()
        val drawableResource = side.diceDrawableResource

        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = side.toString()
    }

    /**
     * La propiedad devuelve un entero que representa el recurso de la imagen drawable
     * para un lado segun el lado generado por el metodo roll
     */
    private val Int.diceDrawableResource: Int
        get() = when (this) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6 }

}