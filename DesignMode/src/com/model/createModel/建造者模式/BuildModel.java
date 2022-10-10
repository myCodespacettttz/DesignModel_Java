package com.model.createModel.建造者模式;

/**
 * 建造者模式
 * 一：优点
 * 封装性好，如果一个对象属性较多，创建起来更加灵活，创建过程更加清晰
 *
 * 二：缺点
 * 产品组成部分必须相同，这限制了其使用范围。无太大缺点，对象创建复杂的场景下都可以使用
 *
 * 三：具体应用
 * ElasticSearch中的api：QueryBuilds，这是一个顶尖的建造者模式实现，通过建造者模式巧妙地实现了ES查询语句JSON格式的层级关系，控制了建造者模式的顺序以及逻辑关联性
 * StringBuilder
 */
public class BuildModel {
    public static void main(String[] args) {
        House.HouseBuilder houseBuilder = new House.HouseBuilder();
        House house = houseBuilder.floor("地板").wall("墙").roofed("屋顶").window("窗户").garden("花园").build();
        System.out.println(house);
    }
}
