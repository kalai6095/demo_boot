package com.example.demo_boot.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AGroup extends BaseC {
    private String agroupName;
    private boolean isActive;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<Role> roles;
}

