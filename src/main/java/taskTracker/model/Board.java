package taskTracker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "boards")
@Getter
@Setter
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_gen")
    @SequenceGenerator(name = "board_gen", sequenceName = "board_seq", allocationSize = 1)
    private Long id;
    private String title;
    private String photoLink;
    private boolean isArchive = false;
    private boolean isFavorite = false;
    @OneToMany(cascade = ALL, mappedBy = "board")
    private List<Column> columns;
    @ManyToOne(cascade = {DETACH, REFRESH, MERGE, PERSIST})
    private User creator;
    @ManyToMany(cascade = {DETACH, REFRESH, MERGE, PERSIST}, mappedBy = "boards")
    private List<User> members;
    @OneToMany(cascade = {ALL}, mappedBy = "board")
    private List<Card> allIssues;
    @ManyToOne(cascade = {DETACH, REFRESH, MERGE, PERSIST})
    private Workspace workspace;

}
