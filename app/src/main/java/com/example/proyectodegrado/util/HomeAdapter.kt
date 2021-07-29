package com.example.proyectodegrado.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectodegrado.DTO.CursoEjemplo
import com.example.proyectodegrado.R

class HomeAdapter(private val listaCursos : Array<CursoEjemplo>, private val listener: OnItemClickListener) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),  View.OnClickListener{

        val nombreCurso: TextView = itemView.findViewById(R.id.nombre_curso)
        val codigoCurso: TextView = itemView.findViewById(R.id.codigo_curso)
        val periodoCurso: TextView = itemView.findViewById(R.id.periodo_curso)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = bindingAdapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_curso, parent,false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.nombreCurso.text = listaCursos[position].nombreCurso
        holder.codigoCurso.text = listaCursos[position].codigoCurso
        holder.periodoCurso.text = listaCursos[position].periodoCurso
    }

    override fun getItemCount(): Int {
        return listaCursos.size
    }


}