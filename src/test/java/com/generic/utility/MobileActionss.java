package com.generic.utility;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MobileActionss {

    public AppiumDriver driver;

    public MobileActionss(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Function to perform zoom-in (two fingers move apart)
    public void zoomIn(WebElement element) {
        // Get the center of the screen or the view you want to zoom in
        //WebElement element = driver.findElement(By.id("your_element_id")); // Update with your element's locator
        int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        // Create the sequences for both fingers
        List<Sequence> sequences = new ArrayList<>();

        // Finger 1 starts at the center
        Sequence finger1Move = new Sequence(finger1, 0);
        finger1Move.addAction(finger1.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), centerX, centerY));
        finger1Move.addAction(finger1.createPointerDown(0));

        // Finger 2 starts a little offset from the first finger
        Sequence finger2Move = new Sequence(finger2, 0);
        finger2Move.addAction(finger2.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), centerX + 100, centerY));
        finger2Move.addAction(finger2.createPointerDown(0));

        // Move both fingers outward to zoom in
        finger1Move.addAction(finger1.createPointerMove(Duration.ofSeconds(5), PointerInput.Origin.viewport(), centerX + 100, centerY));
        finger2Move.addAction(finger2.createPointerMove(Duration.ofSeconds(5), PointerInput.Origin.viewport(), centerX - 100, centerY));

        finger1Move.addAction(finger1.createPointerUp(0));
        finger2Move.addAction(finger2.createPointerUp(0));

        sequences.add(finger1Move);
        sequences.add(finger2Move);

        driver.perform(sequences);
    }

    // Function to perform zoom-out (two fingers move towards each other)
    public void zoomOut(WebElement element) {
        //WebElement element = driver.findElement(By.id("your_element_id")); // Update with your element's locator
        int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        // Create the sequences for both fingers
        List<Sequence> sequences = new ArrayList<>();

        // Finger 1 starts at the center
        Sequence finger1Move = new Sequence(finger1, 0);
        finger1Move.addAction(finger1.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), centerX, centerY));
        finger1Move.addAction(finger1.createPointerDown(0));

        // Finger 2 starts a little offset from the first finger
        Sequence finger2Move = new Sequence(finger2, 0);
        finger2Move.addAction(finger2.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), centerX + 100, centerY));
        finger2Move.addAction(finger2.createPointerDown(0));

        // Move both fingers inward to zoom out
        finger1Move.addAction(finger1.createPointerMove(Duration.ofSeconds(5), PointerInput.Origin.viewport(), centerX - 100, centerY));
        finger2Move.addAction(finger2.createPointerMove(Duration.ofSeconds(5), PointerInput.Origin.viewport(), centerX + 100, centerY));

        finger1Move.addAction(finger1.createPointerUp(0));
        finger2Move.addAction(finger2.createPointerUp(0));

        sequences.add(finger1Move);
        sequences.add(finger2Move);

        driver.perform(sequences);

    }

    // Perform swipe action with specific start (x1, y1) and end (x2, y2) coordinates
    public void swipe(int startX, int startY, int endX, int endY) {
        // Create PointerInput instance for touch actions
        PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Create sequence of touch actions for swipe
        Sequence swipeSequence = new Sequence(pointer, 0);

        // Move the pointer to the start position
        swipeSequence.addAction(pointer.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipeSequence.addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Move the pointer to the end position
        swipeSequence.addAction(pointer.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));

        // Release the pointer (simulate lifting the finger)
        swipeSequence.addAction(pointer.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        List<Sequence> actions = new ArrayList<>();
        actions.add(swipeSequence);
        // Perform the swipe action
        driver.perform(actions);
    }


}
