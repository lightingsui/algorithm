package designmode.factory.method;

import designmode.factory.Shape;

/**
 * 工厂方法模式
 *
 * 一个抽象工厂，多个实例工厂，一个抽象事务，多个实体
 *
 * @author ：隋亮亮
 * @since ：2020/7/4 23:39
 */
public class MethodFactory {
    public static void main(String[] args) {
        Factory factory = new SquareFactory();

        Shape shape = factory.getShape();

        shape.drawShape();
    }
}
