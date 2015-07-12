package com.sahaj.testing;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

public class TestTwitterController extends TestCase {

    Tweet man1Tweeted;
    Tweet man2Tweeted;
    Twitter twitterMocked;
    TwitterController twitterController;

    @Before
    public void setUp() throws Exception {

        //Real objects used for Collaborator
        man1Tweeted = new Tweet("man1", "Is this the real life?");
        man2Tweeted = new Tweet("man2","Is this just fanta-sea?");

        //Mock the Twitter interface
        twitterMocked = mock(Twitter.class);

        //This is the class that I have created and I want to test it
        twitterController = new TwitterController(twitterMocked);
    }

    @Test
    public void testReadFeedAndTransformFeed(){

        when(twitterMocked.readFeed()).thenReturn("@man1 Is this the real life?|@man2 Is this just fanta-sea?");
        assertEquals(asList(man1Tweeted, man2Tweeted), twitterController.readFeed());
    }

    @Test
    public void testASuccessfulPostToTwitterShouldReturnSuccessStatus() {
        //Create a Mock of the Twitter interface
        Twitter twitterMocked = mock(Twitter.class);

        // Testing the created class
        TwitterController twitterController = new TwitterController(twitterMocked);

        String message = "Caught in a landslide, no escape from reality";
        when(twitterMocked.post(any(String.class))).thenReturn(true);

        boolean posted = twitterController.post(message);

        assertTrue(posted);
        verify(twitterMocked).post(message);
    }

    @Test
    public void testAFailedPostToTwitterShouldReturnFailedStatus() {
        //Mock the Twitter interface
        Twitter twitterMocked = mock(Twitter.class);

        //This is the class that I have created and I want to test it
        TwitterController twitterController = new TwitterController(twitterMocked);
        String message = "That's why they call me Mr.Fareinheit";
        when(twitterMocked.post(any(String.class))).thenReturn(false);

        boolean posted = twitterController.post(message);

        assertFalse(posted);
    }
}