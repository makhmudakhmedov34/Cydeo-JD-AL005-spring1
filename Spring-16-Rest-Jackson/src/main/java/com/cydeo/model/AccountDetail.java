package com.cydeo.model;

import com.cydeo.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "account_details")
@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = {"state","postalCode"},ignoreUnknown = true)
public class AccountDetail extends BaseEntity{

    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private Integer age;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "accountDetail")
    @JsonBackReference //is the back part of reference - it will be omitted from serialization
    private UserAccount userAccount;


}
