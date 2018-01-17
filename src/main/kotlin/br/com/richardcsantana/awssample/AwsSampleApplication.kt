package br.com.richardcsantana.awssample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class AwsSampleApplication

fun main(args: Array<String>) {
    SpringApplication.run(AwsSampleApplication::class.java, *args)
}

const val QUEUE_NAME: String = "queue_name"