/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chatbois;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Kristoffer
 */

@Data @NoArgsConstructor

public class Message implements Serializable {
    String user;
    String text;
    
    Timestamp version;
    
    public Message(String user, String text) {
        this.user = user;
        this.text = text;
    }

    void setConversation(Conversation c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
