package com.example.mapper

interface Mapper<in T, out R> {
    fun map(model: T): R
}