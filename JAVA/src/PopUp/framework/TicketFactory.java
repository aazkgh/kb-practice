package PopUp.framework;

import PopUp.metamong.MetamongTicket;

public abstract class TicketFactory {
    public final Ticket create(String owner) {
        Ticket ticket = new MetamongTicket(owner);
        registerTicket(ticket);

        return ticket;
    };

    protected abstract Ticket createTicket(String owner);
    protected abstract void registerTicket(Ticket ticket);
}
