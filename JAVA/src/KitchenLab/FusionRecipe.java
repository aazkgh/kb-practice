package KitchenLab;

public class FusionRecipe extends Recipe {
    FusionRecipe() {
        super("불닭파스타", 15, false);
    }

    @Override
    public String getDescription() {
        return "불닭파스타 먹으면 배가 아파요";
    }
}
