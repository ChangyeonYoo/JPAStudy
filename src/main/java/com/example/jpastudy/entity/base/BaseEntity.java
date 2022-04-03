package com.example.jpastudy.entity.base;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name="is_deleted")
    protected Boolean isDeleted;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    protected Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = false)
    protected Timestamp updatedAt;

    public BaseEntity() {
        this.isDeleted = false;
    }
}
