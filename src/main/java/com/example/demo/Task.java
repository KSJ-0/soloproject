package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor //기본 생성자 자동 생성
@AllArgsConstructor //멤버 변수들을 파라미터로 갖는 생성자 자동 생성
@Entity
//서비스 계층에서 데이터 액세스 계층과 연동되어 비즈니스 로직을 처리하기 위해
//필요한 데이터를 담는 역할을 하는 도메인 엔티티 클래스 Task
public class Task {
    @Id
    private long taskId;
    private String title;
    private int todoOrder;
    private Boolean completed;

}
