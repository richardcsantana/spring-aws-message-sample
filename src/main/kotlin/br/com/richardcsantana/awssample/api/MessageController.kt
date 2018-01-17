package br.com.richardcsantana.awssample.api

import br.com.richardcsantana.awssample.service.SqsQueueSender
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/message"])
class MessageController(val sqsQueueSender: SqsQueueSender) {

    @PostMapping
    fun sendMessage(@RequestBody message: String) {
        sqsQueueSender.send(message)
    }

}