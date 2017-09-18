/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chatbois;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Kristoffer
 */
public class Conversation implements Serializable {
    String id;
    
    List<Message> messages;
    
    public Conversation(String id) {
        this.id = id;
    }
    
}
