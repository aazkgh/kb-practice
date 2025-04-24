package MyGroove;

public class PlayerSettings {
    static class Mode {
        private static boolean shuffle = false;
        private static boolean repeat = true;
        private static int volumeLevel = 5;

        public static void printSettings() {
            System.out.println("💡 현재 재생 설정 상태");
            System.out.println("- Shuffle: " + (shuffle ? "ON" : "OFF"));
            System.out.println("- Repeat: " + (repeat ? "ON" : "OFF"));
            System.out.println("- Volume: " + volumeLevel);
        }
        public static boolean isShuffle() {
            return shuffle;
        }
        public static boolean isRepeat() {
            return repeat;
        }
        public static int getVolume() {
            return volumeLevel;
        }

        public static void setShuffle(boolean value) {
            shuffle = !shuffle;
            System.out.println("Shuffle 모드가 " + (shuffle ? "ON" : "OFF") + "로 설정되었습니다.");
        }
        public static void setRepeat(boolean value) {
            repeat = !repeat;
            System.out.println("Repeat 모드가 " + (repeat ? "ON" : "OFF") + "로 설정되었습니다.");
        }
        public static void setVolumeLevel(int value) {
            if(volumeLevel > 10 || volumeLevel < 0) {
                System.out.println("볼륨은 0 ~ 10으로 제한됩니다.");
            } else {
                volumeLevel = value;
                System.out.println("볼륨이 " + volumeLevel + "로 설정되었습니다.");
            }
        }
    }
}
