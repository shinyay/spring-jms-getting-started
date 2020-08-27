package com.google.shinyay

import com.google.shinyay.model.Message
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.core.JmsTemplate

@SpringBootApplication
@EnableJms
class SpringJmsGettingStartedApplication

fun main(args: Array<String>) {
	val context =
			runApplication<SpringJmsGettingStartedApplication>(*args)
	val jmsTemplate = context.getBean(JmsTemplate::class.java)
	jmsTemplate.convertAndSend("message", Message("Hello", "Hello JMS"))
}
val Any.logger: Logger
	get() = LoggerFactory.getLogger(this.javaClass)