
package io.tabletoptools.hawthorne.model;

import org.hibernate.envers.Audited;

import javax.ejb.TransactionAttribute;
import javax.persistence.*;

@Entity
@Audited
@Table(name = "AUTHENTICATION")
public class Authentication {

    @Id
    @Column(name = "OBJECT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PLAYER")
    private Player player;

    @Column(name = "AUTH_CODE")
    private String authCode;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;
}
