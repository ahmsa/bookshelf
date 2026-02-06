package org.ahmsa.bookshelf.controller;

import java.util.List;

import org.ahmsa.bookshelf.data.IDto;
import org.ahmsa.bookshelf.data.IEntity;
import org.ahmsa.bookshelf.service.IService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

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

    public D getById(@QueryParam("id") long id) {
        return (D) this.getServiceClass().getById(id);
    }


    @DELETE
    public void delete(@QueryParam("id") long id) {
        this.getServiceClass().delete(id);
    }
}
