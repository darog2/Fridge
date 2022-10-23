package com.dungeon.language;

import com.dungeon.module.Fridge;

import javax.xml.bind.annotation.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Messages")
@XmlRootElement
public class MessageList implements Iterable<Message>{
    @XmlElementWrapper(name="Messages")
    @XmlElement(name= "messages")
private List<Message> messages = new LinkedList<>();

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public Iterator<Message> iterator() {
        return messages.iterator();
    }
}
