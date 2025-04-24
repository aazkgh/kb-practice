package MyGroove;

public class GenrePlaybackManager {
    private GenrePlayer player;
    public interface GenrePlayer {
        void play(String title, String artist);
    }

    public void setPlayer(GenrePlayer player){
        this.player = player;
    };
    public void play(String title, String artist) {
        if(player != null) {
            player.play(title, artist);
        } else {
            System.out.println("❌ 선택된 플레이어 설정이 없습니다.");
        }
    }
}
