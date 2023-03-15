package com.sebure.springcommonauth.entity.base;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
//@ToString(callSuper = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity extends BaseTimeEntity {

//    @Column(name="created_by", nullable = false, updatable = false, columnDefinition = "varchar(255) default anonymous")
//    @CreatedBy
    protected String createdBy;

//    @Column(name="modified_by")
//    @LastModifiedBy
    protected String modifiedBy;

    public BaseEntity(LocalDateTime createdDate, LocalDateTime modifiedDate, String createdBy, String modifiedBy) {
        super(createdDate, modifiedDate);
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }
}
