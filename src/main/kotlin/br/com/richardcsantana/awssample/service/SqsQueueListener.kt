package br.com.richardcsantana.awssample.service


import br.com.richardcsantana.awssample.QUEUE_NAME
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Service

@Service
class SqsQueueListener {

    @SqsListener(QUEUE_NAME)
    fun queueListener(message: String) {
        println(message)
    }

}