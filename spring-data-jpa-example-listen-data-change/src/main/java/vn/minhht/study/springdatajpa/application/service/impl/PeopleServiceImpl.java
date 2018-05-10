/*
 * Class: PeopleServiceImpl
 *
 * Created on Apr 7, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.minhht.study.springdatajpa.application.service.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.minhht.study.springdatajpa.application.service.PeopleService;
import vn.minhht.study.springdatajpa.infrastructure.persistence.entity.people.Department;
import vn.minhht.study.springdatajpa.infrastructure.persistence.entity.people.Employee;
import vn.minhht.study.springdatajpa.infrastructure.persistence.repository.people.DepartmentRepository;
import vn.minhht.study.springdatajpa.infrastructure.persistence.repository.people.EmployeeRepository;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @PostConstruct
    @Transactional
    protected void init() {
        Department dep=new Department();
        dep.setName("Tech");
        Employee manager=new Employee();
        {
            manager.setFirstName("Thuat");
            manager.setLastName("Bui");
        }
        dep.setManager(manager);
        departmentRepository.save(dep);
        System.out.println("Inserted ");
    }

    @Transactional
    @Override
    public Employee increaseNumberOfDevice(
        long employeeId,
        int numberOfAdditionalDevice) {

        Employee employee = employeeRepository.findOne(employeeId);
        if (employee != null) {
            employee.setNumberOfDevice(
                employee.getNumberOfDevice() + numberOfAdditionalDevice);
        }
        
        return employeeRepository.save(employee);
    }

}
