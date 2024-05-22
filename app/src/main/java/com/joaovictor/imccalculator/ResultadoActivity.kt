package com.joaovictor.imccalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAtura: TextView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textPeso = findViewById(R.id.textPeso)
        textAtura = findViewById(R.id.textAltura)
        textResultado = findViewById(R.id.textResultado)

        val bundle = intent.extras
        if (bundle != null) {
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado $peso kg"
            textAtura.text = "altura informada $altura m"

            val imc = peso / (altura * altura)

            if (imc < 18.5) {
                textResultado.text = "Baixo"
            } else if (imc in 18.5..24.9) {
                textResultado.text = "Normal"
            } else if (imc in 25.0..29.9) {
                textResultado.text = "Sobrepeso"
            } else if (imc in 30.0..39.9) {
                textResultado.text = "Obesidade"
            }

        }
    }
}