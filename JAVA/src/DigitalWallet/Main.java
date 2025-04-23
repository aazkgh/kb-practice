package DigitalWallet;

public class Main {
    public static void main(String[] args) {
        Payment payment = new KakaoPay();
        payment.pay(5000);
        payment.pay(2000);
        payment.approve();
        payment.cancel("오입력");
    }
}
