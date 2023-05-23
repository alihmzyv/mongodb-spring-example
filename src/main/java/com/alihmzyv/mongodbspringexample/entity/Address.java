package com.alihmzyv.mongodbspringexample.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document
public class Address {
    private String country;
    private String city;
    private String postCode;
}
