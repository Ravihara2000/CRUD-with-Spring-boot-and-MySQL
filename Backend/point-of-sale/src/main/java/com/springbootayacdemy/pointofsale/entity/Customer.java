package com.springbootayacdemy.pointofsale.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;


@Entity
@Table(name="customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @Column(name="customer_id",length =45)
    @GeneratedValue(strategy = GenerationType.AUTO)//auto genrate Ids
    private int customerId;
    @Column(name="customer_name", length = 100,nullable = true)
    private String customerName;

    @Column(name="customer_address", length = 300)
    private String customerAddress;

    @Column(name="customer_salary")
    private double salary;


    @Column(name="contact_no")
    private int contactNumber;

    @Column(name="nic")
    private String nic;

    @Column(name="active_status",columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy = "customers")
    private Set<Order> orders;


}
