package by.bsuir.kostyademens.tasktrackerbackend.model;

import by.bsuir.kostyademens.tasktrackerbackend.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "title", unique = true)
    private String title;

    @NotBlank
    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private TaskStatus status;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "isDone")
    private boolean isDone;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
