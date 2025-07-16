package com.devrachit.swiggy_xml_imdb.presentation.list_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.devrachit.swiggy_xml_imdb.databinding.ListScreenLayoutBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devrachit.swiggy_xml_imdb.R
import com.devrachit.swiggy_xml_imdb.domain.models.SearchResult

@AndroidEntryPoint
class ListFragment : Fragment() {
    private lateinit var binding: ListScreenLayoutBinding
    private val viewmodel: ListScreenViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel.getSearchResults("the")
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListScreenLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewmodel.uiState.collectLatest {
                   if(it.list.titles.size != 0){



                       binding.recycler.layoutManager = LinearLayoutManager(requireContext())
                       binding.recycler.adapter = ListAdapter(it.list,{ item ->
                           val action = ListFragmentDirections
                               .actionListToDetail(itemId = item.id)
                           findNavController().navigate(action)
                       })
                       binding.recycler.visibility = View.VISIBLE

                   }else {
                       binding.recycler.visibility = View.GONE
                       // Show empty state if needed
                   }
                }

            }


        }
    }
}