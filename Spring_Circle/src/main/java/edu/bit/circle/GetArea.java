package edu.bit.circle;

public class GetArea {
	private double radius;
	private double width;
	private double height;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double circleArea() {
		return radius * radius * Math.PI;
	}

	public double recArea() {
		return width * height;
	}
}
