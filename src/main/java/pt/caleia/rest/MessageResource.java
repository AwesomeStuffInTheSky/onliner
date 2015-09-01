package pt.caleia.rest;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;


@Service
@Path( "/messages" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class MessageResource {
	
	
	private final List<Message> messages = new ArrayList<Message>();
	
	
	@GET
	public List<Message> listMessages() {
		return this.messages;
	}
	
	
	@POST
	public Response createMessage( @Valid Message message ) {
		this.messages.add( message );
		return Response.ok().build();
	}


}

