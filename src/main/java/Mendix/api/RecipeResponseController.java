package Mendix.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.core.Response;

public class RecipeResponseController {
	
	public RecipeResponseController() {
		
	}
	
	private static Map<Integer, Recipe> recipes = new HashMap<Integer, Recipe>();
	private static List<Recipe> recipes2;
	   
	/*
	static {
		//in de toekomst hier files uitlezen ofzo
		//recipes.put(1, new Recipe("\\n\\n{\\n   \\\"head\\\": {\\n      \\\"title\\\": \\\"Amaretto Cake\\\",\\n      \\\"categories\\\": [\\n         \\\"Liquor\\\",\\n         \\\"Cakes\\\",\\n         \\\"Cake mixes\\\"\\n      ],\\n      \\\"yield\\\": \\\"1\\\"\\n   },\\n   \\\"ingredients\\\": [\\n      {\\n         \\\"title\\\": [],\\n         \\\"ing\\\": [\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"1 1/2\\\",\\n                  \\\"unit\\\": \\\"cups\\\"\\n               },\\n               \\\"item\\\": \\\"Toasted Almonds; chopped\\\"\\n            },\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"1\\\",\\n                  \\\"unit\\\": \\\"package\\\"\\n               },\\n               \\\"item\\\": \\\"Yellow cake mix; no pudding\\\"\\n            },\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"1\\\",\\n                  \\\"unit\\\": \\\"package\\\"\\n               },\\n               \\\"item\\\": \\\"Vanilla instant pudding\\\"\\n            },\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"4\\\",\\n                  \\\"unit\\\": []\\n               },\\n               \\\"item\\\": \\\"Eggs\\\"\\n            },\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"1/2\\\",\\n                  \\\"unit\\\": \\\"cups\\\"\\n               },\\n               \\\"item\\\": \\\"Vegetable oil\\\"\\n            },\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"1/2\\\",\\n                  \\\"unit\\\": \\\"cups\\\"\\n               },\\n               \\\"item\\\": \\\"Water\\\"\\n            },\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"1/2\\\",\\n                  \\\"unit\\\": \\\"cups\\\"\\n               },\\n               \\\"item\\\": \\\"Amaretto\\\"\\n            },\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"1\\\",\\n                  \\\"unit\\\": \\\"teaspoon\\\"\\n               },\\n               \\\"item\\\": \\\"Almond extract\\\"\\n            }\\n         ]\\n      },\\n      {\\n         \\\"title\\\": \\\"GLAZE\\\",\\n         \\\"ing\\\": [\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"1/2\\\",\\n                  \\\"unit\\\": \\\"cups\\\"\\n               },\\n               \\\"item\\\": \\\"Sugar\\\"\\n            },\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"1/4\\\",\\n                  \\\"unit\\\": \\\"cups\\\"\\n               },\\n               \\\"item\\\": \\\"Water\\\"\\n            },\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"2\\\",\\n                  \\\"unit\\\": \\\"tablespoons\\\"\\n               },\\n               \\\"item\\\": \\\"Butter\\\"\\n            },\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"1/4\\\",\\n                  \\\"unit\\\": \\\"cups\\\"\\n               },\\n               \\\"item\\\": \\\"Amaretto\\\"\\n            },\\n            {\\n               \\\"amt\\\": {\\n                  \\\"qty\\\": \\\"1/2\\\",\\n                  \\\"unit\\\": \\\"teaspoons\\\"\\n               },\\n               \\\"item\\\": \\\"Almond extract\\\"\\n            }\\n         ]\\n      }\\n   ],\\n   \\\"directions\\\": {\\n      \\\"step\\\": \\\"Sprinkle 1 cup almonds into bottom of a well-greased       and floured 10\\\\\\\"\\\\n  tube pan; set aside. Combine cake mix,     pudding mix, eggs, oil, water,\\\\n  amaretto, and almond        extract in a mixing bowl; beat on low speed of\\\\n  an\\\\n         electric mixer til dry ingredients are moistened.          Increase\\\\n  speed to medium, and beat 4 minutes. Stir in      remaining 1/2 cup\\\\n  almonds. Pour batter into prepared       tube pan. Bake at 325~ for 1 hour\\\\n  or til a wooden pick inserted in center comes out clean. Cool cake in pan\\\\n    10-15 minutes; remove from pan, and cool completely.       Combine sugar,\\\\n  water, and butter in a small saucepan;      bring to a boil. Reduce heat to\\\\n  medium and gently boil     4-5 minutes, stirring occasionally, until sugar\\\\n  dissolves. Remove from heat, and cool 15 minutes. Stir\\\\n  in amaretto and almond extract. Punch holes in top of      cake with a\\\\n  wooden pick; slowly spoon glaze on top of cake, allowing glaze to absorb in\\\\n  cake.\\\\n  Posted to MC-Recipe Digest V1 #263\\\\n  \\\\n  Date: Sun, 27 Oct 1996 20:04:57 +0000\\\\n  \\\\n  From: Cheryl Gimenez <clgimenez@earthlink.net>\\\"\\n   }\\n}\\n\\n"));
    }
	*/
	
	public static List<Recipe> getAll() {
		List<Recipe> result = new ArrayList<Recipe>();
		for (Integer key : recipes.keySet()) {
			result.add(recipes.get(key));
		}
		// TODO Auto-generated method stub
		return result;
	}
	
	public static List<Recipe> getSearch(Optional<String> search) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String postRecipe(Recipe recipe) {
		 int key = 4;
		 if (recipes.containsValue(recipe.getHead().getTitle())) {
	         //Fix JSON output, html repsonses   
			 return "{not ok}";
	        } else {
	        	//Fix JSON output, html repsonses
	        	recipes.put(key, recipe);
	        	key++;
	            return "{ok}";
	        }
	}

	public static Recipe getById(String id) {
		//parse to INteger
		int idKey = Integer.parseInt(id);
		return recipes.get(idKey);
	}

	public static List<Recipe> getFilter() {
		// TODO Auto-generated method stub
		return null;
	}


}
