package MyGroove;

public class ModernPlayerAdapter implements Playable {
    ModernPlayer player;

    ModernPlayerAdapter(ModernPlayer player) {
        this.player = player;
    }

    @Override
    public void play(String title) {
        String editedTitle = title.toLowerCase();
        if(editedTitle.contains("bad"))
            System.out.println("🚫 금지어가 포함된 곡은 재생할 수 없습니다.");
        else
            player.begin(title);
    }
}
