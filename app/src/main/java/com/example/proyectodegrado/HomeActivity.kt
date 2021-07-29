package com.example.proyectodegrado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectodegrado.DTO.CursoEjemplo
import com.example.proyectodegrado.util.HomeAdapter

class HomeActivity : AppCompatActivity(), HomeAdapter.OnItemClickListener {

    val listaCursosEjemplo = arrayOf(
        CursoEjemplo("CONSTR. APLIC.MÓVILES (INGLÉS)", "202110_ISIS3510_02", "202110"),
        CursoEjemplo("BIOL. ORGANISMOS-TEO", "202110_BIOL1300_02", "202110"),
        CursoEjemplo("COMPUTACION FORENSE: DELITOS INFORMATICOS, ASPECTOS LEGALES Y EVIDENCIA DIGITAL", "202110_MSIN4206_01", "202110"),
        CursoEjemplo("DERECHOS DE AUTOR (3 CREDITOS)", "202110_DERE3210_01", "202110")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.lista_cursos)
        val adapter = HomeAdapter(listaCursosEjemplo, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, ListaRubricasActivity::class.java)
        intent.putExtra("nombreCurso", listaCursosEjemplo[position].nombreCurso)
        startActivity(intent)
    }
}