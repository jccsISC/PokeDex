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
                PokemonModel(3, "Bulbasaur", "https://cdn.bulbagarden.net/upload/thumb/1/19/Ash_Bulbasaur.png/1200px-Ash_Bulbasaur.png", 42, 40, 25, 58, EnumsTypes.GRASS),
                PokemonModel(4, "Venusaur", "https://i2.wp.com/www.korosenai.es/wp-content/uploads/2019/06/mega-venusaur-pokemon.jpg?fit=640%2C480&ssl=1", 46, 56, 95, 85, EnumsTypes.WATER),
                PokemonModel(5, "Charmander", "https://media.redadn.es/imagenes/pokemaster_338177.jpg", 38, 21, 75, 90, EnumsTypes.FIGTHER),
                PokemonModel(6, "Charizard", "https://pm1.narvii.com/6267/89193c56fc57a3647097fbf5b42023ff94e93b6b_hq.jpg", 48, 23, 45, 54, EnumsTypes.ELECTRIC),
                PokemonModel(7, "Squirtle", "https://miro.medium.com/max/302/1*KuSu6ZTyLAcRDwOsI9ZzZA.png", 56, 78, 90, 66, EnumsTypes.GRASS),
                PokemonModel(8, "Wartortle", "https://i.pinimg.com/originals/9d/7f/17/9d7f178530bda4cf910aaa15bdee11a1.png", 83, 89, 80, 99, EnumsTypes.FIGTHER),
                PokemonModel(9, "Pidgeot", "https://c0.klipartz.com/pngpicture/424/4/gratis-png-pokemon-omega-ruby-%E2%80%8B%E2%80%8By-alfa-zafiro-pidgeotto-ciclo-1-de-pokemon-pidgeot.png", 93, 99, 76, 25, EnumsTypes.WATER),
                PokemonModel(10, "Rattata", "https://vanguardia.com.mx/sites/default/files/styles/paragraph_image_large_desktop_1x/public/rattata.jpg", 21, 12, 69, 88, EnumsTypes.ELECTRIC)
            )

            adapter.submitList(listPokemon)
            adapter.notifyDataSetChanged()

            adapter.onClickListener = {
                pokemonSelectListener.onPokemonSelected(it)
            }
        }
    }
}