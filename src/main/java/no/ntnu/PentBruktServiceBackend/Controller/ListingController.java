package no.ntnu.PentBruktServiceBackend.Controller;

import no.ntnu.PentBruktServiceBackend.Domain.Listing;
import no.ntnu.PentBruktServiceBackend.Service.ListingService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//@ApplicationPath("/api")
@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ListingController {

    @Inject
    ListingService listingService;

    @GET
    @Path("test")
    public String test(){
        return "test";
    }

    @GET
    @Path("all-listings")
    public Response getAllItems() {
        return Response.ok(this.listingService.getAllListings()).build();
    }

    @POST
    @Path("add-listing")
    public Response addListing(Listing listing) {
        this.listingService.addListing(listing);
        return Response.ok().build();

    }

    @POST
    @Path("remove-listing")
    public Response removeListing(Listing listing) {
        if (this.listingService.removeListing(listing.getListingId())) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
