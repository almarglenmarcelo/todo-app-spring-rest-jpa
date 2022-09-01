package crm.practiceapp.spring.service;

import java.util.List;

import crm.practiceapp.spring.entity.Task;

public interface TaskService {

	public List<Task> findAll();
	
	public Task findById(int taskId);
	
	public void save(Task theTask);
	
	public void deleteById(int taskId);
	
}
