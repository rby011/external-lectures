package study.cicdpractice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Visit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String visitor;
    private String message;

    private LocalDateTime visitTime;
}
