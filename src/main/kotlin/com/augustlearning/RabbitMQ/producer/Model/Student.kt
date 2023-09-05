package com.augustlearning.RabbitMQ.producer.Model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
data class Student(
    var studentId : String,
    var subjectsTakenByStudent : List<String>,
    var collegeName : String,
    var date : LocalDate = LocalDateTime.now().toLocalDate()
)
