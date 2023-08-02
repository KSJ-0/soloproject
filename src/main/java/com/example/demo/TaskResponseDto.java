package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskResponseDto {
    private long taskId;
    private String title;
    private int todoOrder;
    private Boolean completed;

}
