package lambdasinaction.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by use on 2018/3/8.
 */
public class test {
    public static List<Dish> menu =
            Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));

    public void test() {
        menu.stream().filter(dish -> dish.getCalories() > 350).map(dish -> {
            return update(dish);
        }).collect(Collectors.toList());
    }

    public int update(Dish dish) {
        return 1;
    }
}
