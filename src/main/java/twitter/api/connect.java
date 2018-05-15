package twitter.api;

import twitter4j.*;

import java.util.List;

public class connect {

    public static void main(String[] args) {

        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses;

        {
            try {
                statuses = twitter.getHomeTimeline();
                System.out.println("Showing " + twitter.getScreenName() + "'s timeline: ");
                for(Status status : statuses){
                    System.out.println(status.getUser().getName() + ":" + status.getText());
                    System.out.println(status.getUser().getLocation());
                    System.out.println("Favorites: " + status.getUser().getFavouritesCount());
                }
            } catch (TwitterException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Test");
        System.out.println("Test12312312" +
                "");

    }

}
