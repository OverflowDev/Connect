/*
 * Copyright 2016 Goblom.
 * 
 * All Rights Reserved unless otherwise explicitly stated.
 */
package codes.goblom.connect.api.events;

import codes.goblom.connect.api.Contact;
import codes.goblom.connect.api.ConnectService;
import java.net.URL;
import lombok.Getter;
import org.bukkit.event.HandlerList;

/**
 *
 * @author Goblom
 */
public class MessageFinishedOutgoingEvent extends MessageEvent {
    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    
    public static HandlerList getHandlerList() {
        return handlers;
    }
    
    @Getter
    private final boolean mediaMessage;
    
    @Getter
    private Object rawData = null;
    
    public MessageFinishedOutgoingEvent(ConnectService service, Contact contact, String messageBody) {
        super(service, contact, messageBody);
        
        URL url = null;
        try {
            url = new URL(messageBody);
        } catch (Exception e) { }
        
        this.mediaMessage = url != null;
    }
    
    public MessageFinishedOutgoingEvent(ConnectService service, Contact contact, String messageBody, Object otherData) {
        this(service, contact, messageBody);
        
        this.rawData = otherData;
    }
    
    public <T> T getRawData(Class<T> clazz) {
        return (T) rawData;
    }
}
