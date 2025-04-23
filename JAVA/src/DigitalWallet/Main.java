package DigitalWallet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 결제 수단 선택 ===");
        System.out.println("[1] 신용카드");
        System.out.println("[2] 카카오페이");
        System.out.print("결제 수단을 선택하세요:");
        int type = sc.nextInt();

        Payment payment;

        if (type == 1) {
            payment = new CreditCard();
        } else if (type == 2) {
            payment = new KakaoPay();
        } else {
            System.out.println("선택할 수 없는 결제수단입니다.");
            sc.close();
            return;
        }

        if (payment instanceof KakaoPay) {
            System.out.print("카카오페이 사용자 인증을 진행하시겠습니까? (Y/N):");
            String process = sc.next();
            if (process.equals("Y")) {
                ((KakaoPay) payment).authenticate();
            }
        }

        boolean ready = payment.beforePay();
        if (!ready) {
            System.out.println("[결제 실패: 준비 단계에서 중단]");
            return;
        }

        System.out.print("결제 금액을 입력하세요:");
        int amount = sc.nextInt();
        boolean success = payment.pay(amount);

        if(success) {
            payment.approve();
            payment.cancel("테스트 취소");

            if(payment instanceof KakaoPay) {
                ((KakaoPay) payment).sendNotification();
            } else {
                System.out.println("[알림 서비스 없음]");
            }
        } else {
            System.out.println("[결제 실패]: 승인/취소 건너뜀");
        }
    }
}
