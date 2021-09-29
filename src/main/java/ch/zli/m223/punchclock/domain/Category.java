package ch.zli.m223.punchclock.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

// Entität (Etwas was ich in der DB speichern möchte)  => In DB wird tabelle generiert.
@Entity
public class Category {
    @Id
    // Werte sollen generiert werden
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    // Es gibt eine Liste, mit mehreren Elementen
    // category = In entry Klasse @ManeToOne heisst das Attribut category
    @OneToMany(mappedBy = "category")
    // Möchte ich nicht sehen (Imfalle einer Rekursion)
    @JsonIgnore
    private List<Entry> entries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
