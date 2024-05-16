package com.example.test

import com.example.test.config.HttpRequestDefs
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ActiveProfiles
//import javax.sql.DataSource

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class TestInitialization() {

    @Autowired
    protected lateinit var httpRequestDefs: HttpRequestDefs

//    @Autowired
//    private lateinit var dataSource: DataSource
//
//    protected val jdbcTemplate: JdbcTemplate by lazy {
//        JdbcTemplate(dataSource)
//    }

    protected var mapHeaders: MutableMap<String, String> = HashMap()

    protected val objectMapper: ObjectMapper = ObjectMapper()

}