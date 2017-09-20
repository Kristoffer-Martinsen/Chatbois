/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatboisService;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Kristoffer
 */
@Path("chat")
@Produces(MediaType.APPLICATION_JSON)
public class ChatService {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    
    /*
    @GET
    @Path("messages")
    public Response getMessages() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        
        try {
            Files.list(Paths.get("messages"))
                    .filter(Files::isRegularFile)
                    .map(java.nio.file.Path::toFile)
                    .forEach((File f) -> {
                        builder.add(Json.createObjectBuilder()
                        .add("name", f.getName())
                        .add("size", f.length())
                        .add("da", format.format(new Date(f.lastModified())))
                        );
                    });
        } catch (IOException e){
            throw new WebApplicationException(Response.Status.FORBIDDEN);
        }
        
        return Response.ok(builder.build().build());
    }
*/
}
