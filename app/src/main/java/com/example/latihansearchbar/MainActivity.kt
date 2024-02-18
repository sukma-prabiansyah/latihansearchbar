package com.example.latihansearchbar

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihansearchbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val mainViewModel by viewModels<MainViewModel> { ViewModelFactory(HeroRepository()) }
        val heroAdapter = HeroAdapter()

        bind.rvHeroes.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            val itemDecoration =
                DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
            addItemDecoration(itemDecoration)
        }

        mainViewModel.getHeroes().observe(this) { listHero ->
            heroAdapter.submitList(listHero)
            bind.rvHeroes.adapter = heroAdapter
        }

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (bind.searchView.isShowing) {
                    bind.searchView.hide()
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }

        onBackPressedDispatcher.addCallback(this@MainActivity, onBackPressedCallback)

        with(bind) {
            searchView.setupWithSearchBar(searchBar)

            rvSearchView.layoutManager = LinearLayoutManager(this@MainActivity)
            rvSearchView.setHasFixedSize(true)

            val adapter = HeroAdapter()

            searchView
                .editText
                .setOnEditorActionListener { _, _, _ ->
                    val query = searchView.text
                    searchBar.setText(query)
                    mainViewModel.searchHero(query.toString()).observe(this@MainActivity) {
                        adapter.submitList(it)
                        rvSearchView.adapter = adapter
                    }
                    false
                }
            false
        }
    }
}