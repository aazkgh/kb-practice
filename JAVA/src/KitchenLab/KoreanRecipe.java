package KitchenLab;

public class KoreanRecipe extends Recipe {
    public KoreanRecipe() {
        super("김치찌개", 20,false);
    }

    @Override
    public String getDescription() {
        return "매콤한 김치찌개를 추천합니다.";
    }
}
