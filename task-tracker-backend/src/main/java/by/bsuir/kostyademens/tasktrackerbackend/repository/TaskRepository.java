package by.bsuir.kostyademens.tasktrackerbackend.repository;

import by.bsuir.kostyademens.tasktrackerbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


}
