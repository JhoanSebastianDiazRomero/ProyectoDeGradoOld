package com.example.proyectodegrado

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {

    lateinit var btnIngresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnIngresar = findViewById(R.id.btn_ingresar)
        btnIngresar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                irAHome()
            }
        })
    }

    fun irAHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}