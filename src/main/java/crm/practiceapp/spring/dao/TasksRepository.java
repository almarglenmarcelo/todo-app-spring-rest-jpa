package crm.practiceapp.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import crm.practiceapp.spring.entity.Task;


public interface TasksRepository extends JpaRepository<Task, Integer> {

}
