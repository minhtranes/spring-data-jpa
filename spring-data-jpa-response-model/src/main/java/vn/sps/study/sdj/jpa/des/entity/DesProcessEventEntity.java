/*
 * Class: ProcessEventEntity
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
package vn.sps.study.sdj.jpa.des.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import vn.sps.study.sdj.jpa.src.entity.SrcProcessEventEntity;

@Entity
@Table(name = "process_event")
@Access(AccessType.PROPERTY)
public class DesProcessEventEntity implements Serializable {

    private static final long serialVersionUID = -3397623556022631687L;

    private String eventId;

    private String managementData;

    private String processingData;

    private LocalDateTime createdAt;

    private LocalDateTime lastModifiedDateTime;

    private String status;

    private String pcn;

    private String trayId;

    private String envId;

    private String parentEnvId;

    private String caseOrigin;

    private long eventTime;

    private long eventOrder;

    private Long persistOrder;

    @Column(name = "event_id")
    @Id
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Column(name = "management_data")
    public String getManagementData() {
        return managementData;
    }

    public void setManagementData(String managementData) {
        this.managementData = managementData;
    }

    @Column(name = "processing_data")
    public String getProcessingData() {
        return processingData;
    }

    public void setProcessingData(String processingData) {
        this.processingData = processingData;
    }

    @Column(name = "created_at")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "last_modified")
    public LocalDateTime getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "package_control_number")
    public String getPcn() {
        return pcn;
    }

    public void setPcn(String pcn) {
        this.pcn = pcn;
    }

    @Column(name = "tray_id")
    public String getTrayId() {
        return trayId;
    }

    public void setTrayId(String trayId) {
        this.trayId = trayId;
    }

    @Column(name = "env_id")
    public String getEnvId() {
        return envId;
    }

    public void setEnvId(String envId) {
        this.envId = envId;
    }

    @Column(name = "parent_env_id")
    public String getParentEnvId() {
        return parentEnvId;
    }

    public void setParentEnvId(String parentEnvId) {
        this.parentEnvId = parentEnvId;
    }

    @Column(name = "case_origin")
    public String getCaseOrigin() {
        return caseOrigin;
    }

    public void setCaseOrigin(String caseOrigin) {
        this.caseOrigin = caseOrigin;
    }

    @Column(name = "event_time")
    public long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime == null ? 0 : eventTime.longValue();
    }

    @Column(name = "event_order")
    public long getEventOrder() {
        return eventOrder;
    }

    public void setEventOrder(Long eventOrder) {
        this.eventOrder = eventOrder == null ? 0 : eventOrder.longValue();
    }

    @Column(name = "persist_order")
    public Long getPersistOrder() {
        return persistOrder;
    }

    public void setPersistOrder(Long persistOrder) {
        this.persistOrder = persistOrder;
    }

    public static DesProcessEventEntity from(SrcProcessEventEntity src) {
        final DesProcessEventEntity des = new DesProcessEventEntity();
        {
            des.setCaseOrigin(src.getCaseOrigin());
            des.setCreatedAt(src.getCreatedAt());
            des.setEnvId(src.getEnvId());
            des.setEventId(src.getEventId());
            des.setEventOrder(src.getEventOrder());
            des.setEventTime(src.getEventTime());
            des.setLastModifiedDateTime(src.getLastModifiedDateTime());
            des.setManagementData(src.getManagementData());
            des.setParentEnvId(src.getParentEnvId());
            des.setPcn(src.getPcn());
            des.setPersistOrder(src.getPersistOrder());
            des.setProcessingData(src.getProcessingData());
            des.setStatus(src.getStatus());
            des.setTrayId(src.getTrayId());
        }
        return des;
    }
}
