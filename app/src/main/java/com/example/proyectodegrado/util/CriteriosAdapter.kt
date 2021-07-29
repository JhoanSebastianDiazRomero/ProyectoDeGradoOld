package com.example.proyectodegrado.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectodegrado.DTO.CriterioItemEjemplo
import com.example.proyectodegrado.R

class CriteriosAdapter(private val listaCriterios: Array<CriterioItemEjemplo>, private val listener: CriteriosAdapter.OnItemClickListener) : RecyclerView.Adapter<CriteriosAdapter.RubricaCriteriosViewHolder>(){

    inner class RubricaCriteriosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),  View.OnClickListener{

        val nombreCriterio: TextView = itemView.findViewById(R.id.nombre_criterio)
        val descripcionCriterio: TextView = itemView.findViewById(R.id.descripcion_criterio)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RubricaCriteriosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_criterio, parent,false)
        return RubricaCriteriosViewHolder(view)
    }

    override fun onBindViewHolder(holder: RubricaCriteriosViewHolder, position: Int) {
        holder.nombreCriterio.text = listaCriterios[position].nombre
        holder.descripcionCriterio.text = listaCriterios[position].descripcion
    }

    override fun getItemCount(): Int {
        return listaCriterios.size
    }
}