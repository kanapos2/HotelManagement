package Model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Clock {

    public void showClock(Label label){
        Timeline c = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String clock = now.format(formatter);
            label.setText(clock);
        }),
                new KeyFrame(Duration.seconds(1))
        );
        c.setCycleCount(Animation.INDEFINITE);
        c.play();
    }

    public String showDate(){
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("EEEE dd MMM YYYY");
        return format.format(today);
    }

}
