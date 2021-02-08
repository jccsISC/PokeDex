package com.jccsisc.pokedex.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jccsisc.pokedex.R
import com.jccsisc.pokedex.databinding.FragmentDetailsBinding
import com.jccsisc.pokedex.databinding.FragmentListBinding


class DetailsFragment : Fragment(R.layout.fragment_details) {
    private lateinit var bining: FragmentDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bining = FragmentDetailsBinding.bind(view)


    }
}