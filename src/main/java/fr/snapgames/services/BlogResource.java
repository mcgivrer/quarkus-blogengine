package fr.snapgames.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.snapgames.entities.Blog;
import fr.snapgames.repositories.BlogService;

@Path("/blog")
public class BlogResource {

    @Inject
    BlogService blogService;

    @GET
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findBlogByTitle(@PathParam("title") String title) {
        List<Blog> blogs = blogService.findByTitle(title);
        if (blogs != null && blogs.size() > 0) {
            return Response.ok(blogs.get(0)).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/uuid/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findBlogByUUID(@PathParam("uuid") String uuid) {
        Blog blog = blogService.findByUUID(uuid);
        if (blog != null) {
            return Response.ok(blog).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }


    @GET
    @Path("/creator/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findBlogByCreator(@PathParam("name") String creatorName) {
        List<Blog> blogs = blogService.findByCreator(creatorName);
        if (blogs != null && blogs.size() > 0) {
            return Response.ok(blogs).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

}

