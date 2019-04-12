//package io.careerdeer;

import io.careerdeer.Shape.Shapes;

public interface ThreeDimensional {
	double calculateVolume();

	Shape getChild();

	default boolean isTopOrBottom(TwoDimensional shape) {
		// circles to cylinders
		if (shape instanceof Circle && getChild().getShape().equals(Shapes.CYLINDER)
				|| ((Shape) shape).getShape().equals(Shapes.SQUARE) && getChild().getShape().equals(Shapes.CUBE)) {
			return ((Shape) shape).getX() == getChild().getX(); // Child is 3D shape implementing ThreeDimensional
		}
		return false;
	}
}
//package io.careerdeer;

public interface ThreeDimensional {
	double calculateVolume();
}

