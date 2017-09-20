/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatboisService;

import com.mycompany.chatbois.Conversation;
import com.mycompany.chatbois.Message;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
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
@Stateless
@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Chat {
    @PersistenceContext
    EntityManager em;
    
    @GET
    public List<Message> getMessages() {

        return em.createQuery("SELECT m FROM Message m",
                Message.class)
                .getResultList(); 
    }
    
    @POST
    @Path("add")
    public Response addMessage(@QueryParam("name") String name, Message message) {
        
        if(name != null) {
            Conversation c = em.find(Conversation.class, name);
            
            if(c == null) {
                c = new Conversation(name);
                em.persist(c);
            }
            
            message.setConversation(c);
            em.persist(message);
            
            return Response.ok(message).build();
        } else {
            return Response.noContent().build();
        }   
    }
}
