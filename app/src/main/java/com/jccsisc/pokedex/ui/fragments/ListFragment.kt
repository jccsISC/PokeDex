package com.jccsisc.pokedex.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.jccsisc.pokedex.EnumsTypes
import com.jccsisc.pokedex.PokemonModel
import com.jccsisc.pokedex.R
import com.jccsisc.pokedex.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var bining: FragmentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bining = FragmentListBinding.bind(view)

        bining.apply {
            val adapter = PokemonAdapter()
            rvPokemons.adapter = adapter
            val listPokemon = mutableListOf<PokemonModel>(
                PokemonModel(
                    1,
                    "Pichachu",
                    "https://i.pinimg.com/originals/48/42/11/484211333de05341e3ec2738ca5805de.jpg",
                    43,
                    50,
                    75,
                    50,
                    EnumsTypes.ELECTRIC
                ),
                PokemonModel(2, "Pichachu", "", 43, 50, 75, 50, EnumsTypes.ELECTRIC),
                PokemonModel(3, "Pichachu", "", 43, 50, 75, 50, EnumsTypes.GRASS),
                PokemonModel(4, "Pichachu", "", 43, 50, 75, 50, EnumsTypes.FIGTHER),
                PokemonModel(5, "Pichachu", "", 43, 50, 75, 50, EnumsTypes.FIGTHER),
                PokemonModel(6, "Pichachu", "", 43, 50, 75, 50, EnumsTypes.ELECTRIC),
                PokemonModel(7, "Pichachu", "", 43, 50, 75, 50, EnumsTypes.ELECTRIC),
                PokemonModel(8, "Pichachu", "", 43, 50, 75, 50, EnumsTypes.ELECTRIC),
                PokemonModel(9, "Pichachu", "", 43, 50, 75, 50, EnumsTypes.ELECTRIC),
                PokemonModel(10, "Pichachu", "", 43, 50, 75, 50, EnumsTypes.ELECTRIC)
            )

            adapter.submitList(listPokemon)
            adapter.notifyDataSetChanged()

            adapter.onClickListener = {
                Toast.makeText(context, "${it.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}