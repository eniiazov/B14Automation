package utilites;

public class SeleniumUtils {

    public static void pause(int seconds)  {

        try{
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
