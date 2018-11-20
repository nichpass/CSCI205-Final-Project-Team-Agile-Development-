package towerdefense.game;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * class that manages the timer displayed in the game screen
 */
public class SurvivalTimer {

    /** The time, in nanoSeconds, that the game started at */
    private double startTime;

    /** The amount of time the player has survived for **/
    private double timeSurvived;

    /** The String that will be displayed on the screen **/
    private String timerString;

    /** The property necessary for bindings to be used in the UIController **/
    private StringProperty timerStringProperty;

    /**
     * Sets the initial values of the variables that correspond to zero-elapsed time
     */
    public SurvivalTimer(){
        this.startTime = System.nanoTime();
        this.timerString = "00:00";
        this.timerStringProperty = new SimpleStringProperty(timerString);
    }

    /**
     * Updates the timerString using timeSurived
     */
    public void updateTime(){

        this.updateTimeSurvived();

        int numMinutes = (int) this.timeSurvived / 60;
        int numSeconds = (int) this.timeSurvived % 60;

        this.timerString = numMinutes + ":" + numSeconds;
    }

    /**
     * Updates timeSurvived using the difference between the start time and the current time
     */
    private void updateTimeSurvived(){
        double curTime = System.nanoTime();
        double elapsedTime = (curTime - startTime) * 1e9;
        this.timeSurvived = curTime - elapsedTime;
    }

    /**
     * Sets the timer back to zero
     */
    public void resetTimer(){
        this.startTime = System.nanoTime();
        this.updateTime();
    }

    public StringProperty getTimerStringProperty(){
        return this.timerStringProperty;
    }
}
