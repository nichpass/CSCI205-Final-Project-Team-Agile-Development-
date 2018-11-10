/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefense.game;

/**
 *
 * @author zachd
 */
public enum Difficulty
{
	EASY(0.75), MEDIUM(1.00), HARD(1.25);
	private double costMultiplier;

	Difficulty(double costMultiplier)
	{
		this.costMultiplier = costMultiplier;
	}

	public double getCostMultiplier()
	{
		return costMultiplier;
	}
}
