/*
 * Class: OfficeService
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
package vn.minhht.study.springdatajpa.application.service;

import vn.minhht.study.springdatajpa.infrastructure.persistence.entity.office.Device;

public interface OfficeService {

    Device assignDevice(long deviceId, long ownerId);

    Device deviceInfo(long id);
}
