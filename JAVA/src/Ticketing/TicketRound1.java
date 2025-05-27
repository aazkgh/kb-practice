package Ticketing;

public class TicketRound1 {
    public static void main(String[] args) {
        Runnable buyer = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
            }
        };

        Thread fan1 = new Thread(buyer);
        Thread fan2 = new Thread(buyer);

        fan1.setName("Fan1");
        fan2.setName("Fan2");

        //start -> multi thread start
        fan1.start();
        fan2.start();

        System.out.println("=== run 호출 테스트 ===");
        //기본 main 스레드에서 동작
        fan1.run();
    }
}
