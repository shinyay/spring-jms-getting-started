package com.google.shinyay.listener

import com.google.shinyay.model.Message
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class Receiver {

    @JmsListener(destination = "messagebox", containerFactory = "myFactory")
    fun receiveMessage(message: Message) {
    }
}