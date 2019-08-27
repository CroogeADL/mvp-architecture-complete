package com.example.ui.base

interface BaseView<P : BasePresenter> {
    val presenter: P?
}