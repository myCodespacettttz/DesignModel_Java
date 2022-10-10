package com.model.createModel.工厂模式;


/**
 * 简单工厂模式
 * 定义一个创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。
 * 工厂模式是一种创建型设计模式，它提供了一种创建对象的最佳方式。
 * 在工厂模式中，我们不会对客户端暴露对象创建的逻辑，并且是通过一个共同的接口来指向新创建的对象。
 * <p>
 * 优点
 * 1、一个调用者想创建一个对象，只要知道其名称就可以了。
 * 2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。
 * 3、屏蔽产品的具体实现，调用者只关心产品的接口。
 * <p>
 * 缺点
 * 每次增加一个产品，都需要增加一个具体类和对象实现工厂，这增加了系统的复杂度。
 * 使用场景
 * 1、日志记录器，记录器的创建可以通过工厂方法模式来实现。
 * 2、数据库访问，当用户不知道最后系统采用哪一类数据库，以及数据库可能有变化时。
 * 3、加密方式，当用户不知道最后系统采用哪一种加密算法时。
 * 4、JDBC中的Connection对象的创建。
 * 5、在XML解析时，SAX和DOM的解析器的创建。
 * 6、在图形界面的应用程序中，每一个按钮都是一个产品，每一个按钮都是一个具体的产品类，当需要创建一个按钮时，只要调用工厂方法就可以。
 * <p>
 * 注意事项
 * 1、使用工厂模式时，我们需要把具体工厂类的类名写在配置文件中，而不是写在代码中。
 * 2、如果使用了Spring等第三方框架，可以直接使用框架提供的工厂模式。
 * 3、如果工厂类负责创建的对象过多，可以将其分解成若干个工厂类，这样可以提高系统的可维护性。
 * 4、系统扩展时，可以引入配置文件，用来存储新加入的具体工厂类和具体产品类的类名。一定程度上提高了系统的灵活性。
 */
public class FactoryModel {
    public static void main(String[] args) {
        FactoryModel factoryModel = new FactoryModel();
        factoryModel.test();
    }

    public void test() {
        product a = new create().createProduct("A");
        a.show();
    }

    interface product {
        public void show();
    }

    class create {
        public product createProduct(String type) {
            if (type.equals("A")) {
                return new productA();
            } else if (type.equals("B")) {
                return new productB();
            } else {
                return null;
            }
        }
    }

    class productA implements product {
        @Override
        public void show() {
            System.out.println("productA");
        }
    }

    class productB implements product {
        @Override
        public void show() {
            System.out.println("productB");
        }
    }

}
