package logic;

import java.util.ArrayList;

public class Channel {
    private String name;
    private ArrayList<Message> messageList;

    //constructor
    public Channel(String name){
        this.messageList = new ArrayList<>();
        setName(name);
    }
    //method
    public void addMessage(Message message){
        messageList.add(message);
    }

    public int getMessageCount(){
        return getMessageList().size();
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if(name.isBlank()) this.name = "off-topic";
    }
}

