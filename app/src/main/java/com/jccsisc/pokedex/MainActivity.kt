package com.jccsisc.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.jccsisc.pokedex.ui.fragments.DetailsFragment
import com.jccsisc.pokedex.ui.fragments.ListFragment
import com.jccsisc.pokedex.ui.fragments.ListFragmentDirections

class MainActivity : AppCompatActivity(), ListFragment.PokemonSelectListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onPokemonSelected(pokemonModel: PokemonModel){
        findNavController(R.id.navController).navigate(ListFragmentDirections.actionListFragmentToDetailFragmentPokemon(pokemonModel.name))
    }

}