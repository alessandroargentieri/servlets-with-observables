package com.quicktutorialz.nio;

import com.quicktutorialz.nio.jetty.Jetty;
import com.quicktutorialz.nio.servlets.MyServletOne;
import com.quicktutorialz.nio.servlets.MyServletThree;
import com.quicktutorialz.nio.servlets.MyServletTwo;

public class MainApplication {

    public static void main(String[] args) throws Exception {
        new Jetty().port(8589)
                   .servlet(MyServletOne.class, "/to/uppercase")
                   .servlet(MyServletTwo.class, "/to/uppercase/reactive/*")
                   .servlet(MyServletThree.class, "/transform/*")
                   .start();
    }
}
