package designmode.factory.simple;

import designmode.factory.CircleShape;
import designmode.factory.Shape;
import designmode.factory.SquareShape;

/**
 * 简单工厂模式
 *
 * 一个实体的抽象，一个具体的工厂
 *
 * @author ：隋亮亮
 * @since ：2020/7/4 23:23
 */
public class SimpleFactory {
    public static final String CIRCLE_SHAPE = "Circle";
    public static final String SQUARE_SHAPE = "Square";

    public static Shape getShape(String shapeName) {
        switch (shapeName) {
            case CIRCLE_SHAPE:
                return new CircleShape();
            case SQUARE_SHAPE:
                return new SquareShape();
        }
        return null;
    }


    public static void main(String[] args) {
        Shape shape = SimpleFactory.getShape(SimpleFactory.CIRCLE_SHAPE);
        shape.drawShape();
    }
}
