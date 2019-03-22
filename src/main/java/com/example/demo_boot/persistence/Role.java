package com.example.demo_boot.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role extends BaseC {

    private String roleName;
    private boolean isActive;
    @ManyToOne(cascade = CascadeType.ALL)
    private AGroup group;

}
