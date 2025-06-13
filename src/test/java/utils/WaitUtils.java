package utils;

public class WaitUtils {

    public static void waitForAction(Runnable action) throws InterruptedException {

        Thread.sleep(4000);
        action.run();
    }
}
