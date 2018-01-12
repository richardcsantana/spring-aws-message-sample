package br.com.richardcsantana.awssample.message

import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Service

@Service
class SqsQueueListener {

    @SqsListener("physicalQueueName")
    fun queueListener(message: String) {
        println(message)
    }
}