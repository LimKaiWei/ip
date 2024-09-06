package utility;

/**
 * This class is created to serve the purpose of printing items to screen.
 */
public class Ui {

    public Ui() {}

    /**
     * Prints string to stdout without endline, followed by a visual line.
     *
     * @param textToSay a string of text to be printed to stdout
     */
    public static void say(String textToSay) {
        String line = "____________________________________________________________\n";
        System.out.print(textToSay);
        System.out.print(line);
    }

    /** 
     * Prints input banner to stdout.
     */
    public static void introSay() {
        String logo = "    ________    __    ________  ______\n"
                + "   / ____/ /   / /   /  _/ __ \\/_  __/\n"
                + "  / __/ / /   / /    / // / / / / /\n"
                + " / /___/ /___/ /____/ // /_/ / / /\n"
                + "/_____/_____/_____/___/\\____/ /_/\n";
        String intro = "Hello! I'm\n" + logo
                + "What can I do for you?\n";
        say("");
        say(intro);
    }

}
