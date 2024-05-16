package com.example.demo

import com.example.demo.config.HttpRequestDefs
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class TestInitialization() {

    @Autowired
    protected lateinit var httpRequestDefs: HttpRequestDefs

    protected var mapHeaders: MutableMap<String, String> = HashMap()

    protected val objectMapper: ObjectMapper = ObjectMapper()
}