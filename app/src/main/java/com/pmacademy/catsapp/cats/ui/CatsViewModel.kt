package com.pmacademy.catsapp.cats.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmacademy.catsapp.ResponseResult
import com.pmacademy.catsapp.cats.data.CatsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatsViewModel @Inject constructor(private val catsRepository: CatsRepository) : ViewModel() {

    private val _catsLiveData = MutableLiveData<CatsState>()
    val catsLiveData: LiveData<CatsState> = _catsLiveData

    fun loadMoreCats() {
        if (_catsLiveData.value == null) {
            _catsLiveData.value = CatsState.Loading
        }
        viewModelScope.launch {
            val downloadedCats = when (val state = _catsLiveData.value) {
                is CatsState.Content -> state.cats
                else -> emptyList()
            }
            when (val catsResponse = catsRepository.loadMore()) {
                is ResponseResult.Success -> {
                    _catsLiveData.value = CatsState.Content(downloadedCats + catsResponse.data)
                }
                is ResponseResult.Failure -> {
                    _catsLiveData.value =
                        CatsState.Error(catsResponse.error.message)
                }
            }
        }
    }
}
