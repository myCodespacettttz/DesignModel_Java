package com.model.createModel.建造者模式;

public class House {
    private String floor;

    private String wall;

    private String roofed;

    private String window;

    private String garden;

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public String getGarden() {
        return garden;
    }

    public void setGarden(String garden) {
        this.garden = garden;
    }

    @Override
    public String toString() {
        return "House{" +
                "floor='" + floor + '\'' +
                ", wall='" + wall + '\'' +
                ", roofed='" + roofed + '\'' +
                ", window='" + window + '\'' +
                ", garden='" + garden + '\'' +
                '}';
    }

    public static class HouseBuilder {

        private House house;

        public HouseBuilder() {
            house = new House();
        }

        public HouseBuilder floor(String floor) {
            house.setFloor(floor);
            return this;
        }

        public HouseBuilder wall(String wall) {
            house.setWall(wall);
            return this;
        }

        public HouseBuilder roofed(String roofed) {
            house.setRoofed(roofed);
            return this;
        }

        public HouseBuilder window(String window) {
            house.setWindow(window);
            return this;
        }

        public HouseBuilder garden(String garden) {
            house.setGarden(garden);
            return this;
        }

        public House build() {
            return house;
        }
    }

}
