package teams;

import units.Unit;

public class Team {
    String name;
    Unit[] members;

    public Team(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit[] getMembers() {
        return members;
    }

    public void setMembers(Unit[] members) {
        this.members = members;
    }
}
