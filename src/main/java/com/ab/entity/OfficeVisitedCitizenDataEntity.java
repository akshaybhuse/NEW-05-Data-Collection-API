package com.ab.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tbl_Ofc_Visited_Ctz_Data")
public class OfficeVisitedCitizenDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer visitedCitizenAppId;

    private String fullName;

    private String email;

    private Long mobileNumber;

    private String gender;

    private Long ssn;

    private String stateName;

    private LocalDate dob;

    private String createdBy;

    private String updatedBy;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDate updatedDate;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        OfficeVisitedCitizenDataEntity that = (OfficeVisitedCitizenDataEntity) o;
        return getVisitedCitizenAppId() != null && Objects.equals(getVisitedCitizenAppId(), that.getVisitedCitizenAppId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
