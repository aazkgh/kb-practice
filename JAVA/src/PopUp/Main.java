package PopUp;

import PopUp.framework.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Goods> goods = new ArrayList<Goods>();

        goods.add(new Goods("메타몽 쿠션", "분홍", false));
        goods.add(new Goods("메타몽 노트북 파우치", "보라", true));
        goods.add(new Goods("메타몽 인형", "분홍", false));
        goods.add(new Goods("메타몽 가방", "회색", true));
        goods.add(new Goods("메타몽 키링", "파랑", false));

        Predicate<Goods> jiwooFilter = g -> g.getColor().equals("분홍");
        Predicate<Goods> iseulFilter = g -> g.isUseful();

        printSelectedGoods("지우", goods, jiwooFilter);
        printSelectedGoods("이슬이", goods, iseulFilter);

    }

    public static void printSelectedGoods(String user, List<Goods> list ,Predicate<Goods> filter) {
        System.out.println(user + "의 선택");

        List<Goods> selectedGoods = new ArrayList<Goods>();
        list.forEach(g -> {
            if (filter.test(g)) {
                selectedGoods.add(g);
            }
        });

        selectedGoods.forEach(g -> System.out.println(g.getName()));
    }
}
