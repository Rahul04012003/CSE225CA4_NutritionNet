package com.example.nutrition

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nutrition.R

class MealAdapter(private val meals: List<Meal>) : RecyclerView.Adapter<MealAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mealImage: ImageView = itemView.findViewById(R.id.mealImage)
        val mealName: TextView = itemView.findViewById(R.id.mealName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meal_tile, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = meals[position]
        holder.mealImage.setImageResource(meal.imageRes)
        holder.mealName.text = meal.name
    }

    override fun getItemCount(): Int = meals.size
}
