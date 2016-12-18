package ru.stqa.pft.mantis.model;

/**
 * Created by UserData on 18.12.2016.
 */
public class MailMessage {
    String recepient;
    String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MailMessage(String recepient, String content)
    {
        this.recepient = recepient;
        this.content = content;

    }


    @Override
    public String toString() {
        return "MailMessage{" +
                "recepient='" + recepient + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getRecepient() {
        return recepient;
    }

    public void setRecepient(String recepient) {
        this.recepient = recepient;
    }
}
