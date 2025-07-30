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
@Table(name = "users")
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "username", unique = true)
    private String title;

    @NotBlank
    private String description;

    private TaskStatus status;

    private LocalDateTime createdAt;

    private boolean isDone;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
