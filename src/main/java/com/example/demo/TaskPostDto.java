package com.example.demo;

import lombok.Getter;

@Getter
public class TaskPostDto {
    private String title;
    private int todoOrder;
    private boolean completed;
}
