
/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 12:10:08 PM
*
* Project: csci205_final_project
* Package: game
* File: SurvivalTimer
* Description:  A helper class that manages the display of time survived and 
* keeps track of the value.
*
* ****************************************
 */
package towerdefense.game;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A helper class that manages the display of time survived and keeps track of
 * the value.
 */
public class SurvivalTimer {

	private double secondsSurvived = 0;
	private final StringProperty timerStringProperty = new SimpleStringProperty(
			"00:00");

	/**
	 * Constructs a SurvivalTimer with no time elapsed.
	 */
	public SurvivalTimer() {
	}

	/**
	 * Updates the current string and decimal representations of time survived.
	 */
	public void update() {
		this.secondsSurvived += 1.0 / 60;

		int numMinutes = (int) this.secondsSurvived / (60);
		int numSeconds = (int) this.secondsSurvived % 60;

		this.timerStringProperty.set(
				String.format("%02d", numMinutes) + ":" + String.format(
				"%02d", numSeconds));
	}

	/**
	 * Resets the timer back to its initial value of 0 seconds having passed.
	 */
	public void resetTimer() {
		this.secondsSurvived = 0.0;
		this.timerStringProperty.set("00:00");
	}

	/**
	 * Returns the Property object associated with the time elapsed.
	 *
	 * @return the Property object associated with the time elapsed
	 */
	public StringProperty getTimerAsStringProperty() {
		return this.timerStringProperty;
	}

	/**
	 * Returns the decimal value of seconds survived.
	 *
	 * @return the number of seconds survived from the game's calculation by
	 * frames/ticks
	 */
	public double getSecondsSurvived() {
		return this.secondsSurvived;
	}
}
