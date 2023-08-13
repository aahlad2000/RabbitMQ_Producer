package com.augustlearning.RabbitMQ.producer.Config

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean


class MessagingQueueConfig {
    companion object MessagingQueueConfig{
        const val QUEUE = "message_queue"
        const val EXCHANGE = "message_exchange"
        const val ROUTING_KEY = "message_routingKey"
    }


    @Bean
    fun queue(): Queue {
        return Queue(QUEUE)
    }

    @Bean
    fun exchange() : TopicExchange{
        return TopicExchange(EXCHANGE)
    }

    @Bean
    fun binding(queue: Queue, exchange: TopicExchange): Binding{
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY)
    }

    @Bean
    fun template(connectionFactory: ConnectionFactory) : AmqpTemplate{
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = messageConverter()
        return rabbitTemplate
    }

    @Bean
    fun messageConverter() : MessageConverter {
        return Jackson2JsonMessageConverter();
    }
}
