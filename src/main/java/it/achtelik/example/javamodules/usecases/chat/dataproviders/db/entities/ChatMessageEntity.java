package it.achtelik.example.javamodules.usecases.chat.dataproviders.db.entities;

import it.achtelik.example.javamodules.application.dataproviders.db.entities.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "ID_SEQ",
        sequenceName = "CHAT_MESSAGE_ID_SEQ",
        allocationSize = 1)
public class ChatMessageEntity extends AbstractEntity {

    private String text;

    private ChatMessageEntity() {
    }

    public ChatMessageEntity(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
