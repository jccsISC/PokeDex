package com.jccsisc.pokedex.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.jccsisc.pokedex.MainActivity
import com.jccsisc.pokedex.R
import com.jccsisc.pokedex.databinding.FragmentDetailPokemonBinding
import com.jccsisc.pokedex.databinding.FragmentDetailsBinding


class DetailFragmentPokemon : Fragment(R.layout.fragment_detail_pokemon) {
    private lateinit var binding: FragmentDetailPokemonBinding
    private val args: DetailFragmentPokemonArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentDetailPokemonBinding.bind(view)
        super.onViewCreated(binding.root, savedInstanceState)

        val nameToolbar = args.namePokemon


    }
}