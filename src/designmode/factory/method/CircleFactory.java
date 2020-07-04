package designmode.factory.method;

import designmode.factory.CircleShape;
import designmode.factory.Shape;

/**
 * 圆形工厂
 *
 * @author ：隋亮亮
 * @since ：2020/7/4 23:40
 */
public class CircleFactory implements Factory {
    @Override
    public Shape getShape() {
        return new CircleShape();
    }
}
