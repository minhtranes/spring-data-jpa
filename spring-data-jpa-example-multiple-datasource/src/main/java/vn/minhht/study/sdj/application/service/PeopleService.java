/*
 * Class: PeopleService
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
package vn.minhht.study.sdj.application.service;

import vn.minhht.study.sdj.infrastructure.persistence.entity.people.Employee;

public interface PeopleService {

    Employee increaseNumberOfDevice(
        long employeeId,
        int numberOfAdditionalDevice);
}
