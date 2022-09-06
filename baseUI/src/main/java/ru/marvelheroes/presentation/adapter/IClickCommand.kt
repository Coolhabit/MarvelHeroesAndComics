package ru.marvelheroes.presentation.adapter

interface IClickCommand<T> {
    val payload: T
}
