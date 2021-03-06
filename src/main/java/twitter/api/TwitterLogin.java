package twitter.api;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

public class TwitterLogin {


    {

        String testStatus = "Test status3";

        ConfigurationBuilder cb = new ConfigurationBuilder();


        try {
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            try {
                View gui = new View();
                System.out.println("-----");

                // get request token.
                // this will throw IllegalStateException if access token is already available
                // this is oob, desktop client version
                RequestToken requestToken = twitter.getOAuthRequestToken();



                gui.addText("Got request token.");
                gui.addText("Request token: " + requestToken.getToken());
                gui.addText("Request token secret: " + requestToken.getTokenSecret());

                System.out.println("-----");

                AccessToken accessToken = null;

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                while (null == accessToken) {
                    gui.addText("Open the following URL and grant access to your account:");
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(new URI(requestToken.getAuthorizationURL()));
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                    gui.addText("Enter the PIN(if available) and hit enter after you granted access.[PIN]:");
                    String pin = br.readLine();

                    try {
                        if (pin.length() > 0) {
                            accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                        } else {
                            accessToken = twitter.getOAuthAccessToken(requestToken);
                        }
                    } catch (TwitterException te) {
                        if (401 == te.getStatusCode()) {
                            System.out.println("Unable to get the access token.");
                        } else {
                            te.printStackTrace();
                        }
                    }
                }
                gui.addText("Got access token.");
                //gui.addText("Access token: " + accessToken.getToken());
                //gui.addText("Access token secret: " + accessToken.getTokenSecret());

            } catch (IllegalStateException ie) {
                // access token is already available, or consumer key/secret is not set.
                if (!twitter.getAuthorization().isEnabled()) {
                    System.out.println("OAuth consumer key/secret is not set.");
                    System.exit(-1);
                }
            }

            Status status = twitter.updateStatus(testStatus);

            System.out.println("Successfully updated the status to [" + status.getText() + "].");

            System.out.println("Exiting");

            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Failed to read the system input.");
            System.exit(-1);
        }
    }
}
