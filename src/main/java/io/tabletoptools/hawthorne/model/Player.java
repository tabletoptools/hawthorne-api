
package io.tabletoptools.hawthorne.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Audited
@Table(name = "PLAYER")
public class Player {

    @Id
    @Column(name = "OBJECT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DISCORD_ID")
    private Long discordId;

    @OneToMany()
    private List<Authentication> authentications;


}
