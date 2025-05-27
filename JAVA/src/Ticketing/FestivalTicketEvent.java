package Ticketing;

public class FestivalTicketEvent extends AbstractTicketEvent {
    public FestivalTicketEvent(int ticketCount) {
        super(ticketCount);
    }

    @Override
    protected void fanEntry() {
        Thread[] fans = new Thread[ticketCount];

        for (int i = 1; i <= ticketCount; i++) {
            //fan마다 thread 생성
            fans[i - 1] = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
            });

            System.out.println("! 티켓 구매 시도 중 !");
            fans[i - 1].setName("팬" + i);
            fans[i - 1].start();
        }

        for (Thread t : fans) {
            try {
                //호출된 스레드가 완료될 때까지 현재 스레드는 대기
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
