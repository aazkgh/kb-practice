package DigitalWallet;

public class PaymentManager {
    int[] transaction = {0, 0};
    int balance = 0;

    public void process(Payment payment, int amount) {
        boolean success = payment.pay(amount);

        if(success) {
            balance += amount;
            payment.approve();
            payment.cancel("테스트 취소");

            if(payment instanceof KakaoPay) {
                transaction[0] += amount;
                ((KakaoPay) payment).sendNotification();
            } else {
                transaction[1] += amount;
                System.out.println("[알림 서비스 없음]");
            }
        } else {
            System.out.println("[결제 실패]: 승인/취소 건너뜀");
        }
    }

    public void printSummary() {
        System.out.println("✅ 결제 통계 요약");
        System.out.println("총 결제 횟수:" + (transaction[0] + transaction[1]) + "회");
        System.out.println("총 결제 금액:" + balance + "원");
        System.out.println("[CreditCard]: " + transaction[1] + "건");
        System.out.println("[KakaoPay]: " + transaction[0] + "건");
    }
}
