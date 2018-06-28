
package io.tabletoptools.hawthorne.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
@Table(name = "CHARACTER")
public class Character {

    @Id
    @Column(name = "OBJECT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PLAYER", nullable = false)
    private Player player;

    private Race race;
}
