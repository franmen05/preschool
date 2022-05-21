package com.preschool.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.Instant;

/**
 * @author franm
 * @since 2021
 */
@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final Boolean DEFAULT_IS_DELETE = false;
    public static final Boolean DEFAULT_IS_ACTIVE = true;

//    @CreatedBy
    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
//    @JsonIgnore
    private String createdBy;

//    @CreatedDate
    @Column(name = "created_date", updatable = false)
//    @JsonIgnore
    private Instant createdDate;

//    @LastModifiedBy
    @Column(name = "updated_by", length = 50)
//    @JsonIgnore
    private String updatedBy;

//    @LastModifiedDate
    @Column(name = "updated_date")
//    @JsonIgnore
    private Instant updatedDate = Instant.now();


    @Column(name = "is_active")
    private Boolean isActive;



    @PrePersist
    private void prePersist(){
        createdDate = Instant.now();
    }
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String lastModifiedBy) {
        this.updatedBy = lastModifiedBy;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant lastModifiedDate) {
        this.updatedDate = lastModifiedDate;
    }

    public Boolean getActive() {
        return isActive;
    }
}
