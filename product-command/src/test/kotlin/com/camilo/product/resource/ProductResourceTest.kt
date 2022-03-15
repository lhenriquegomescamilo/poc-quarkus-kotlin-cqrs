package com.camilo.product.resource

import com.camilo.product.dto.ProductDto
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.apache.http.HttpStatus
import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.notNullValue
@QuarkusTest
internal class ProductResourceTest {

    @Test
    fun `it should create a product`() {
        RestAssured.given()
            .body(ProductDto(name = "Product 01", price = 10.1.toBigDecimal(), quantity = 10))
            .contentType(ContentType.JSON)
            .`when`().post("/command/products")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("productId", notNullValue())
    }
}