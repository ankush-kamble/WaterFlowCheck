package com.ankush.flowcheck.model;

public class UserInput {

	private String pipeOrPlate;
	
	private int velocity;
	
	private float diameter;
	
	private float x;

	@Override
	public String toString() {
		return "UserInput [pipeOrPlate=" + pipeOrPlate + ", velocity=" + velocity + ", diameter=" + diameter + ", x="
				+ x + "]";
	}

	public UserInput(String pipeOrPlate, int velocity, float diameter, float x) {
		super();
		this.pipeOrPlate = pipeOrPlate;
		this.velocity = velocity;
		this.diameter = diameter;
		this.x = x;
	}

	public String getPipeOrPlate() {
		return pipeOrPlate;
	}

	public void setPipeOrPlate(String pipeOrPlate) {
		this.pipeOrPlate = pipeOrPlate;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public float getDiameter() {
		return diameter;
	}

	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public UserInput() {
		// TODO Auto-generated constructor stub
	}
}
