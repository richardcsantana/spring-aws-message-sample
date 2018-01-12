package br.com.richardcsantana.awssample

import br.com.richardcsantana.awssample.message.SqsQueueSender
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AwsSampleApplication {

    @Bean
    fun init(sqsQueueSender: SqsQueueSender) = CommandLineRunner {
        sqsQueueSender.send("Hello Aws World 111111!")
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(AwsSampleApplication::class.java, *args)
}
