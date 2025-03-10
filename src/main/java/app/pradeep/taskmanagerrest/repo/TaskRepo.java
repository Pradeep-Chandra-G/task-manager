package app.pradeep.taskmanagerrest.repo;

import app.pradeep.taskmanagerrest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

}
