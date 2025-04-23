package DigitalWallet;

public class CreditCard implements Payment {
    int balance = 0;

    @Override
    public void pay(int amount) {
        balance += amount;
        System.out.println("[신용카드] " + amount + "원 결제 완료");
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
