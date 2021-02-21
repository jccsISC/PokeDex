package com.jccsisc.pokedex.ui.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jccsisc.pokedex.EnumsTypes
import com.jccsisc.pokedex.PokemonModel
import com.jccsisc.pokedex.R
import com.jccsisc.pokedex.databinding.ItemListPokemonBinding

class PokemonAdapter : ListAdapter<PokemonModel, PokemonAdapter.PokemonViewHolder>(DiffCallback) {

    //lambda para el click
    lateinit var onClickListener: (PokemonModel) -> Unit

    //Hacemos uso de DiffCallback pa identificar que item se agregó o borró es lo mismo siempre
    companion object DiffCallback : DiffUtil.ItemCallback<PokemonModel>() {

        override fun areItemsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean {
            return oldItem.id == newItem.id //igualamos si el item nuevo con el viejo es el mismo
        }

        override fun areContentsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean {
            return oldItem == newItem //para igualar modelos debe de ser una data class
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemListPokemonBinding.inflate(LayoutInflater.from(parent.context))
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemonModel = getItem(position)
        holder.bind(pokemonModel)
    }


    inner class PokemonViewHolder(private val binding: ItemListPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemonModel: PokemonModel) = with(binding) {
            tvId.text = pokemonModel.id.toString()
            tvPokemon.text = pokemonModel.name

            //pintar una imagen segun su  tipo
            val image = when (pokemonModel.type) {
                EnumsTypes.GRASS -> R.drawable.ic_grass
                EnumsTypes.FIRE -> R.drawable.ic_fire
                EnumsTypes.WATER -> R.drawable.ic_water_drop
                EnumsTypes.FIGTHER -> R.drawable.ic_boxing
                EnumsTypes.ELECTRIC -> R.drawable.ic_flash
            }
            imvType.setImageResource(image)

            root.setOnClickListener {
                //verificar que esté inicializado
                if (::onClickListener.isInitialized) {
                    onClickListener(pokemonModel)
                }else Log.e("error", "No se inicializó el onClickLambda")
            }
        }
    }
}