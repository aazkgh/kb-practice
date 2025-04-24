package MyGroove;

public class PlaybackLogger {
    public void log(String title, String artist) {
        class RecentLog {
            String title;
            String artist;
            RecentLog (String title, String artist) {
                this.title = title;
                this.artist = artist;
            }

            void printLog() {
                System.out.println("🎼 " + title + " - " + artist + ((title.length() >= 10 || artist.length() >= 10) ? " (인기곡)" : ""));
            }
        }

        RecentLog recentLog = new RecentLog(title, artist);
        recentLog.printLog();
    }
}
