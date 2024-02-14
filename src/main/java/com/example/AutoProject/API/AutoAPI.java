package com.example.AutoProject.API;

import com.example.AutoProject.model.FormData;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Validated
public interface AutoAPI {

    @PostMapping(value="/form", consumes = { "application/json" })
    ResponseEntity<FormData> formPost(@Valid @RequestBody FormData data);
}
