package org.ahmsa.bookshelf.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.ahmsa.bookshelf.data.IDto;
import org.ahmsa.bookshelf.data.IEntity;
import org.ahmsa.bookshelf.service.IService;

import java.util.List;

public abstract class BaseController<I extends IEntity, D extends IDto<I>> {
    public abstract IService getServiceClass();

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public D save(D dto) {
        return (D) this.getServiceClass().save(dto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<D> getAll() {
        return this.getServiceClass().getAll();
    }

    @DELETE
    @Path("/delete")
    public void delete(@QueryParam("id") String id) {
        this.getServiceClass().delete(id);
    }
}
