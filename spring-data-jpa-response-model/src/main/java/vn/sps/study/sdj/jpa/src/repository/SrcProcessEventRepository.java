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

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import vn.sps.study.sdj.jpa.src.entity.SrcProcessEventEntity;
import vn.sps.study.sdj.model.PersistR;

@Repository
public interface SrcProcessEventRepository
        extends JpaRepository<SrcProcessEventEntity, String> {

    Optional<SrcProcessEventEntity> findByPersistOrder(long persistOrder);

    @Query(nativeQuery = true)
    PersistR findPersistRange(
        @Param("fromTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fromTime,
        @Param("toTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime toTime);

    @Query
    PersistR lookForPersistRange(
        @Param("fromTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fromTime,
        @Param("toTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime toTime);
}
