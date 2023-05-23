package com.alihmzyv.mongodbspringexample.entity;

import com.alihmzyv.mongodbspringexample.consts.Gender;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Builder
@Data
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private ZonedDateTime createdAt;
}
