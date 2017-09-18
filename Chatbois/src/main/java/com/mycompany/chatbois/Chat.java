/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chatbois;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Kristoffer
 */
@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Chat {
    @PersistenceContext
    EntityManager em;
    
    @GET
    public List<Message> getMessages(@QueryParam("name") String name) {
        List<Message> result = null;
        
        
        if(name.equals("kris")) {
            return result;
        }
        
        return result != null ? result : Collections.EMPTY_LIST;
    }
    
    @POST
    @Path("add")
    public Response addMessage(@QueryParam("name") String name, Message message) {
        
        if(name.equals("kris")) {
            Conversation c = em.find(Conversation.class, name);
            
            if(c == null) {
                c = new Conversation(name);
                em.persist(c);
            }
            
            message.setConversation(c);
            em.persist(c);
            
            return Response.ok(message).build();
        } else {
            return Response.noContent().build();
        }
        
        
    }
    
    
}
