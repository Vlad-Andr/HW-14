package cursor.hw.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String genre;
    @Column
    private String description;
    @Column
    private double rate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;
}