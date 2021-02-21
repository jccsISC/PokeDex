package com.jccsisc.pokedex.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.jccsisc.pokedex.EnumsTypes
import com.jccsisc.pokedex.MainActivity
import com.jccsisc.pokedex.PokemonModel
import com.jccsisc.pokedex.R
import com.jccsisc.pokedex.databinding.FragmentListBinding
import java.lang.ClassCastException

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var bining: FragmentListBinding

    //interfaz para pasar datos del pokemon
    interface PokemonSelectListener {
        fun onPokemonSelected(pokemonModel: PokemonModel)
    }

    //variable de tipo interfaz
    private lateinit var pokemonSelectListener: PokemonSelectListener

    //le decimos al activity que use este fragment que debe de implementar PokemonSelectListener para su uso sino truena
    override fun onAttach(context: Context) {
        super.onAttach(context)
        pokemonSelectListener = try {
            context as PokemonSelectListener
        }catch (e: ClassCastException) {
            throw ClassCastException("$context must implement PokemonSelectListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bining = FragmentListBinding.bind(view)

        bining.apply {
            val adapter = PokemonAdapter()
            rvPokemons.adapter = adapter
            val listPokemon = mutableListOf<PokemonModel>(
                PokemonModel(1, "Pichachu", "https://i.pinimg.com/originals/48/42/11/484211333de05341e3ec2738ca5805de.jpg", 43, 50, 75, 50, EnumsTypes.ELECTRIC),
                PokemonModel(2, "Pichachu", "", 43, 50, 70, 50, EnumsTypes.WATER),
                PokemonModel(3, "Bulbasaur", "", 42, 40, 25, 58, EnumsTypes.GRASS),
                PokemonModel(4, "Venusaur", "", 46, 56, 95, 85, EnumsTypes.WATER),
                PokemonModel(5, "Charmander", "", 38, 21, 75, 90, EnumsTypes.FIGTHER),
                PokemonModel(6, "Charizard", "", 48, 23, 45, 54, EnumsTypes.ELECTRIC),
                PokemonModel(7, "Squirtle", "", 56, 78, 90, 66, EnumsTypes.GRASS),
                PokemonModel(8, "Wartortle", "", 83, 89, 80, 99, EnumsTypes.FIGTHER),
                PokemonModel(9, "Pidgeot", "", 93, 99, 76, 25, EnumsTypes.WATER),
                PokemonModel(10, "Rattata", "", 21, 12, 69, 88, EnumsTypes.ELECTRIC)
            )

            adapter.submitList(listPokemon)
            adapter.notifyDataSetChanged()

            adapter.onClickListener = {
                pokemonSelectListener.onPokemonSelected(it)
            }
        }
    }
}