package MyGroove;

public class PlayerUI {
    ClickListener player;
    public interface ClickListener {
        void onClick();
    }

    void setClickListener(ClickListener listener) {
        this.player = listener;
    }
    void clickPlayButton() {
        if(player != null) {
            this.player.onClick();
        } else {
            System.out.println("리스너가 등록되지 않았습니다!");
        }
    }
}
