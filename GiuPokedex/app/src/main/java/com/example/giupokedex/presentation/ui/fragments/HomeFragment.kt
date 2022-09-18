package com.example.giupokedex.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giupokedex.common.utils.ListenerEvents
import com.example.giupokedex.common.utils.ObservableEvents
import com.example.giupokedex.databinding.FragmentHomeBinding
import com.example.giupokedex.domain.models.pokeapi_co.ListPokemon
import com.example.giupokedex.domain.models.pokeapi_co.PokemonResult
import com.example.giupokedex.presentation.eventclick.EventClickItemPokemon
import com.example.giupokedex.presentation.ui.activities.HomeActivity
import com.example.giupokedex.presentation.ui.adapters.PokemonListAdapter

class HomeFragment : Fragment(), ObservableEvents, ListenerEvents {

    private var _binding: FragmentHomeBinding? = null
    private val viewBinding get() = _binding!!

    private var searchPokemonList: ArrayList<PokemonResult> = arrayListOf()
    private var homePokemonListAdapter = PokemonListAdapter(searchPokemonList = searchPokemonList)
    private var page = 0

    lateinit var homeActivity: HomeActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivity = (activity as HomeActivity)
        homeActivity.getListPokemons(page)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservables()
        initListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initView() {
        homeActivity.showHideProgressBar(true)
        viewBinding.recyclerViewPokemons.adapter = homePokemonListAdapter
    }

    override fun initObservables() {
        homeActivity.homeViewModel.getListPokemonLiveData.observe(
            viewLifecycleOwner
        ) { handleList(it) }

        homePokemonListAdapter.eventClickItemPokemon = object : EventClickItemPokemon {
            override fun onClickItemPokemon(query: String) {
                findNavController().navigate(
                    HomeFragmentDirections.actionFragmentHomeToPokemonDetailFragment(query)
                )
            }
        }
    }

    override fun initListeners() {
        viewBinding.recyclerViewPokemons.apply {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    if (dy > 0) {
                        if (!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                            homeActivity.showHideProgressBar(true)
                            (layoutManager as GridLayoutManager).scrollToPosition(searchPokemonList.size - 1)
                            homeActivity.getListPokemons(++page)
                        }
                    }
                }
            })
        }
    }

    private fun handleList(list: ListPokemon) {
        homePokemonListAdapter.updateList(ArrayList(list.results))
        homeActivity.showHideProgressBar(false)
    }
}