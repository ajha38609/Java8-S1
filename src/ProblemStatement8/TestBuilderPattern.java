package ProblemStatement8;

import java.util.function.Consumer;

public class TestBuilderPattern {
    private int ram;
    private int storage;
    private int battery;
    private String camera;
    private String processor;
    private double screenSize;

    private TestBuilderPattern(MobileBuilder builder) {
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.battery = builder.battery;
        this.camera = builder.camera;
        this.processor = builder.processor;
        this.screenSize = builder.screenSize;
    }

    public static class MobileBuilder {
        private int ram;
        private int storage;
        private int battery;
        private String camera;
        private String processor;
        private double screenSize;

        public MobileBuilder with(Consumer<MobileBuilder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public TestBuilderPattern createMobile() {
            return new TestBuilderPattern(this);
        }
    }

    public static void main(String[] args) {
        TestBuilderPattern mobile = new TestBuilderPattern.MobileBuilder()
                .with(builder -> {
                    builder.ram = 4;
                    builder.storage = 0;
                    builder.battery = 4000;
                    builder.camera = "UMP";
                    builder.processor = "A12 Bionic";
                    builder.screenSize = 0.000000;
                })
                .createMobile();

        System.out.println("Specifications - RAM: " + mobile.ram +
                " Storage: " + mobile.storage +
                " Battery: " + mobile.battery +
                " Camera: " + mobile.camera +
                " Processor: " + mobile.processor +
                " Display: " + mobile.screenSize);
    }
}
