package com.rabarka.lazycolumn

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Dog(
    @StringRes val nameResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
