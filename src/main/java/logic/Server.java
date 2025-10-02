package logic;

import java.util.ArrayList;

public class Server {
    private String name;
    private User owner;
    private ArrayList<Channel> channelList;
    private ArrayList<User> memberList;

    //constructor

    public Server(String name, User owner, TemplateType template){
        setOwner(owner);
        this.memberList = new ArrayList<>();
        this.channelList = new ArrayList<>();
        addUser(owner);
        setName(name);
        String channelName;
        switch (template){
            case BASIC:
                channelName = "general";
                break;
            case GAMING:
                channelName = "gaming";
                break;
            case STUDY:
                channelName = "homework-help";
                break;
            default:
                channelName = "";
        }
        addChannel(owner,channelName);
    }
    //method
    public boolean isMemberInServer(User user){
        return memberList.contains(user);
    }

    public Channel addChannel(User user, String channelName){
        if(user.getName().equals(owner.getName())){
            Channel newChannel = new Channel(channelName);
            channelList.add(newChannel);
            return newChannel;
        }

        return null;
    }

    public User addUser(User user){
        if(!memberList.contains(user)){
            memberList.add(user);
            user.addJoinedServersList(this);
            return user;
        }
        return null;
    }

    public boolean kickUser(User kicker, User kicked) throws Exception{
        if(!kicker.equals(owner)){
            throw new Exception("kick is not owner");
        } else if (kicker.equals(owner) && (!memberList.contains(kicked) || kicked.equals(owner))) {
            return false;
        }else{
            memberList.remove(kicked);
            (kicked.getJoinedServersList()).remove(this);
            return true;
        }
    }

    public void setName(String name){
        if (name.isBlank()){
            this.name = owner.getName() + " home";
        }else{
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(ArrayList<Channel> channelList) {
        this.channelList = channelList;
    }

    public ArrayList<User> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<User> memberList) {
        this.memberList = memberList;
    }
}
