package MyGroove;

public class Main {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        player.play("Ditto", false, new MusicPlayer.PlayResultListener() {
            @Override
            public void onSuccess(String title) {
                System.out.println("✅ 재생 성공: " + title);
            }

            @Override
            public void onError(String title, int errorCode) {
                System.out.println("⁉ 재생 실패: " + title + " - 오류 코드:" + errorCode);
            }
        });
    }
}
