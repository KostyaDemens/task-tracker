package by.bsuir.kostyademens.tasktrackerbackend;

import by.bsuir.kostyademens.tasktrackerbackend.dto.TaskDto;
import by.bsuir.kostyademens.tasktrackerbackend.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {

    TaskDto taskToTaskDto(Task task);
}
