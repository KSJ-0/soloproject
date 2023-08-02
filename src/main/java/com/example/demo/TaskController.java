package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v5/tasks")
@Component
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    //taskservice와 taskmapper DI
    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService; //taskService 클래스를 사용하기 위해 객체 생성
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity postTask(@RequestBody TaskPostDto taskPostDto) {

        //새 task를 생성하기 위해 taskPostDto로부터 데이터 받아서
        //task 객체 생성
        //taskMapper를 이용해 taskPostDto룰 task 클래스로 변환
        Task task = taskMapper.taskPostDtoToTask(taskPostDto);

        //createTask 메서드에 task 객체 전달하여 새 task 생성
        Task response = taskService.createTask(task);

        //taskMapper클래스의 taskToTaskResponseDto 클래스를 이용해 변환
        return new ResponseEntity<>(taskMapper.taskToTaskResponseDto(response), HttpStatus.CREATED);
    }
    @PatchMapping("/{task-id}")
    public ResponseEntity patchTask(@PathVariable("task-id") long taskId,
            @RequestBody TaskPatchDto taskPatchDto) {
        taskPatchDto.setTaskId(taskId);

        //taskPatchDto 클래스의 정보를 task 클래스에 채워넣고
        Task task = taskMapper.taskPatchDtoToTask(taskPatchDto);

        //taskService 클래스의 updateTask 메서드에 파라미터로 넣어준다.
        Task response = taskService.updateTask(task);

        return new ResponseEntity<>(taskMapper.taskToTaskResponseDto(response),HttpStatus.OK);
    }
    @DeleteMapping("/{task-id}")
    public ResponseEntity deleteTask(@PathVariable("task-id") long taskId) {

        Task response = taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteTasks() {

        Task response = taskService.deleteTasks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{task-id}")
    public ResponseEntity getTask(@PathVariable("task-id") long taskId) {

        Task response = taskService.readTask(taskId);
        return new ResponseEntity<>(taskMapper.taskToTaskResponseDto(response),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTasks() {
        List<Task> tasks = taskService.readTasks();

        List<TaskResponseDto> response =
                tasks.stream()
                        .map(task->taskMapper.taskToTaskResponseDto(task))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
