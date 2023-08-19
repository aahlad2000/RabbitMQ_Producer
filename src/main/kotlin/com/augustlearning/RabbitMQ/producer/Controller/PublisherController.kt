package com.augustlearning.RabbitMQ.producer.Controller

import com.augustlearning.RabbitMQ.producer.Config.MessagingQueueConfig
import com.augustlearning.RabbitMQ.producer.Model.MessageModel
import kotlinx.coroutines.runBlocking
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api")
class PublisherController(var template : RabbitTemplate) {

    @PostMapping("publish")
    fun publishMessage(@RequestBody messageModel: MessageModel) : String = runBlocking {
        messageModel.messageId = UUID.randomUUID().toString()
        messageModel.message = "Message"
        template.convertAndSend(MessagingQueueConfig.EXCHANGE,MessagingQueueConfig.ROUTING_KEY, messageModel)
        return@runBlocking "Message Published"
    }

}