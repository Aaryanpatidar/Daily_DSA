import java.util.*;

class FoodRatings {
    Map<String, String> foodToCuisine;
    Map<String, Integer> foodToRating;
    Map<String, TreeSet<String>> cuisineToFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String f = foods[i];
            String c = cuisines[i];
            int r = ratings[i];

            foodToCuisine.put(f, c);
            foodToRating.put(f, r);

            cuisineToFoods.putIfAbsent(c, new TreeSet<>(
                (a, b) -> {
                    int ra = foodToRating.get(a);
                    int rb = foodToRating.get(b);
                    if (ra != rb) return rb - ra;   
                    return a.compareTo(b);         
                }
            ));

            cuisineToFoods.get(c).add(f);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);

        cuisineToFoods.get(cuisine).remove(food);

        foodToRating.put(food, newRating);

       cuisineToFoods.get(cuisine).add(food);
    }
    
    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first(); 
    }
}
