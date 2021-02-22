package com.jccsisc.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jccsisc.pokedex.ui.fragments.DetailsFragment
import com.jccsisc.pokedex.ui.fragments.ListFragment

class MainActivity : AppCompatActivity(), ListFragment.PokemonSelectListener {
    private lateinit var fragmentDetailsFragment: DetailsFragment
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //para mandar llamar el fragment details
        fragmentDetailsFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentDetails) as DetailsFragment


    }


    override fun onPokemonSelected(pokemonModel: PokemonModel){
        fragmentDetailsFragment.setPokemonData(pokemonModel)
        title = pokemonModel.name
    }
}