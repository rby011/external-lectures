package study.cicdpractice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.cicdpractice.domain.entity.Visit;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitCreateRequest {
    private String visitor;
    private String message;

    public Visit toEntity() {
        return Visit.builder()
                .visitor(this.visitor)
                .message(this.message)
                .visitTime(LocalDateTime.now())
                .build();
    }
}
