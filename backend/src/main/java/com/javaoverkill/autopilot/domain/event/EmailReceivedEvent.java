package com.javaoverkill.autopilot.domain.event;

public class EmailReceivedEvent extends BusinessEvent{
    private final String from;
    private final String subject;
    private final String body;

    public EmailReceivedEvent(String from, String subject, String body){
        super();
        this.from=from;
        this.subject=subject;
        this.body=body;
    }

    public String getFrom(){
        return from;
    }

    public String getSubject(){
        return subject;
    }

    public String getBody() {
        return body;
    }

    @Override
    public EventType getType() {
        return EventType.EMAIL_RECEIVED;
    }
}
