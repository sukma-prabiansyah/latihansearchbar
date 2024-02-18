package com.example.latihansearchbar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class HeroRepository {
    private val _listHero = MutableLiveData<List<Hero>>()
    private val _sortHero = MutableLiveData<List<Hero>>()

    fun getListHero(): LiveData<List<Hero>> {
        _listHero.value = DataHero.listHero
        return _listHero
    }

    fun searchHero(query: String): LiveData<List<Hero>> {
        val heroes = DataHero.listHero
        _sortHero.value = heroes.filter { it.name.lowercase().contains(query) }
        return _sortHero
    }
}
