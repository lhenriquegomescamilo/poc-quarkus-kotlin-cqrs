package com.camilo.crud

interface CreateService<T>  {
    suspend fun create(dto: T): String
}
