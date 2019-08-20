package com.mycompany.moneytransfer;

import com.mycompany.moneytransfer.dto.CreateAccount;
import com.mycompany.moneytransfer.dto.TransferDto;
import com.mycompany.moneytransfer.model.Account;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Service class
 *
 * @author pavel.shatrov
 */
@Singleton
@Startup
@Path("/resource")
public class Service {

    @Inject
    private ServiceImpl serviceImpl;

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(CreateAccount account) {
        if (serviceImpl.createAccount(account)) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("transfer")
    @Consumes(MediaType.APPLICATION_JSON)
    public void makeTransfer(TransferDto transfer) throws InterruptedException {
        serviceImpl.makeTransfer(transfer);
    }

    @GET
    @Path("account/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("id") int id) {
        return serviceImpl.getAccount(id);
    }
}
