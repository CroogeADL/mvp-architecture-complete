package com.example.common

import android.content.Context

const val DEFAULT_ERROR_MESSAGE = "Sorry, something went wrong."

fun Throwable?.getErrorMessage() = this?.message ?: DEFAULT_ERROR_MESSAGE

fun Context.convertToPx(dp: Float) = dp * resources.displayMetrics.density

fun Context.convertToDp(px: Float) = px / resources.displayMetrics.density