package com.example.demo;

import org.springframework.stereotype.Component;

//Dto 클래스와 task 클래스를 서로 변환해주는 mapper 클래스 구현
@Component
public class TaskMapper {
    //taskPostDto 클래스를 task 클래스로
    public Task taskPostDtoToTask(TaskPostDto taskPostDto) {
        return new Task(0L,
                taskPostDto.getTitle(),
                taskPostDto.getTodoOrder(),
                taskPostDto.isCompleted());
    }
    //taskPatchDto 클래스를 task 클래스로
    public Task taskPatchDtoToTask(TaskPatchDto taskPatchDto) {
        return new Task(taskPatchDto.getTaskId(),
                taskPatchDto.getTitle(),
                taskPatchDto.getTodoOrder(),
                taskPatchDto.isCompleted());
    }
    //task 클래스를 taskResponseDto 클래스로
    public TaskResponseDto taskToTaskResponseDto(Task task){
        return new TaskResponseDto(task.getTaskId(),
                task.getTitle(),
                task.getTodoOrder(),
                task.getCompleted());
    }
}
