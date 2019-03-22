package com.example.demo_boot.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department extends BaseC {
    private String deptname;
    private String deptemail;
}
