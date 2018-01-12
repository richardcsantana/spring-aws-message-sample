package br.com.richardcsantana.awssample.message

import com.amazonaws.services.sqs.AmazonSQSAsync
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class SqsQueueSender(amazonSqs: AmazonSQSAsync) {

    val queueMessagingTemplate: QueueMessagingTemplate = QueueMessagingTemplate(amazonSqs)

    fun send(message: String) {
        queueMessagingTemplate.send("physicalQueueName",
                MessageBuilder.withPayload(message).build())
    }

}