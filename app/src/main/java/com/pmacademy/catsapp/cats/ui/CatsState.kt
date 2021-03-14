package com.pmacademy.catsapp.cats.ui

import com.pmacademy.catsapp.cats.data.Cat

sealed class CatsState {
    object Loading : CatsState()
    data class Content(val cats: List<Cat>) : CatsState()
}
