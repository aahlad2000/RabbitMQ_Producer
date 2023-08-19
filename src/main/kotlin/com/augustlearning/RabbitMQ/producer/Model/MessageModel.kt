package com.augustlearning.RabbitMQ.producer.Model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString
import java.util.*

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
data class MessageModel(
    var messageId : String,
    var message : String,
    var date : Date
)
