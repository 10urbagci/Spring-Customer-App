package com.aselsis.aselmanager.entity.abstracts;

import java.time.LocalDateTime;


public class TimeStampEntity extends BaseEntity {


    private LocalDateTime created;


    private LocalDateTime updated;


    private LocalDateTime deleted;

    //@PrePersist
    protected void onCreate() {
        updated = created = LocalDateTime.now();
    }

    // @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }

    //@PreRemove
    protected void onDelete() {
        deleted = LocalDateTime.now();
    }
}
