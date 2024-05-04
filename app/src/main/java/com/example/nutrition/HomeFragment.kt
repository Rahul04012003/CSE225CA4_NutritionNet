package com.example.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nutrition.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val meals = listOf(
            Meal("Put equal quantities of frozen peas, frozen broad beans and dried couscous in a saucepan. " +
                    "Cover with boiling water and simmer for 3 minutes. Fluff up with a fork and mix in fresh mint, " +
                    "basil and plenty of black pepper.", R.drawable.meal1),
            Meal("Drain a tin of cannellini or butter beans (choose one with no added salt). " +
                    "Heat with tomato passata, and half a teaspoon of smoked paprika. " +
                    "Serve on toast, with a poached egg on top if you feel like it.", R.drawable.meal2),
            Meal("Porridge takes just a few minutes to make in a saucepan, " +
                    "and even less in a microwave. Instead of adding sugar or salt, " +
                    "scatter with a handful (80g) of fresh berries or other fruit to get one of your 5-a-day at the same time.", R.drawable.meal3),
            Meal("Hummus is surely the dip of the decade, with no self-respecting picnic or" +
                    " drinks party complete without it. It’s just as good on toast, as a sandwich " +
                    "filling or a jacket potato topping. ", R.drawable.meal4),
            Meal("A refreshing dip of yoghurt and cucumber is equally good as a dip for " +
                    "crudités or wholegrain pitta breads, or as a side dish with spicy food. " +
                    "Our recipe for cucumber raitha takes moments to make.", R.drawable.meal5)
        )

        val adapter = MealAdapter(meals)
        recyclerView.adapter = adapter

        return view
    }
}
