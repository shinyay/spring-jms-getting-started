package com.google.shinyay

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jms.annotation.EnableJms

@SpringBootApplication
@EnableJms
class SpringJmsGettingStartedApplication

fun main(args: Array<String>) {
	runApplication<SpringJmsGettingStartedApplication>(*args)
}
val Any.logger: Logger
	get() = LoggerFactory.getLogger(this.javaClass)