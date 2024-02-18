package com.example.latihansearchbar

import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: HeroRepository) : ViewModel() {

    fun getHeroes() = repository.getListHero()

    fun searchHero(query: String) = repository.searchHero(query)
}