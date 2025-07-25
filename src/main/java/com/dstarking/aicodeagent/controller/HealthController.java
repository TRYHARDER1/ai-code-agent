package com.dstarking.aicodeagent.controller;

import com.dstarking.aicodeagent.common.BaseResponse;
import com.dstarking.aicodeagent.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/health")
public class HealthController {
    // This class is currently empty, but it can be used to implement health check endpoints
    // in the future if needed. For now, it serves as a placeholder.

    // Example of a potential health check method:
     @GetMapping("/health")
     public BaseResponse<String> healthCheck() {
         return ResultUtils.success("Service is up and running");
     }
}
