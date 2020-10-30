/*
 * Class: OfficeServiceImpl
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
package vn.minhht.study.sdj.application.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.minhht.study.sdj.application.service.OfficeService;
import vn.minhht.study.sdj.infrastructure.persistence.entity.office.Device;
import vn.minhht.study.sdj.infrastructure.persistence.repository.office.DeviceRepository;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device deviceInfo(long id) {
        return deviceRepository.findOne(id);
    }

    @Override
    @Transactional
    public Device assignDevice(long deviceId, long ownerId) {
        Device device = deviceRepository.findOne(deviceId);
        if (device != null) {
            device.setOwnedBy(ownerId);
        }
        return deviceRepository.save(device);
    }

}
