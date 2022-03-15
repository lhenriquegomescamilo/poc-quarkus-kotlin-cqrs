package com.camilo.product.service

import com.camilo.crud.CreateService
import com.camilo.product.dto.ProductDto
import java.util.UUID
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ProductService : CreateService<ProductDto> {
    override suspend fun create(dto: ProductDto): String = UUID.randomUUID().toString()
}