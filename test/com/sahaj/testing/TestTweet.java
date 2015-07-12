package com.sahaj.testing;

import org.junit.Test;

import static org.junit.Assert.*;


public class TweetTest {

    @Test
    public void shouldReturnWhoTweeted(){
        Tweet maheshTweeted = new Tweet("mahesh", "Open your eyes");

        assertEquals("mahesh",maheshTweeted.whoTweeted());
    }

    @Test
    public void shouldReturnTweetCorrectly(){
        Tweet maheshTweeted = new Tweet("mahesh", "Look up to the sky and seeeee");

        assertEquals("Look up to the sky and seeeee",maheshTweeted.getTweet());
    }

    @Test
    public void shouldReturnTrueIfTheTweetsAreTheSame(){
        Tweet maheshTweeted = new Tweet("mahesh", "Look up to the sky and seeeee");
        Tweet maheshTweetedAgain = new Tweet("mahesh", "Look up to the sky and seeeee");
        assertEquals(true,maheshTweeted.equals(maheshTweetedAgain));
    }

    @Test
    public void shouldReturnFalseIfTheTweetsAreTheSame(){
        Tweet maheshTweeted = new Tweet("mahesh", "Look up to the sky and seeeee");
        Tweet maheshTweetedAgain = new Tweet("mahesh", "I'm just a poor boy, I need no sympathy");
        assertEquals(false,maheshTweeted.equals(maheshTweetedAgain));
    }
}