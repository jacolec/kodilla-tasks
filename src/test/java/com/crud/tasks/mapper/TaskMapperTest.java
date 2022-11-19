package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void testMapToTask() {
        //Given
        Task task = new Task(1L, "task1", "content1");
        TaskDto taskDto = new TaskDto(1L, "task1", "content1");

        //When
        Task testTask = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(task.getId(), testTask.getId());
        assertEquals(task.getTitle(), testTask.getTitle());
        assertEquals(task.getContent(), testTask.getContent());
    }

    @Test
    void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "task1", "content1");
        TaskDto taskDto = new TaskDto(1L, "task1", "content1");

        //When
        TaskDto testTaskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(taskDto.getId(), testTaskDto.getId());
        assertEquals(taskDto.getTitle(), testTaskDto.getTitle());
        assertEquals(taskDto.getContent(), testTaskDto.getContent());
    }

    @Test
    void testMapToTaskDtoList() {
        //Given
        Task task1 = new Task(1L, "task1", "content1");
        Task task2 = new Task(2L, "task2", "content2");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        TaskDto taskDto1 = new TaskDto(1L, "task1", "content1");
        TaskDto taskDto2 = new TaskDto(2L, "task2", "content2");
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(taskDto1);
        taskDtoList.add(taskDto2);

        //When
        List<TaskDto> testList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(taskList.get(0).getId(), testList.get(0).getId());
        assertEquals(taskList.get(0).getTitle(), testList.get(0).getTitle());
        assertEquals(taskList.get(0).getContent(), testList.get(0).getContent());
        assertEquals(taskList.get(1).getId(), testList.get(1).getId());
        assertEquals(taskList.get(1).getTitle(), testList.get(1).getTitle());
        assertEquals(taskList.get(1).getContent(), testList.get(1).getContent());

    }

}