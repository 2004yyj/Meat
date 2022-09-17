package com.example.meat.drawable

import androidx.annotation.DrawableRes
import com.example.meat.R

sealed class DrawableResources(@DrawableRes val id: Int) {
    object OutlinedHeart: DrawableResources(R.drawable.ic_outlined_heart)
    object SolidHeart: DrawableResources(R.drawable.ic_solid_heart)
}
