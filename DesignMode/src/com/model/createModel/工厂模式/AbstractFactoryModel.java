package com.model.createModel.工厂模式;

/**
 * 抽象工厂模式
 * 抽象工厂模式是围绕一个超级工厂创建其他工厂。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 在抽象工厂模式中，含有一个超级工厂，它定义了工厂需要的东西，而具体工厂类会继承自它。
 * 主要解决：主要解决接口选择的问题。抽象工厂为你提供了一个接口，只要具体工厂类实现该接口，就不需要担心生成不一致的产品。
 * 何时使用：系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。且最初创建时不确定产品的种类
 * 如何解决：在一个产品族里面，定义多个产品。
 * 关键代码：在一个工厂里聚合多个同类产品。
 * 应用实例： 1、QQ 换皮肤，一整套一起换。 2、生成不同操作系统的程序。
 * 优点：
 * 1、当需要产品族时，它能保证客户端始终只使用同一个产品族中的产品。
 * 2、它提供了一种产品的类库，所有的产品以同样的接口出现，从而使客户端不依赖具体实现。
 * 3、它隔离了具体类的生成，使得客户端不需要知道什么被创建。
 * 4、每次增加一个产品族，只需要增加一个具体的工厂，无须修改已有代码。
 * 5、系统扩展方便，符合“开闭原则”。
 * 6、符合“合成复用原则”。
 * 7、符合“最少知识原则”。
 * 缺点：
 * 1、产品族的扩展非常困难，需要修改抽象工厂的接口。
 * 2、增加了系统的抽象性和理解难度。
 */
public class AbstractFactoryModel {

    public static void main(String[] args) {
        AbstractFactoryModel temp = new AbstractFactoryModel();
        temp.test();
    }

    public void test() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.startsWith("windows")) {
            WinFactory winFactory = new WinFactory();
            Application app = new Application(winFactory);
            app.paint();
        } else if (osName.startsWith("mac")) {
            MacFactory macFactory = new MacFactory();
            Application app = new Application(macFactory);
            app.paint();
        }
    }

    /**
     * 抽象工厂类
     */
    interface GUIFactory {
        Button createButton();

        Checkbox createCheckbox();
    }

    /**
     * 具体工厂类：windows实现
     */
    class WinFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new WinButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new WinCheckbox();
        }
    }

    /**
     * 具体工厂类：mac实现
     */
    class MacFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new MacCheckbox();
        }
    }

    /**
     * 抽象产品类：按钮
     */
    interface Button {
        void paint();
    }

    /**
     * 具体产品类：windows按钮
     */
    class WinButton implements Button {
        @Override
        public void paint() {
            System.out.println("You have created WindowsButton.");
        }
    }

    /**
     * 具体产品类：mac按钮
     */
    class MacButton implements Button {
        @Override
        public void paint() {
            System.out.println("You have created MacButton.");
        }
    }

    /**
     * 抽象产品类：复选框
     */
    interface Checkbox {
        void paint();
    }

    /**
     * 具体产品类：windows复选框
     */
    class WinCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("You have created WindowsCheckbox.");
        }
    }

    /**
     * 具体产品类：mac复选框
     */
    class MacCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("You have created MacCheckbox.");
        }
    }

    /**
     * 客户端具体类,不关注内部实现，只关注需要的工厂对象
     */
    class Application {
        private Button button;
        private Checkbox checkbox;

        Application(GUIFactory factory) {
            button = factory.createButton();
            checkbox = factory.createCheckbox();
        }

        void paint() {
            button.paint();
            checkbox.paint();
        }
    }

}
