package com.example.proyectodegrado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectodegrado.util.RubricasAdapter
import com.example.proyectodegrado.DTO.CalificarRubricaItemEjemplo

class ListaRubricasActivity : AppCompatActivity(),  RubricasAdapter.OnItemClickListener{

    private var hayUnaClickeada = false
    lateinit var btnCalificar: Button

    private val LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus nunc mauris, gravida ac ultricies at, rutrum sed turpis. Sed a bibendum orci. Praesent a posuere augue. Morbi feugiat, neque non molestie egestas, odio leo consequat est, a molestie magna metus eget erat. Nullam laoreet dictum arcu, id luctus erat tempus nec. Sed urna neque, ornare mattis dolor vel, congue sagittis diam. Nunc pretium, sapien at lacinia bibendum, ligula erat aliquam nibh, ut aliquet justo ex at ante. Proin commodo diam ligula, quis scelerisque dolor facilisis a. Nulla a quam rutrum erat ornare auctor. In orci augue, accumsan vitae leo at, dapibus volutpat enim. "
    private val rubricasEjemplo = arrayOf(
        CalificarRubricaItemEjemplo("Consulta Observada", "Desempeno del residente en rotacion de consulta externa"),
        CalificarRubricaItemEjemplo("Concepto Enfermeria", "A continuacion encontrara la rubrica de evaluacion para solicitar el concepto a \"ENFERMERAS Y PERSONAL NO MEDICO\" sobre el comportamiento del residente en su sitio de trabajo. Por favor lea el item, luego senale el grado de desarrollo en que se encuentra el residente"),
        CalificarRubricaItemEjemplo("Concepto Enfermeria 2", "A continuacion encontrara la rubrica de evaluacion para solicitar el concepto a \"ENFERMERAS Y PERSONAL NO MEDICO\" sobre el comportamiento del residente en su sitio de trabajo. Por favor lea el item, luego senale el grado de desarrollo en que se encuentra el residente"),
        CalificarRubricaItemEjemplo("Concepto Paciente", LOREM_IPSUM),
        CalificarRubricaItemEjemplo("Concepto Paciente 2", LOREM_IPSUM),
        CalificarRubricaItemEjemplo("Desempeño general de la rotación EV1", "Le pedimos el ffavor lea el item y lo compare con la definicion de logro maximo a alcanzar (5), luego senale el grado de desarrollo en el que usted considera se encuentra el residente"),
        CalificarRubricaItemEjemplo("Desempeño general de la rotación EV2", "Le pedimos el ffavor lea el item y lo compare con la definicion de logro maximo a alcanzar (5), luego senale el grado de desarrollo en el que usted considera se encuentra el residente"),
        CalificarRubricaItemEjemplo("Revista Observada EV1", "Rubrica de valoracion del desempeno en la atencion del paciente (REVISTA MEDICA)"),
        CalificarRubricaItemEjemplo("Revista Observada EV2", "Rubrica de valoracion del desempeno en la atencion del paciente (REVISTA MEDICA)"),
        CalificarRubricaItemEjemplo("Mini CEX", "MiniCEX completo")
    )

    private val adapter = RubricasAdapter(rubricasEjemplo, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calificar_rubrica)

        val nombreCurso: TextView = findViewById(R.id.titulo_rubricas)
        nombreCurso.text = intent.getStringExtra("nombreCurso").toString()

        val recyclerView = findViewById<RecyclerView>(R.id.lista_rubricas)

        btnCalificar = findViewById(R.id.btn_calificar)
        btnCalificar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                calificarRubrica()
            }
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    fun calificarRubrica() {
        val intent = Intent(this, RubricaActivity::class.java)
        startActivity(intent)
    }

    override fun onItemClick(position: Int) {

        if (hayUnaClickeada) {
            rubricasEjemplo.forEach { e -> e.clicked = false }
            hayUnaClickeada = false
        }

        val clickedItem = rubricasEjemplo[position]
        clickedItem.clicked = true
        hayUnaClickeada = true
        adapter.notifyDataSetChanged()
    }

}