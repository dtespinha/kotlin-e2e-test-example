package com.example.test.config

import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.*
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpStatusCodeException

@Component
class HttpRequestDefs(private val restTemplate: TestRestTemplate) {


    fun doGet(headers: Map<String, String>, url: String): ResponseEntity<*> {
        return doRequest(headers, url, HttpMethod.GET, "")
    }

    fun doPost(headers: Map<String, String>, url: String, payload: String): ResponseEntity<*> {
        return doRequest(headers, url, HttpMethod.POST, payload)
    }

    fun doPut(headers: Map<String, String>, url: String, payload: String): ResponseEntity<*> {
        return doRequest(headers, url, HttpMethod.PUT, payload)
    }

    fun doDelete(headers: Map<String, String>, url: String): ResponseEntity<*> {
        return doRequest(headers, url, HttpMethod.DELETE, "")
    }

    private fun doRequest(headers: Map<String, String>, url: String, httpMethod: HttpMethod, payload: String): ResponseEntity<*> {
        try {
            val httpHeaders: HttpHeaders = HttpHeaders()
            httpHeaders.setContentType(MediaType.APPLICATION_JSON)
            headers.forEach(httpHeaders::addIfAbsent)
            val httpEntity: HttpEntity<String> = HttpEntity(payload, httpHeaders)
            return restTemplate.exchange(url, httpMethod, httpEntity, String::class.java)
        } catch (ex: HttpStatusCodeException) {
            return ResponseEntity.status(ex.statusCode).build<Any>()
        }
    }

}