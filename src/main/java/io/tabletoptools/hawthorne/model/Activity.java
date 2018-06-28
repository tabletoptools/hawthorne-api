
package io.tabletoptools.hawthorne.model;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Audited
@Table(name = "ACTIVITIES")
public class Activity {

    public enum ActivityType {
        SESSION,
    }

    @Id
    @Column(name = "OBJECT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TYPE", length = 16, nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private ActivityType type;

    @Column(name = "TITLE", length = 64, nullable = false)
    @NotNull
    private String title;

    @Column(name = "DTP", nullable = true)
    private BigDecimal dtp;

    @Column(name = "CHARACTER", nullable = false)
    @NotNull
    private Character character;

    @Column(name = "MONEY", nullable = true)
    private BigDecimal money;

    @Column(name = "COMMENT", nullable = true)
    private String comment;



}


