package com.nikhil.sandwichclubproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikhil.sandwichclubproject.data.model.Sandwich
import com.nikhil.sandwichclubproject.data.repository.SandwichRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SandwichViewModel @Inject constructor(private val repository: SandwichRepository) : ViewModel() {

    private val _sandwichList = MutableStateFlow<List<Sandwich>>(emptyList())
    val sandwichList: StateFlow<List<Sandwich>> = _sandwichList.asStateFlow()

    init {
        fetchSandwiches()
    }

    private fun fetchSandwiches() {
        viewModelScope.launch {
            repository.getSandwichList().collect { sandwiches ->
                _sandwichList.value = sandwiches
            }
            //repository.getSandwichListFromAssets().collect { sandwiches ->
            //   _sandwichList.value = sandwiches
            //}
        }
    }
}