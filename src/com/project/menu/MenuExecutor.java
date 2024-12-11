package com.project.menu;

import com.project.enums.Color;
import com.project.enums.DeviceType;
import com.project.factories.DeviceStaticFactory;
import com.project.factories.ProjectorStaticFactory;
import com.project.models.Device;
import com.project.models.Projector;

import java.util.*;
import java.util.stream.Stream;

public class MenuExecutor {
    public void start() {
        System.out.println("_".repeat(30));
        System.out.println("Task 1");
        System.out.println("_".repeat(30));
        executeTask1();
        System.out.println("_".repeat(30));
        System.out.println("Task 2");
        System.out.println("_".repeat(30));
        executeTask2();
        System.out.println("_".repeat(30));
        System.out.println("Task 3");
        System.out.println("_".repeat(30));
        executeTask3();
        System.out.println("_".repeat(30));
        System.out.println("Task 4");
        System.out.println("_".repeat(30));
        executeTask4();
        System.out.println("_".repeat(30));
    }

    private void executeTask1() {
        Random random = new Random();
        List<Integer> list = Stream.generate(() -> random.nextInt(-200, 200))
                .limit(30).toList();
        System.out.println("List elements: " + Arrays.toString(list.toArray()));
        System.out.println("Positive count: " + list.stream().filter(x -> x > 0).count());
        System.out.println("Negative count: " + list.stream().filter(x -> x < 0).count());
        System.out.println("2 digits count: " + list.stream().filter(x -> (x >= 10 && x < 100)).count());
        System.out.println("Mirror numbers count: " + list.stream().filter(x -> {
            String number = String.valueOf(x);
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) != number.charAt(number.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }).count());
    }

    private void executeTask2() {
        String[] productsContainer = new String[]{"Cows milk", "Eggs", "Bread", "Coconut milk", "Cheese", "Yogurt", "Apples", "Bananas", "Oranges", "Tomatoes", "Potatoes", "Onions", "Carrots", "Chicken", "Beef", "Fish", "Rice", "Pasta", "Flour", "Sugar"};

        Random random = new Random();
        List<String> products = Stream.generate(
                        () -> productsContainer[random.nextInt(0, productsContainer.length)])
                .limit(15).toList();
        System.out.println("Products list: " + Arrays.toString(products.toArray()));
        System.out.println("Products with less than 5 symbols in name: ");
        products.stream().filter(x -> x.length() < 5).distinct().forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String entered = scanner.nextLine();
        System.out.println("There is " + products.stream().filter(x -> x.equalsIgnoreCase(entered)).count() + " of this product");
        System.out.print("Enter the first letter of a product name: ");
        char c = scanner.next().charAt(0);
        System.out.println("Products that starts with that letter: ");
        products.stream().filter(x -> Character.toLowerCase(x.charAt(0)) == Character.toLowerCase(c)).distinct().forEach(System.out::println);
        System.out.println("Products in Milk category: ");
        // У нас по условию просто названия продуктов, я понятия не имею откуда мне брать
        // категорию, поэтому добавил в изначальный массив 2 вида молока.
        products.stream().filter(x -> x.toLowerCase().contains("milk")).distinct().forEach(System.out::println);
    }

    void executeTask3() {
        List<Device> list = Stream.generate(DeviceStaticFactory::getDevice)
                .limit(10).toList();
        System.out.println("Devices list:");
        list.forEach(System.out::println);

        int answ;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Choose the color (number only): ");
            for (var color : Color.values()) {
                System.out.println(color.ordinal() + 1 + ". " + color);
            }
            answ = scanner.nextInt();
        } while (answ < 1 || answ > Color.values().length);
        System.out.println("Devices with that color: ");
        final int finalAnsw1 = answ;
        list.stream().filter(x -> x.getColor().ordinal() == finalAnsw1 - 1).forEach(System.out::println);

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        System.out.println("Devices produced in that year: ");
        list.stream().filter(x -> x.getYear() == year).forEach(System.out::println);

        System.out.print("Enter the minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.println("Devices with price higher than that: ");
        list.stream().filter(x -> x.getPrice() > minPrice).forEach(System.out::println);

        do {
            System.out.println("Choose the device type (number only): ");
            for (var type : DeviceType.values()) {
                System.out.println(type.ordinal() + 1 + ". " + type);
            }
            answ = scanner.nextInt();
        } while (answ < 1 || answ > DeviceType.values().length);
        System.out.println("Devices with that type: ");
        final int finalAnsw2 = answ;
        list.stream().filter(x -> x.getType().ordinal() == finalAnsw2 - 1).forEach(System.out::println);

        int rangeFrom;
        int rangeTo;
        do {
            System.out.print("Enter the range of years: from ");
            rangeFrom = scanner.nextInt();
            System.out.print("to ");
            rangeTo = scanner.nextInt();
        } while (rangeFrom > rangeTo);
        System.out.println("Devices produced in that range: ");
        final int finalRangeFrom = rangeFrom;
        final int finalRangeTo = rangeTo;
        list.stream().filter(x -> x.getYear() >= finalRangeFrom && x.getYear() <= finalRangeTo).forEach(System.out::println);
    }

    void executeTask4() {
        List<Projector> list = Stream.generate(ProjectorStaticFactory::getProjector)
                .limit(15).toList();

        System.out.println("Projectors list:");
        list.forEach(System.out::println);

        System.out.println("All Sony and HP projectors: ");
        list.stream().filter(x -> x.getManufacturer().equals("Sony") || x.getManufacturer().equals("HP")).forEach(System.out::println);

        System.out.println("All 2024 projectors: ");
        list.stream().filter(x -> x.getYear() == 2024).forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.println("Projectors with price higher than that: ");
        list.stream().filter(x -> x.getPrice() > minPrice).forEach(System.out::println);

        System.out.println("Projectors sorted by price ascending: ");
        list.stream().sorted(Comparator.comparingDouble(Projector::getPrice)).forEach(System.out::println);

        System.out.println("Projectors sorted by price descending: ");
        list.stream().sorted((a,b)-> Double.compare(b.getPrice(), a.getPrice())).forEach(System.out::println);

        System.out.println("Projectors sorted by year ascending: ");
        list.stream().sorted(Comparator.comparingInt(Projector::getYear)).forEach(System.out::println);

        System.out.println("Projectors sorted by year descending: ");
        list.stream().sorted((a,b)-> Integer.compare(b.getYear(), a.getYear())).forEach(System.out::println);
    }
}
