package com.google.shinyay

import com.google.shinyay.model.Message
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.support.converter.MappingJackson2MessageConverter
import org.springframework.jms.support.converter.MessageConverter
import org.springframework.jms.support.converter.MessageType
import javax.jms.ConnectionFactory

@SpringBootApplication
@EnableJms
class SpringJmsGettingStartedApplication {
	@Bean
	fun myFactory(@Qualifier("jmsConnectionFactory") connectionFactory: ConnectionFactory,
				  configurer: DefaultJmsListenerContainerFactoryConfigurer): DefaultJmsListenerContainerFactory {
		val factory = DefaultJmsListenerContainerFactory()
		configurer.configure(factory, connectionFactory)
		return factory
	}

	@Bean
	fun jacksonJmsMessageConverter(): MessageConverter? {
		return MappingJackson2MessageConverter().apply {
			setTargetType(MessageType.TEXT)
			setTypeIdPropertyName("_type")
		}
	}
}

fun main(args: Array<String>) {
	val context =
			runApplication<SpringJmsGettingStartedApplication>(*args)
	val jmsTemplate = context.getBean(JmsTemplate::class.java)
	jmsTemplate.convertAndSend("messagebox", Message("Hello", "Hello JMS"))
}

val Any.logger: Logger
	get() = LoggerFactory.getLogger(this.javaClass)