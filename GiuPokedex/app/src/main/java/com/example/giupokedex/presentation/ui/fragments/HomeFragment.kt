package com.example.giupokedex.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.giupokedex.common.utils.ListenerEvents
import com.example.giupokedex.common.utils.ObservableEvents
import com.example.giupokedex.databinding.FragmentHomeBinding
import com.example.giupokedex.presentation.ui.activities.HomeActivity
import com.example.giupokedex.presentation.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class HomeFragment : Fragment(), ObservableEvents, ListenerEvents, View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val viewBinding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()

    private fun randomId(): String {
        return (Random().nextInt(100)).toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewModel.getHomeSearchMeals(randomId())
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

    override fun onClick(view: View) {
        when (view.id) {

        }
    }

    override fun initListeners() {
        //TODO(quando clicar para pesquisar, chamar: onSearchRequested()
    }

    override fun initObservables() {}

    private fun initView() {}
}