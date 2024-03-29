package jpabasic.hellojpa;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class Period {

    //기간
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Period() {
    }
}
