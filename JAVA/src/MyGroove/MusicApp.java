package MyGroove;

public class MusicApp {
    String title ;
    String artist ;
    String genre ;

    MusicApp(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    class MusicPlayer {
        void play() {
            String emoji = "🎧";
            if(genre == "HIPHOP") {
                emoji = "💥";
            } else if(genre == "BALLAD") {
                emoji = "🎹";
            }

            System.out.println(emoji + "Now Playing: " + title + " by " + artist + emoji);
        }
    }
}
