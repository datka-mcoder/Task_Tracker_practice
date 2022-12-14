package taskTracker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_gen")
    @SequenceGenerator(name = "card_gen", sequenceName = "card_seq", allocationSize = 1)
    private Long id;
    private String title;
    private String description;
    private boolean idArchive = false;
    @ManyToMany(cascade = {DETACH, REFRESH, MERGE, PERSIST})
    private List<User> members;
    @OneToMany(cascade = {ALL}, mappedBy = "card")
    private List<Checklist> checklists;
    @OneToOne(cascade = {ALL})
    private Estimation estimation;
    @ManyToOne(cascade = {DETACH, REFRESH, MERGE, PERSIST})
    private Column column;
    @OneToMany(cascade = {ALL}, mappedBy = "card")
    private List<Label> labels;
    @OneToMany(cascade = {ALL}, mappedBy = "card")
    private List<Comment> comments;
    @OneToMany(cascade = {ALL}, mappedBy = "card")
    private List<Attachment> attachments;
    @ManyToOne(cascade = {DETACH, REFRESH, MERGE, PERSIST})
    private Board board;

}
