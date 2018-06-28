/*
 * $Id: HttpFilter 3988 2017-06-21 13:47:09Z cfi $
 * Created on 03.01.18 11:08
 * 
 * Copyright (c) 2017 by bluesky IT-Solutions AG,
 * Kaspar-Pfeiffer-Strasse 4, 4142 Muenchenstein, Switzerland.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of bluesky IT-Solutions AG ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with bluesky IT-Solutions AG.
 */
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


