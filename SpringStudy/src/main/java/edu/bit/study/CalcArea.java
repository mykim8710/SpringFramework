package edu.bit.study;

public class CalcArea {
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double circleArea() {
		return radius * radius * Math.PI;
	}

}
