package com.example.latihansearchbar

data class Hero(
    val photo: Int,
    val name: String,
)

object DataHero {
    val photos = arrayOf(
        R.drawable.ahmad_dahlan,
        R.drawable.ahmad_yani,
        R.drawable.bung_tomo,
        R.drawable.gatot_subroto,
        R.drawable.ki_hadjar_dewantara,
        R.drawable.mohammad_hatta,
        R.drawable.sudirman,
        R.drawable.sukarno,
        R.drawable.supomo,
        R.drawable.tan_malaka,
    )
    val names = arrayOf("Ahmad Dahlan", "Ahmad Yani", "Bung Tomo", "Gatot Subroto",
        "Ki Hadjar Dewantara", "Mohammad Hatta", "Soedirman", "Soekarno", "Soepomo", "Tan Malaka"
    )
    val listHero: List<Hero>
        get() {
            val list = mutableListOf<Hero>()
            for (position in photos.indices) {
                val hero = Hero(photos[position], names[position])
                list.add(hero)
            }
            return list
        }
}
