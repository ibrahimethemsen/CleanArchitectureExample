package com.ibrahim.ethem.sen.cleanarchitectureexample.domain.mapper

interface Mapper<I,O> {
    fun map(input : I?) : O
}