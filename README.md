# Spring JMS Getting Started with Active MQ

JMS Application with Active MQ

## Description
### Dependency
- spring-boot-starter-activemq
- activemq-broker
- jackson-databind

### JMSListener
`@JmsListener` defines;
- Destination
  - This method should listen to
- JmsListenerContainerFactory
  - The reference to create the underlying message listener container

```kotlin
@JmsListener(destination = "messagebox", containerFactory = "myFactory")
fun receiveMessage(message: Message)
```

### EnableJms
Discovering the methods annotated with `@JmsListener` and create the message listener container.

```kotlin
@SpringBootApplication
@EnableJms
class SpringJmsGettingStartedApplication
```

### DefaultJmsListenerContainerFactory
DefaultJmsListenerContainerFactoryConfigurer infrastructure provided by Spring Boot, that JmsMessageListenerContainer will be identical to the one that boot creates by default.

```kotlin
@Bean
fun myFactory(@Qualifier("jmsConnectionFactory") connectionFactory: ConnectionFactory,
              configurer: DefaultJmsListenerContainerFactoryConfigurer)
```

### JMS Tempalte
`JmsTemplate` makes it very simple to send messages to a JMS destination. 

```kotlin
val jmsTemplate = context.getBean(JmsTemplate::class.java)
	jmsTemplate.convertAndSend("destinationName", "message")
```
## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
