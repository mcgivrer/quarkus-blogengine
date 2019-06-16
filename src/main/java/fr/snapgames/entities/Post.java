package fr.snapgames.entities;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
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
@NamedQueries({ @NamedQuery(name = "findAllByBlogAndByAuthor", query = "select p.* from Post p where p.blogUUID=:uuid"),
        @NamedQuery(name = "findByAuthor", query = "select p.* from Post p where p.createdBy=:authorName"),
        @NamedQuery(name = "findById", query = "select p.* from Post p where p.uuid=:uuid"),
        @NamedQuery(name = "findByBlogAndByTag", query = "select p.* from Post p where  p.blogUUID=:uuid and p.tags like :tags"),
        @NamedQuery(name = "findByBlogAndByCategory", query = "select p.* from Post p where p.blogUUID=:uuid and p.categories like :category") })

public class Post {

    public enum PostStatus {
        DRAFT, VALIDATED, PUBLISHED, ARCHIVED
    }

    @Id
    @Basic
    @NotNull
    public UUID uuid;

    @NotNull
    public UUID blogUUID;

    @NotNull
    @Size(min = 4, max = 100)
    public String title;

    @Size(min = 0, max = 400)
    public String header;

    @Size(min = 1, max = 4000)
    public String content;

    @Basic
    public String tags;

    @Basic
    public String categories;

    @NotNull
    @Size(min = 4, max = 40)
    public String createdBy;

    @NotNull
    public LocalDate createdAt;

    @NotNull
    @Basic
    @Column(name = "postStatus")
    public PostStatus status = PostStatus.DRAFT;

    public Post() {
        super();
        status = PostStatus.DRAFT;
        createdAt = LocalDate.now();
        categories = "latestnews";
    }

    public void setTagList(List<String> tagList) {
        tags = String.join(",", tagList);
    }

    public List<String> getTagList() {
        return Arrays.asList(tags.split(","));
    }

    public void setCategoryList(List<String> categoryList) {
        categories = String.join(",", categoryList);
    }

    public List<String> getCategoryList() {
        return Arrays.asList(categories.split(","));
    }
}