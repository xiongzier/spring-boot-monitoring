package com.example.springbootmonitoring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping
    public ResponseEntity<String> getStudentInfo() {
        // 此处返回学生信息
        String studentInfo = "学生信息：姓名-张三，年龄-20";
        return ResponseEntity.ok(studentInfo);
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody String requestBody) {
        // 此处处理添加学生信息的逻辑
        return ResponseEntity.ok("学生信息已添加");
    }
    @GetMapping("/invalid")
    public ResponseEntity<String> invalidAccess() {
        // 模拟非法用户访问，抛出异常
        throw new RuntimeException("非法用户访问");
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        // 处理非法用户访问的情况，返回401状态码和错误信息"invalid user"
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid user");
    }
}
