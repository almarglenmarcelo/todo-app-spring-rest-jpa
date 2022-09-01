package crm.practiceapp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crm.practiceapp.spring.entity.Task;
import crm.practiceapp.spring.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

	private TaskService taskService;
	
	
	
	@Autowired
	public TaskController(TaskService theTaskService) {
		this.taskService = theTaskService;
	}
	
	@GetMapping("/tasks")
	public List<Task> getTasks() {
		
		return taskService.findAll();
	}
	
	@GetMapping("/tasks/{taskId}")
	public Task getTask(@PathVariable int taskId) {
		
		Task task = taskService.findById(taskId);
		
		return task;
	}
	
	@PostMapping("/tasks")
	public Task savetask(@RequestBody Task theTask) {
		
		theTask.setId(0);
		
		taskService.save(theTask);
		
		return theTask;
	}
	
	@PutMapping("/tasks")
	public Task updateTask(@RequestBody Task theTask) {
		
		
		taskService.save(theTask);
		
		return theTask;
	}
	
	@DeleteMapping("/tasks/{taskId}")
	public String deleteTask(@PathVariable int taskId) {
		
		taskService.deleteById(taskId);
		
		
		return "Deleted task id --" + taskId;
		 
	}
	
	
	
}
