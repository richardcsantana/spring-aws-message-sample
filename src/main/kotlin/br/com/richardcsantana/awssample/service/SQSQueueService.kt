package br.com.richardcsantana.awssample.service

import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.ListableBeanFactory
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.core.Ordered
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.util.ReflectionUtils

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class SQSQueueService(val beanFactory: ListableBeanFactory) : InitializingBean, DisposableBean {
    override fun afterPropertiesSet() {
        val sqs = AmazonSQSClientBuilder.defaultClient()
        beanFactory.beanDefinitionNames
                .map { beanFactory.getBean(it) }
                .flatMap { ReflectionUtils.getAllDeclaredMethods(it.javaClass).asIterable() }
                .flatMap { AnnotationUtils.getAnnotations(it).asIterable() }
                .filter { it is SqsListener }
                .flatMap { (it as SqsListener).value.asIterable() }
                .forEach { sqs.createQueue(it) }
    }

    override fun destroy() {

    }
}