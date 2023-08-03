package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Id;
import java.util.Optional;

@Getter
@Setter
public class TaskPatchDto {
    private long taskId;
    private String title;
    private int todoOrder;
    private boolean completed;
}
