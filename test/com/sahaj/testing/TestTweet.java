package com.sahaj.testing;

import org.junit.Test;

import static org.junit.Assert.*;


public class TweetTest {

    @Test
    public void shouldReturnTweeter(){
        Tweet maheshTweeted = new Tweet("mahesh", "Open your eyes");

        assertEquals("mahesh",maheshTweeted.whoTweeted());
    }

    @Test
    public void shouldReturnIfTweetWasTweetedCorrectly(){
        Tweet maheshTweeted = new Tweet("mahesh", "Look up to the sky and seeeee");

        assertEquals("Look up to the sky and seeeee",maheshTweeted.getTweet());
    }

    @Test
    public void testIfTheTweetsAreTheSame(){
        Tweet maheshTweeted = new Tweet("mahesh", "Look up to the sky and seeeee");
        Tweet maheshTweetedToo = new Tweet("mahesh", "Look up to the sky and seeeee");
        assertEquals(true,maheshTweeted.equals(maheshTweetedToo));
    }

    @Test
    public void testIfTweetsAreNotTheSame(){
        Tweet maheshTweeted = new Tweet("mahesh", "Look up to the sky and seeeee");
        Tweet maheshTweetedToo = new Tweet("mahesh", "I'm just a poor boy, I need no sympathy");
        assertEquals(false,maheshTweeted.equals(maheshTweetedToo));
    }
}