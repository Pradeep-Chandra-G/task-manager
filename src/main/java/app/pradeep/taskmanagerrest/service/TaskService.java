package app.pradeep.taskmanagerrest.service;

import app.pradeep.taskmanagerrest.repo.TaskRepo;
import org.springframework.stereotype.Service;
import app.pradeep.taskmanagerrest.model.Task;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepo taskRepo;


    public TaskService(TaskRepo taskRepo){
        this.taskRepo = taskRepo;

    }

    public List<Task> getTasks(){
        return taskRepo.findAll();
    }

    public Task getTask(Long id){
        return taskRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("A task with this ID doesn't exist!"));
    }

    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    public Task updateTask(Long id, Task x) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("A task with this ID doesn't exist!"));
        task.setTitle(x.getTitle());
        task.setDescription(x.getDescription());
        task.setStatus(x.getStatus());
        task.setCreatedDate(x.getCreatedDate());
        return taskRepo.save(task);
    }

    public void deleteTask(Long id){
        taskRepo.deleteById(id);
    }

}
