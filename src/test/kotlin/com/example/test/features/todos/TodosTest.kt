package com.example.test.features.todos

import com.example.test.TestInitialization
import com.example.test.dto.TodosDTO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.http.HttpStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TodosTest : TestInitialization() {

	@Test
	@DisplayName("when calling jsonplaceholder todo, it should return 200 OK")
	fun `when calling jsonplaceholder todos, it should return 200 OK`() {

		val responseBodyExpected = TodosDTO(1, 1, "delectus aut autem", false)

		val response = httpRequestDefs.doGet(mapHeaders,"https://jsonplaceholder.typicode.com/todos/1")
		assertEquals(HttpStatus.OK, response.statusCode)

		val responseBodyActual = objectMapper.readValue(requireNotNull(response.body).toString(),
			TodosDTO::class.java)


		assertThat(responseBodyActual).usingRecursiveComparison().isEqualTo(responseBodyExpected)
	}
}