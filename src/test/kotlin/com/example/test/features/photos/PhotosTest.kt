package com.example.test.features.photos

import com.example.test.TestInitialization
import com.example.test.dto.PhotoDTO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.http.HttpStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PhotosTest : TestInitialization() {

	@Test
	@DisplayName("when calling jsonplaceholder photos, it should return 200 OK")
	fun `when calling jsonplaceholder photos, it should return 200 OK`() {

		val responseExpected =  PhotoDTO(1, 1, "accusamus beatae ad facilis cum similique qui sunt",
			"https://via.placeholder.com/600/92c952", "https://via.placeholder.com/150/92c952")

		val response = httpRequestDefs.doGet(mapHeaders,"https://jsonplaceholder.typicode.com/photos/1")
		assertEquals(HttpStatus.OK, response.statusCode)

		val responseActual = objectMapper.readValue(requireNotNull(response.body).toString(),
			PhotoDTO::class.java)

		assertThat(responseActual).usingRecursiveComparison().isEqualTo(responseExpected)
	}
}