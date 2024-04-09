package ait.cohort34.post.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DatePeriodDto {
    LocalDate dateFrom;
    LocalDate dateTo;


}
