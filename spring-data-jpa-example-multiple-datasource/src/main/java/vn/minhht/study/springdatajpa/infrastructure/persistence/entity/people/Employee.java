/*
 * Class: Enployee
 *
 * Created on Apr 6, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.minhht.study.springdatajpa.infrastructure.persistence.entity.people;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Access(AccessType.PROPERTY)
public class Employee implements Serializable {
    private static final long serialVersionUID = -5500276965820147203L;

    private Department department;

    private String firstName;

    private Long id;

    private String lastName;

    private Integer yearOfBirth;

    @OneToOne
    public Department getDepartment() {
        return this.department;
    }

    public String getFirstName() {
        return this.firstName;
    }

    @Id
    @SequenceGenerator(name = "employee_seq", initialValue = 1, allocationSize = 1, sequenceName = "employee_id_seq")
    @GeneratedValue(generator = "employee_seq", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Integer getYearOfBirth() {
        return this.yearOfBirth;
    }

    public void setDepartment(final Department department) {
        this.department = department;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setYearOfBirth(final Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

}
