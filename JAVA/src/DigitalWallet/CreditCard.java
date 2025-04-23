package DigitalWallet;

public class CreditCard implements Payment {
    int balance = 0;

    @Override
    public boolean pay(int amount) {
        balance += amount;
        Payment.log("결제 수단: 신용카드, 금액: " + amount + "원");
        System.out.println("[신용카드] " + amount + "원 결제 완료");
        return true;
    }

    @Override
    public void approve() {
        System.out.println("[신용카드] 카드 승인 완료");
    }

    @Override
    public void cancel(String reason) {
        System.out.println("[신용카드] " + balance + "원 결제 취소 - 사유: " + reason);
    }
}
