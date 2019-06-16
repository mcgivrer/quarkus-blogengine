package fr.snapgames.entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@ToString
@NamedQueries({ @NamedQuery(name = "findActiveByTitle", query = "select b.* from Blog b where b.active=1"),
        @NamedQuery(name = "findByCreator", query = "select b.* from Blog b where b.createdBy=:creatorName"), })
public class Blog {

    public enum BlogStatus {
        CREATED, ACTIVE, SUSPENDED, ARCHIVED
    }

    @Id
    @Basic
    @NotNull
    public UUID uuid;

    @NotNull
    @Size(min = 4, max = 100)
    public String title;

    @NotNull
    @Size(min = 4, max = 40)
    public String createdBy;

    @NotNull
    public LocalDate createdAt;

    @NotNull
    @Column(name = "blogStatus")
    public BlogStatus status = BlogStatus.CREATED;

    public Blog() {
        super();
        status = BlogStatus.CREATED;
        createdAt = LocalDate.now();
    }

}