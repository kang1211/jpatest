package com.example.jpatest.entity;

import lombok.Getter;
import lombok.Setter;
import com.example.jpatest.dto.SchedulerDto;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Scheduler {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member schedulerMemberId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String departureHour;
    @Column
    private String departureMinute;
    @Column
    private String arrivalHour;
    @Column
    private String arrivalMinute;
    @Column
    private String trip_duration_start;
    @Column
    private String trip_duration_end;
    @Column
    private String localIds;
    @Column
    private String spotIds;
    @Column
    private String stayIds;
    @Column
    private String spotMarks;
    @Column
    private String stayMarks;



    public static Scheduler createScheduler(SchedulerDto schedulerDto, Member member) {
        Scheduler scheduler = new Scheduler();
        scheduler.setArrivalHour(schedulerDto.getArrivalHour());
        scheduler.setArrivalMinute(schedulerDto.getArrivalMinute());
        scheduler.setDepartureHour(schedulerDto.getDepartureHour());
        scheduler.setDepartureMinute(schedulerDto.getDepartureMinute());
        scheduler.setTrip_duration_start(schedulerDto.getTrip_duration_start());
        scheduler.setTrip_duration_end(schedulerDto.getTrip_duration_end());
        scheduler.setSchedulerMemberId(member); // Set the member for the scheduler
        return scheduler;
    }

}