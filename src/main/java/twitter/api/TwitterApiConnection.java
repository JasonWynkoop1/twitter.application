package twitter.api;

import twitter4j.*;

import java.util.List;

public class TwitterApiConnection {


        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses;


    {
        try {
            System.out.println("Hello");
            statuses = twitter.getHomeTimeline();
            System.out.println("Showing " + twitter.getScreenName() + "'s timeline: ");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":" + status.getText());
                System.out.println(status.getUser().getLocation());
                System.out.println("Favorites: " + status.getUser().getFavouritesCount());
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

}
