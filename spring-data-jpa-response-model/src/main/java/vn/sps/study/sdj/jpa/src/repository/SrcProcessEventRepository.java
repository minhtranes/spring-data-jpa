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
package vn.sps.study.sdj.jpa.src.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.sps.study.sdj.jpa.src.entity.SrcProcessEventEntity;
import vn.sps.study.sdj.model.PersistRange;

@Repository
public interface SrcProcessEventRepository
        extends JpaRepository<SrcProcessEventEntity, String> {

    Optional<SrcProcessEventEntity> findByPersistOrder(long persistOrder);

    @Query(nativeQuery = true, name = "findPersistRange")
    PersistRange findPersistRange1(
        @Param("fromTime") Date fromTime,
        @Param("toTime") Date toTime);
}
