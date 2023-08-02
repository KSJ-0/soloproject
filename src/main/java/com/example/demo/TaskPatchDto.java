package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskPatchDto {
    private long taskId;
    private String title;
    private int todoOrder;
    private boolean completed;
}
