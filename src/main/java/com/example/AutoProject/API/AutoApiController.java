package com.example.AutoProject.API;

import com.example.AutoProject.model.FormData;
import com.example.AutoProject.service.JavaMail;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class AutoApiController implements AutoAPI{

    @Autowired
    JavaMail mailSender;
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public AutoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<FormData> formPost(@Valid @RequestBody FormData data) {
        if (data.check_phone_number()) {
            String message = "\t\tNew Offer\n\n" +
                    "\tНомер телефона:" + " " + data.getPhone_number() + "\n" +
                    "\tИмя:" + " " + data.getClient_name() + "\n" +
                    "\tОписание:" + " " + data.getRemark() + "\n" +
                    "\tВремя заявки:" + " " + data.getDateTime() + "\n";
            mailSender.send_message("kostyan.kostin.61@bk.ru", "New Offer", message);
            return new ResponseEntity<FormData>(data, HttpStatus.CREATED);
        }
        return new ResponseEntity<FormData>(HttpStatus.CONFLICT);
    }
}
