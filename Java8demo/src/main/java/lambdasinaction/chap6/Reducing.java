package lambdasinaction.chap6;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static lambdasinaction.chap6.Dish.menu;

public class Reducing {

    public static void main(String ... args) {
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesUsingSum());
    }

    private static int calculateTotalCalories() {
        return menu.stream().collect(reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        String shortMenu = menu.stream().map(Dish::getName).collect(reducing((s1, s2) -> s1+s2)).get();
        String shortMenu1= menu.stream().map(Dish::getName).collect(reducing("",(s1,s2)->s1+s2));
        String shortMenu2 = menu.stream().collect(reducing("",Dish::getName,(s1,s2)->s1+s2));
//        return menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCaloriesWithoutCollectors() {
        return menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
    }

    private static int calculateTotalCaloriesUsingSum() {
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }
}