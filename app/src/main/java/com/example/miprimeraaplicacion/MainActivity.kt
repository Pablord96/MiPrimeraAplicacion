package com.example.miprimeraaplicacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraaplicacion.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var numeroSecreto = 0
    private var intentos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numero: EditText = findViewById(R.id.editTextText)
        val boton: Button = findViewById(R.id.button)
        val texto: TextView = findViewById(R.id.textView2)

        // Genera un número aleatorio del 1 al 100
        numeroSecreto = Random.nextInt(1, 101)

        boton.setOnClickListener {
            val input = numero.text.toString()

            if (input.isEmpty()) {
                texto.text = "Por favor, escribe un número."
                return@setOnClickListener
            }

            val numeroUsuario = input.toInt()
            intentos++

            when {
                numeroUsuario < numeroSecreto -> texto.text = "El número secreto es mayor. Intentos: $intentos"
                numeroUsuario > numeroSecreto -> texto.text = "El número secreto es menor. Intentos: $intentos"
                else -> {
                    texto.text = "Ole ole ¡Acertaste! El número era $numeroSecreto. Lo lograste en $intentos intentos."
                    // Reiniciar juego automáticamente
                    numeroSecreto = Random.nextInt(1, 101)
                    intentos = 0
                }
            }

            numero.text.clear()
        }
    }
}
