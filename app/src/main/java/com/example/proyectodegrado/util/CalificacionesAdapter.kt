package com.example.proyectodegrado.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectodegrado.DTO.CalificacionItemEjemplo
import com.example.proyectodegrado.R

class CalificacionesAdapter(private val listaCalificaciones: Array<CalificacionItemEjemplo>, private val listener: CalificacionesAdapter.OnItemClickListener) : RecyclerView.Adapter<CalificacionesAdapter.RubricaCalificacionesViewHolder>(){

    inner class RubricaCalificacionesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),  View.OnClickListener{

        val puntaje: TextView = itemView.findViewById(R.id.puntaje_calificacion)
        val nombreCriterio: TextView = itemView.findViewById(R.id.nombre_calificacion)
        val descripcionCriterio: TextView = itemView.findViewById(R.id.descripcion_calificacion)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RubricaCalificacionesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_calificacion, parent,false)
        return RubricaCalificacionesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RubricaCalificacionesViewHolder, position: Int) {
        holder.puntaje.text = listaCalificaciones[position].puntaje.toString()
        holder.nombreCriterio.text = listaCalificaciones[position].titulo
        holder.descripcionCriterio.text = listaCalificaciones[position].descripcion
    }

    override fun getItemCount(): Int {
        return listaCalificaciones.size
    }
}