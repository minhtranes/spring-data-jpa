/*
 * Class: ManagementController
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
package vn.minhht.study.sdj.presentation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.minhht.study.sdj.application.service.OfficeService;
import vn.minhht.study.sdj.application.service.PeopleService;

@RestController
@RequestMapping("/management")
public class ManagementController {

    @Autowired
    private OfficeService officeService;

    @Autowired
    private PeopleService peopleService;

    @Transactional
    @PostMapping("/equip/device/{deviceId}/{employeeId}")
    public String equipDevice(
        @PathVariable(name = "deviceId") Long deviceId,
        @PathVariable(name = "employeeId") Long employeeId) {

        officeService.assignDevice(deviceId, employeeId);
        peopleService.increaseNumberOfDevice(employeeId, 1);

        return "done";
    }

}
