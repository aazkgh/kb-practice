package KitchenLab;

public class Recipe {
    protected String title;
    protected int cookTime;
    protected boolean isVegan;

    public Recipe(String title, int cookTime, boolean isVegan) {
        this.title = title;
        this.cookTime = cookTime;
        this.isVegan = isVegan;
    }

    public String getDescription() {
        return "기본 레시피입니다.";
    };
    public String toString(){
        return title + "(" + cookTime + "분) - " + (isVegan ? "비건" : "비건 아님");
    };
}
