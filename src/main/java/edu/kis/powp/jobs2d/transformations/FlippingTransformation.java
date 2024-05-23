package edu.kis.powp.jobs2d.transformations;



import java.awt.*;

public class FlippingTransformation extends Transformation {
    enum FlippingDirection {
        FLIP_VERTICALLY,
        FLIP_HORIZONTALLY,
        FLIP_BOTH_SIDES
    }

    private final FlippingDirection flippingDirection;

    private FlippingTransformation(FlippingDirection flippingDirection) {
        super("Test");
        this.flippingDirection = flippingDirection;
    }

    @Override
    public Point transform(Point point) {
        int flippedX = 0, flippedY = 0;

        switch (flippingDirection) {
            case FLIP_BOTH_SIDES: {
                flippedX = -point.x;
                flippedY =  -point.y;
                break;
            }
            case FLIP_VERTICALLY: {
                flippedY = -point.y;
                flippedX = point.x;
                break;
            }
            case FLIP_HORIZONTALLY: {
                flippedX = -point.x;
                flippedY = point.y;
                break;
            }
        }

        return new Point(flippedX, flippedY);
    }

    static public FlippingTransformation getFlipHorizontalDecorator() {
        return new FlippingTransformation( FlippingDirection.FLIP_HORIZONTALLY);
    }

    static public FlippingTransformation getFlipVerticalDecorator() {
        return new FlippingTransformation( FlippingDirection.FLIP_VERTICALLY);
    }

    static public FlippingTransformation getFlipBothSidesDecorator() {
        return new FlippingTransformation( FlippingDirection.FLIP_BOTH_SIDES);
    }
}
