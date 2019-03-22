package com.example.demo_boot.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TypeService extends BaseC {
    private String serviceName;
    private String serviceHost;
}
