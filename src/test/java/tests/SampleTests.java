package tests;

import mockit.*;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import models.*;


@RunWith(JMockit.class)
public class SampleTests {

    @Injectable
    private Collaborator collaborator;

    @Tested
    private Performer performer;

    @Test
    public void testThePerformMethod(@Mocked Model model) {
        new Expectations() {{
            model.getInfo();result = "bar";
            collaborator.collaborate("bar"); result = true;
        }};
        performer.perform(model);
        new Verifications() {{
            collaborator.receive(true);
        }};
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.runClasses(SampleTests.class);
    }
}