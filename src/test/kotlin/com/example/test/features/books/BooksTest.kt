//package com.example.test.features.todos
//
//import com.example.test.TestInitialization
//import com.example.test.dto.BookDTO
//import com.example.test.dto.TodoDTO
//import org.assertj.core.api.Assertions
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.TestInstance
//import org.springframework.http.HttpStatus
//import org.assertj.core.api.Assertions.assertThat
//import org.junit.jupiter.api.DisplayName
//import org.springframework.test.jdbc.JdbcTestUtils
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class BooksTest : TestInitialization() {
//
//	@Test
//	@DisplayName("when calling jsonplaceholder book, it should return 200 OK")
//	fun `when calling jsonplaceholder book, it should return 200 OK`() {
//
//		val responseBodyExpected = listOf(
//			BookDTO("a785089a-8e14-40e5-b7dd-b62fde21bae8","A title","An author"),
//			BookDTO("11c9b19c-9791-45ea-9d03-f5322472838f","Jurassic Park","Michael Chricton")
//		)
//
//		val response = httpRequestDefs.doGet(mapHeaders,"http://localhost:8080/books")
//		assertEquals(HttpStatus.OK, response.statusCode)
//
//		val responseBodyActual = objectMapper.readValue<List<BookDTO>>(requireNotNull(response.body).toString(),
//			objectMapper.typeFactory.constructCollectionType(List::class.java, BookDTO::class.java))
//
//		assertThat(responseBodyActual).usingRecursiveComparison().isEqualTo(responseBodyExpected)
//
////		val rowCount = JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "book", "title in ('A title', 'Jurassic Park')")
////		assertThat(rowCount).isEqualTo(2)
//	}
//}