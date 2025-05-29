package PopUp.metamong;

import PopUp.framework.Ticket;
import PopUp.framework.TicketFactory;

public class MetamongTicketFactory extends TicketFactory {
    @Override
    protected Ticket createTicket(String owner) {
        return create(owner);
    };

    @Override
    protected void registerTicket(Ticket ticket) {
        System.out.println(ticket.toString() + "등록 완료");
    }
}
