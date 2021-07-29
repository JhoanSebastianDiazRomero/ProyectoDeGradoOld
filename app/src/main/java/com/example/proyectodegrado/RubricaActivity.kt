package com.example.proyectodegrado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectodegrado.DTO.CalificacionItemEjemplo
import com.example.proyectodegrado.DTO.CriterioItemEjemplo
import com.example.proyectodegrado.DTO.EstudianteEjemplo
import com.example.proyectodegrado.util.CalificacionesAdapter
import com.example.proyectodegrado.util.CriteriosAdapter
import com.google.android.material.imageview.ShapeableImageView

class RubricaActivity : AppCompatActivity(), CriteriosAdapter.OnItemClickListener, CalificacionesAdapter.OnItemClickListener,
    AdapterView.OnItemSelectedListener {

    var criterios = arrayOf(CriterioItemEjemplo("Criterio 1", "Hace una historia clínica completa y detallada del paciente pediátrico. Identifica y prioriza los diagnósticos diferenciales, conoce y usa adecuadamente las pruebas diagnosticas indicadas.", false),
        CriterioItemEjemplo("Criterio 2", "Toma valores antropométricos, analiza percentil; valora el estado nutricional, la alimentación, salud bucal los hábitos y practica, hace evaluación ocular,  auditiva, identificación sexual, . ", false),
        CriterioItemEjemplo("Criterio 3", "Evalúa la conformación y dinámica familiar, situaciones de vulnerabilidad. Busca e identifica señales de stress, ansiedad, depresión, riesgo de violencia, maltrato, uso de tabaco, sustancias sicoactivas.  Maneja situaciones de riesgo, educa, remite para apoyar.", false),
        CriterioItemEjemplo("Criterio 4", "El residente demuestra capacidad para diagnosticar y manejar  adecuadamente las enfermedades y situaciones clínicas frecuentes de la rotación.  Reconoce sus limitaciones y solicita ayuda. ", false),
        CriterioItemEjemplo("Criterio 5", "Se comunica adecuadamente con el paciente y familia, educa y orienta sobre el cuidado, crianza, recreación, actividad física, alimentación, salud oral, sexualidad, vacunación, etc.", false),
        CriterioItemEjemplo("Criterio 6", "El residente  es  compasivo, se preocupa por  la privacidad  y autonomía del  paciente  y su familia ", false),)

    var calificaciones = arrayOf(CalificacionItemEjemplo(0, "No lo observo", "", false, false),
        CalificacionItemEjemplo(1, "No lo hace", "", false, false),
        CalificacionItemEjemplo(2, "No esta preparado", "La información es  insuficiente, omite datos relevantes o se desvía del problema.  El examen es incompleto u omite  detalles relevantes.", false, false),
        CalificacionItemEjemplo(3, "Aceptable", "La información es completa y estructurada. Conoce e interpreta las pruebas diagnosticas esenciales.  Tiene en cuenta riesgos, beneficios y las preferencias del paciente. ", false, false),
        CalificacionItemEjemplo(4, "Lo hace bien", "", false, false),
        CalificacionItemEjemplo(5, "Ejemplar", "La información es completa, cronológica y estructurada, describe el estado del paciente y los hallazgos principales, hace un plan de estudio razonado, coherente. Conoce, prioriza e interpreta las pruebas diagnosticas,  las usa para el diagnostico, gravedad y seguimiento. Tiene en cuenta riesgos, beneficios y las preferencias del paciente.", false, false),
        CalificacionItemEjemplo(-1, "No aplica", "", false, true))

    var estudiantes = arrayOf(EstudianteEjemplo("Ana Maria Mejia", R.drawable.woman.toString()), EstudianteEjemplo("Sebastian Diaz Romero", R.drawable.man.toString()), EstudianteEjemplo("Juan Pablo Sanmiguel", R.drawable.man.toString()), EstudianteEjemplo("Carolina Acevedo Camacho", R.drawable.woman.toString()), EstudianteEjemplo("Juan Jose Melano", R.drawable.man.toString()), EstudianteEjemplo("Mariana Villa Santos", R.drawable.woman.toString()))


    private val criteriosAdapter = CriteriosAdapter(criterios, this)
    private val calificacionesAdapter = CalificacionesAdapter(calificaciones, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rubrica)

        val recyclerViewCriterios = findViewById<RecyclerView>(R.id.lista_criterios)
        recyclerViewCriterios.adapter = criteriosAdapter

        val recyclerViewCalificaciones = findViewById<RecyclerView>(R.id.lista_calificaciones)
        recyclerViewCalificaciones.adapter = calificacionesAdapter
        recyclerViewCalificaciones.layoutManager = LinearLayoutManager(this)

        val spinner : Spinner = findViewById(R.id.estudiantes)
        val nombres : List<String> = estudiantes.map { e -> e.nombre }


        val spinnerAdapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_spinner_item, nombres)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, p3: Long) {
        val foto: ShapeableImageView = findViewById(R.id.foto_estudiante)
        foto.setImageResource(estudiantes[position].foto.toInt())
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(position: Int) {
        TODO("Not yet implemented")
    }

}