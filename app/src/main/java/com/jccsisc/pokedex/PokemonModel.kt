package com.jccsisc.pokedex

import com.jccsisc.pokedex.EnumsTypes

data class PokemonModel(
    val id: Int,
    val name: String,
    val image: String,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val type: EnumsTypes,
    val soundId: Int
    )