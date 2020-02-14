package com.example.databindingtemplate

enum class ValidCards(
    val key: Int,
    val frontImage: Int,
    val backImage: Int
) {
    E1   (1,  R.drawable.avatar_1_raster,  R.drawable.ic_launcher_foreground),
    E2   (2,  R.drawable.avatar_2_raster,  R.drawable.ic_launcher_foreground),
    E3   (3,  R.drawable.avatar_3_raster,  R.drawable.ic_launcher_foreground),
    E4   (4,  R.drawable.avatar_4_raster,  R.drawable.ic_launcher_foreground),
    E5   (5,  R.drawable.avatar_5_raster,  R.drawable.ic_launcher_foreground),
    E6   (6,  R.drawable.avatar_6_raster,  R.drawable.ic_launcher_foreground),
    E7   (7,  R.drawable.avatar_7_raster,  R.drawable.ic_launcher_foreground),
    E8   (8,  R.drawable.avatar_8_raster,  R.drawable.ic_launcher_foreground),
    E9   (9,  R.drawable.avatar_9_raster,  R.drawable.ic_launcher_foreground),
    E10   (10,R.drawable.avatar_10_raster, R.drawable.ic_launcher_foreground),
    E11   (11,R.drawable.avatar_11_raster, R.drawable.ic_launcher_foreground),
    E12   (12,R.drawable.avatar_12_raster, R.drawable.ic_launcher_foreground),
    E13   (13,R.drawable.avatar_13_raster, R.drawable.ic_launcher_foreground),
    E14   (14,R.drawable.avatar_14_raster, R.drawable.ic_launcher_foreground),
    E15   (15,R.drawable.avatar_15_raster, R.drawable.ic_launcher_foreground),
    E16   (16,R.drawable.avatar_16_raster, R.drawable.ic_launcher_foreground)
}

data class Card constructor(
    var cardtype: ValidCards,
    var flipped: Boolean  =false,
    var clickable: Boolean=true
)