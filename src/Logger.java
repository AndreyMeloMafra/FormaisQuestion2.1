public class Logger {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void log(String msg) {
        System.out.println(ANSI_RESET + msg);
    }

    public static void logDescription(String msg) {
        System.out.println(ANSI_YELLOW + msg);
    }

    public static void logPositive(String msg) {
        System.out.println(ANSI_GREEN + msg);
    }

    public static void logNegative(String msg) {
        System.out.println(ANSI_RED + msg);
    }

    public static void logTitle(String msg) {
        System.out.println(ANSI_BLUE + msg);
    }
}
