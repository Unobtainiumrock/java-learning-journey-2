//package io.careerdeer;

public interface TwoDimensional {
	double calculatePerimeter();
	default boolean perimeterCanFitInside(TwoDimensional shape) {
		return shape.calculatePerimeter() > this.calculatePerimeter();
	};
}
//package io.careerdeer;

public interface TwoDimensional {
	double calculatePerimeter();
}

