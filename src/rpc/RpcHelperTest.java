package rpc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import entity.Item;
import entity.Item.ItemBuilder;

public class RpcHelperTest {
	// Converts a list of Item objects to JSONArray.
	public static JSONArray getJSONArray(List<Item> items) {
		JSONArray result = new JSONArray();
		try {
			for (Item item : items) {
				result.put(item.toJSONObject());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Test
	public void testGetJSONArrayCornerCases() throws JSONException {
		Set<String> category = new HashSet<String>();
		category.add("category one");

		List<Item> listItem = new ArrayList<Item>();
		JSONArray jsonArray = new JSONArray();
		JSONAssert.assertEquals(jsonArray, RpcHelperTest.getJSONArray(listItem), true);

		ItemBuilder oneBuilder = new ItemBuilder();
		oneBuilder.setItemId("one");
		oneBuilder.setRating(5);
		oneBuilder.setCategories(category);
		Item one = oneBuilder.build();
		ItemBuilder twoBuilder = new ItemBuilder();
		twoBuilder.setItemId("one");
		twoBuilder.setRating(5);
		twoBuilder.setCategories(category);
		Item two = twoBuilder.build();
		//Item one = new ItemBuilder().setItemId("one").setLatitude(33.33).setRating(5).setCategories(category).setLongitude(33.33).build();
		//Item two = new ItemBuilder().setItemId("two").setLatitude(33.33).setRating(5).setCategories(category).setLongitude(33.33).build();
		listItem.add(one);
		listItem.add(two);

		jsonArray.put(one.toJSONObject());
		jsonArray.put(two.toJSONObject());	
		JSONAssert.assertEquals(jsonArray, RpcHelperTest.getJSONArray(listItem), true);

//		Item empty = new ItemBuilder().build();
//		jsonArray.put(empty.toJSONObject());
//		JSONAssert.assertEquals(jsonArray, RpcHelperTest.getJSONArray(listItem), true);
	}

	@Test
	public void testGetJSONArray() throws JSONException {
		Set<String> category = new HashSet<String>();
		category.add("category one");
		ItemBuilder oneBuilder = new ItemBuilder();
		oneBuilder.setItemId("one");
		oneBuilder.setRating(5);
		oneBuilder.setCategories(category);
		Item one = oneBuilder.build();
		ItemBuilder twoBuilder = new ItemBuilder();
		twoBuilder.setItemId("one");
		twoBuilder.setRating(5);
		twoBuilder.setCategories(category);
		Item two = twoBuilder.build();
		//Item one = new ItemBuilder().setItemId("one").setRating(5).setCategories(category).setLongitude(33.33).build();
		//Item two = new ItemBuilder().setItemId("two").setRating(5).setCategories(category).setLongitude(33.33).build();
		List<Item> listItem = new ArrayList<Item>();
		listItem.add(one);
		listItem.add(two);

		JSONArray jsonArray = new JSONArray();
		jsonArray.put(one.toJSONObject());
		jsonArray.put(two.toJSONObject());

		JSONAssert.assertEquals(jsonArray, RpcHelperTest.getJSONArray(listItem), true);
	}
}
