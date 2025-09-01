package com.nt.model;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
//@Table(name="emp")
@Table(name = "boot_emp")
@SQLDelete(sql = "UPDATE boot_emp SET status='deleted' WHERE empno=?")
@Where(clause = "status <> 'deleted'")
public class Employee implements Serializable {

    @Id
    @SequenceGenerator(name = "gen1", sequenceName = "emp_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
    private Integer empno;

    private String ename;
    private String job = "clrk";
    private Double sal;
    private String status = "active";

}
