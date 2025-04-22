package KitchenLab;

public class VeganRecipe extends Recipe {
    public VeganRecipe() {
        super("버섯 샐러드", 15, true);
    }

    @Override
    public String getDescription() {
        return "신선한 버섯 샐러드 옴뇸뇸";
    }
}
