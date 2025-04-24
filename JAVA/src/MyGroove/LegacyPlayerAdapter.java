package MyGroove;

public class LegacyPlayerAdapter implements Playable{
    LegacyPlayer player;

    LegacyPlayerAdapter(LegacyPlayer player) {
        this.player = player;
    }

    @Override
    public void play(String title) {
        String editedTitle = title.toLowerCase();
        if(editedTitle.contains("bad"))
            System.out.println("🚫 금지어가 포함된 곡은 재생할 수 없습니다.");
        else
            player.startPlay(title);
    }
}
