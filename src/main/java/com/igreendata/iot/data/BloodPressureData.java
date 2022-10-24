package com.igreendata.iot.data;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Setter
public class BloodPressureData {
    private String firstName;
    private String lastNameName;
    private String systolic;
    private String diastolic;
    private String clinicName;
    private String dob;
    private String gender;
}
