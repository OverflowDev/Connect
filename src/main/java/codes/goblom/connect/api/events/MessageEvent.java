/*
 * Copyright 2016 Goblom.
 * 
 * All Rights Reserved unless otherwise explicitly stated.
 */
package codes.goblom.connect.api.events;

import codes.goblom.connect.api.Contact;
import codes.goblom.connect.api.ConnectService;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 *
 * @author Goblom
 */
abstract class MessageEvent extends Event {
    
    @Getter
    private final ConnectService service;
    
    @Getter
    @Setter
    private String messageBody;
    
    /**
     * This is not the contact you have specified in the config.
     * This is the contact that it is sending to or receiving from;
     */
    @Getter
    private final Contact contactInvolved;
    
    public MessageEvent(ConnectService service, Contact contact, String messageBody) {
        this.service = service;
        
        this.messageBody = messageBody;
        this.contactInvolved = contact;
    }
    
    @Override
    public abstract HandlerList getHandlers();
}
