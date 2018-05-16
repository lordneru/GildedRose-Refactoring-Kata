package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20),
			new Item("Aged Brie", 2, 0),
			new Item("Elixir of the Mongoose", 5, 7),
			new Item("Sulfuras", 0, 80),
			new Item("Sulfuras", -1, 80),
			new Item("Backstage", 15, 20),
			new Item("Backstage", 10, 49),
			new Item("Backstage", 5, 49),
			new Item("Conjured Mana Cake", 3, 6) };
	
	GildedRose app = new GildedRose(items);
	
	@Test
	public void decreaseQualityNormalItems() {
		app.updateQuality();
		assertEquals(19, app.items[0].quality);
		assertEquals(10, app.items[0].sellIn);
	}

}
