package DigitalWallet;

public interface Payment {
    //금액을 결제하는 기능
    void pay(int amount);
    //결제를 승인하는 기능
    void approve();
    void cancel(String reason);
}
