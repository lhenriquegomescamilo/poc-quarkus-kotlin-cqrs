package com.camilo.product.resource

import com.camilo.crud.CreateService
import com.camilo.product.dto.ProductDto
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@Path("/command/products")
@Produces(MediaType.APPLICATION_JSON)
class ProductResource(private val createProductService: CreateService<ProductDto>) {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    suspend fun create(product: ProductDto): Response =
        createProductService.create(product).let { Response.ok(mapOf("productId" to it)).build() }
}