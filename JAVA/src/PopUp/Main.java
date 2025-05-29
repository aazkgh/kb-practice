package PopUp;

import PopUp.framework.Ticket;
import PopUp.framework.TicketFactory;
import PopUp.metamong.MetamongTicketFactory;

public class Main {
    public static void main(String[] args) {
        TicketFactory factory = new MetamongTicketFactory();
        Ticket jiwoo = factory.create("지우");
        Ticket isule = factory.create("이슬");

        System.out.println();

        jiwoo.enter();
        isule.enter();
    }
}
