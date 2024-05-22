package com.joaovictor.imccalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var  buttonCalcular : Button
    private lateinit var intent : Intent
    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // vinculação dos ids do XML com as classes
        buttonCalcular = findViewById(R.id.buttonCalcular)
        editPeso = findViewById(R.id.editPeso)
        editAltura = findViewById(R.id.editAltura)

        // configurando o botao para abrir outra activity. Ao mesmo tempo que o botao enviará dados para outra tela
        buttonCalcular.setOnClickListener{
            intent = Intent(this, ResultadoActivity::class.java)

            val peso = editPeso.text.toString()// pega o peso digitado e o transforma em string
            val altura = editAltura.text.toString()// pega a altura digitada e a transforma em string

            if(peso.isNotEmpty() && altura.isNotEmpty()){
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())

                startActivity(intent)
            }
        }
    }
}