package com.example.proyectodegrado.util

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectodegrado.DTO.CalificarRubricaItemEjemplo
import com.example.proyectodegrado.R
import com.google.android.material.card.MaterialCardView

class RubricasAdapter(private val listaRubricas: Array<CalificarRubricaItemEjemplo>, private val listener: RubricasAdapter.OnItemClickListener) : RecyclerView.Adapter<RubricasAdapter.CalificarRubricaViewHolder>() {

    inner class CalificarRubricaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),  View.OnClickListener{

        val card: MaterialCardView = itemView.findViewById(R.id.card_rubrica)
        val nombreRubrica: TextView = itemView.findViewById(R.id.nombre_rubrica)
        val descripcion: TextView = itemView.findViewById(R.id.descripcion_rubrica)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalificarRubricaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_rubrica, parent,false)
        return CalificarRubricaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalificarRubricaViewHolder, position: Int) {
        holder.nombreRubrica.text = listaRubricas[position].nombreRubrica
        holder.descripcion.text = listaRubricas[position].descripcionRubrica

        if (listaRubricas[position].clicked){
            holder.card.setStrokeColor(Color.parseColor("#FF1C958E"))
            holder.card.strokeWidth = 10
            holder.descripcion.visibility = View.VISIBLE
        } else {
            holder.card.setStrokeColor(Color.parseColor("#FFB5B5B5"))
            holder.card.strokeWidth = 1
            holder.descripcion.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return listaRubricas.size
    }


}