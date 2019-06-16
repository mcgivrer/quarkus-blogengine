package fr.snapgames.repositories;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import fr.snapgames.entities.Blog;
import fr.snapgames.entities.Blog.BlogStatus;

@ApplicationScoped
public class BlogService {

    @Inject
    EntityManager em;

    public Blog findByUUID(String uuid) {
        Blog blog = em.find(Blog.class, UUID.fromString(uuid));
        return blog;
    }

    public List<Blog> findByTitle(String title) {
        List<Blog> blogs = em.createNamedQuery("findActiveByTitle", Blog.class).getResultList();
        return blogs;
    }

    public List<Blog> findByCreator(String creatorName) {
        List<Blog> blogs = em.createNamedQuery("findActiveByCreator", Blog.class).getResultList();
        return blogs;
    }

    public Blog changeStatus(String uuid, BlogStatus status) {
        Blog blog = findByUUID(uuid);
        blog.setStatus(status);
        em.persist(blog);
        return blog;
    }

    public Blog save(Blog blog) {
        if (blog.getUuid() == null) {
            blog.setUuid(UUID.randomUUID());
        }
        em.persist(blog);
        return blog;
    }

}