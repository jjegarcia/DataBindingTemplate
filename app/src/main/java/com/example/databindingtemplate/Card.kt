package com.example.databindingtemplate

data class Card constructor(
    val key: Int,
    val frontImage: frontImages,
    val backImage: backImages,
    var flipped: Boolean,
    var clickable: Boolean = true


//    val imageResId: Int,
//    var isUncover: Boolean = false,
//    var match: Boolean = false
)
