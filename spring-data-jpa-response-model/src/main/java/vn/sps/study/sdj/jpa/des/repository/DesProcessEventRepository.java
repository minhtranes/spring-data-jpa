/*
 * Class: ProcessEventRepository
 *
 * Created on Oct 22, 2020
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.sps.study.sdj.jpa.des.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.sps.study.sdj.jpa.des.entity.DesProcessEventEntity;

@Repository
public interface DesProcessEventRepository
        extends JpaRepository<DesProcessEventEntity, String> {

    Optional<DesProcessEventEntity> findByPersistOrder(long persistOrder);

}
