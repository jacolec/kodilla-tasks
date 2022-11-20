package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @MockBean
    private DbService dbService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskMapper taskMapper;

    @Test
    void testGetTasks() throws Exception {
        //Given
        when(dbService.getAllTasks()).thenReturn(List.of());

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/tasks")
                .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void testGetTask() throws TaskNotFoundException, Exception {
        //Given
        Task task = new Task(1L, "task1", "content1");
        TaskDto taskDto = new TaskDto(1L, "task1", "content1");
        when(dbService.getTask(1L)).thenReturn(task);
        when(taskMapper.mapToTaskDto(any())).thenReturn(taskDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/tasks/taskId").param("taskId", "1L")
                .content(MediaType.APPLICATION_JSON_VALUE))
                //.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1L)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("task1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("content1")));
    }
}