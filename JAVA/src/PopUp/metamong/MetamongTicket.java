package PopUp.metamong;

import PopUp.framework.Ticket;

public class MetamongTicket extends Ticket {
    private String owner;

    public MetamongTicket(String owner) {
        System.out.println(owner + "님의 메타몽 티켓을 발급합니다.");
        this.owner = owner;
    }

    @Override
    public void enter() {
        System.out.println(this + "님이 입장하였습니다.");
    }

    @Override
    public String toString() {
        return "[MetamongTicket] " + owner;
    }
}
