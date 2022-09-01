package crm.practiceapp.spring.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crm.practiceapp.spring.dao.TasksRepository;
import crm.practiceapp.spring.entity.Task;


@Transactional
@Service
public class TaskServiceImpl implements TaskService{

	
	private TasksRepository taskRepository;
	
	@Autowired
	public TaskServiceImpl(TasksRepository theTasksRepository) {
		this.taskRepository = theTasksRepository;
	}
	
	
	@Override
	public List<Task> findAll() {
		
		List<Task> theTasks = taskRepository.findAll();
		
		return theTasks;
	}

	@Override
	public Task findById(int taskId) {
		
		Optional<Task> result = taskRepository.findById(taskId);
		
		Task theTask = null;
		if (result.isPresent()) {
			theTask = result.get();
		}
		else {
			throw new RuntimeException("Task not found! ID" + taskId);
		}
		
		return theTask;
	}

	@Override
	public void save(Task theTask) {
		taskRepository.save(theTask);
		
	}

	@Override
	public void deleteById(int taskId) {
		
		Optional<Task> theTask = taskRepository.findById(taskId);
		
		if(theTask.isPresent()) {
			taskRepository.deleteById(taskId);
		}else {
			throw new RuntimeException("Task not found! Id -" + taskId);
		}
		
		
	}

}
