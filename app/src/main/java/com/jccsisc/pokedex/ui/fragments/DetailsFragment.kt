package com.jccsisc.pokedex.ui.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.jccsisc.pokedex.PokemonModel
import com.jccsisc.pokedex.R
import com.jccsisc.pokedex.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso


class DetailsFragment : Fragment(R.layout.fragment_details) {
    private lateinit var bining: FragmentDetailsBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bining = FragmentDetailsBinding.bind(view)
        super.onViewCreated(bining.root, savedInstanceState)

    }

    fun setPokemonData(pokemonModel: PokemonModel) {
        bining.apply {

            progress.visibility = View.VISIBLE

            Picasso.get().load("no es nada").
                .fit()
                .error(R.drawable.ic_error_image)
                .error(R.drawable.ic_error_image)
                .centerInside()
                .into(imvPokemon)

            tvHp.text = getString(R.string.hp_format, pokemonModel.hp)
            tvAttack.text = getString(R.string.attack_format, pokemonModel.attack)
            tvDefense.text = getString(R.string.defense_format, pokemonModel.defense)
            tvSpeed.text = getString(R.string.speed_format, pokemonModel.speed)
        }
    }
}