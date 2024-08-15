package com.user.ms.external.service;

import com.user.ms.dto.EmailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "NOTIFICATIONS-MS/api/email")
public interface INotificationServiceFeingn {
    @PostMapping("/send")
    ResponseEntity<String> sendEmail(@RequestBody EmailDTO emailDTO);
}
