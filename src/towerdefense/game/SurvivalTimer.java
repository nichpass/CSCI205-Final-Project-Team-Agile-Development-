package towerdefense.game;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * class that manages the timer displayed in the game screen
 */
public class SurvivalTimer {

    /** The amount of seconds the player has survived for **/
    private double secondsSurvived;

    /** The String that will be displayed on the screen **/
    private String timerString;

    /** The property necessary for bindings to be used in the UIController **/
    private StringProperty timerStringProperty;

    /**
     * Sets the initial values of the variables that correspond to zero-elapsed time
     */
    public SurvivalTimer(){
        this.timerString = "00:00";
        this.timerStringProperty = new SimpleStringProperty(timerString);
    }

    /**
     * Updates the timerString using timeSurived
     */
    public void update(){
        this.secondsSurvived += 1.0 / 60;

        int numMinutes = (int) this.secondsSurvived / (60);
        int numSeconds = (int) this.secondsSurvived % 60;

        this.timerString = numMinutes + ":" + numSeconds;
    }

    /**
     * Sets the timer back to zero
     */
    public void resetTimer(){
        this.secondsSurvived = 0.0;
    }

    public StringProperty getTimerAsStringProperty(){
        return this.timerStringProperty;
    }

    public void updateStringProperty(){
        this.timerStringProperty.setValue(this.timerString);
    }
}
