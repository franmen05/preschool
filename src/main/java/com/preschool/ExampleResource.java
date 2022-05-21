package com.preschool;

import com.preschool.repository.GenderRepository;
import com.preschool.service.CompanyService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @Inject
    CompanyService companyService;

    @Inject
    GenderRepository genderRepository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object hello() {
        return companyService.findOne(1L);
    }
}