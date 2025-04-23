package DigitalWallet;

public interface Payment {
    boolean pay(int amount);
    void approve();
    void cancel(String reason);
}
