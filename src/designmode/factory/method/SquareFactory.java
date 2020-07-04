package designmode.factory.method;

import designmode.factory.Shape;
import designmode.factory.SquareShape;

/**
 * 长方形工厂
 *
 * @author ：隋亮亮
 * @since ：2020/7/4 23:49
 */
public class SquareFactory implements Factory {
    @Override
    public Shape getShape() {
        return new SquareShape();
    }
}
