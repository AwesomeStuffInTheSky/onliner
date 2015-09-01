package pt.caleia.rest;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Message {
	
	
	@JsonProperty( value = "type" )
	@NotNull
	private final String type;
	@JsonProperty( value = "text" )
	@NotNull
	private final String text;
	
	
	@JsonCreator
	public Message( @JsonProperty( "type" ) String type, @JsonProperty( "text" ) String text ) {
		this.type = type;
		this.text = text;
	}

	
	public String getType() {
		return this.type;
	}

	
	public String getText() {
		return this.text;
	}
	
	
}

