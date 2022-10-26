package com.example.email1.api.controllers;

import com.example.email1.api.entities.NotificatioDTO;
import com.example.email1.emailservice.EmailService;
import com.example.email1.entities.Student;
import com.example.email1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NotificationController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/notification")
    public ResponseEntity sendEmail(@RequestBody NotificatioDTO payLoad) {
        try {
            Student studentToSendNotification = studentService.getStudentBtId(payLoad.getContactId());
            System.out.println(studentToSendNotification);
            if (studentToSendNotification == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student not found");

            emailService.sendTo(studentToSendNotification.getEmail(), payLoad.getTitle(), payLoad.getText());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
