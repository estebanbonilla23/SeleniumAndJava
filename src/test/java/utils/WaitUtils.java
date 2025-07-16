package utils;

public class WaitUtils {

    public static void waitForAction(Runnable action) throws InterruptedException {

        Thread.sleep(5000);
        action.run();
    }
}
