package com.example.latihansearchbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class HeroAdapter : ListAdapter<Hero, HeroAdapter.HeroViewHolder>(DIFF_CALLBACK) {

    class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivHero: ImageView = itemView.findViewById(R.id.iv_hero)
        val tvHero: TextView = itemView.findViewById(R.id.tv_hero)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = getItem(position)
        holder.ivHero.setImageResource(hero.photo)
        holder.tvHero.text = hero.name
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Hero>() {
            override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
                return oldItem == newItem
            }

        }
    }
}