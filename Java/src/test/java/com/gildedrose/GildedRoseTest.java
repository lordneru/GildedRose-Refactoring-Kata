package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	Item[] items = new Item[] {};
	GildedRose app;

	@Test
	public void decreaseQualityAndSellInNormalItem() {
		items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(9, app.items[0].sellIn);
		assertEquals(19, app.items[0].quality);
	}

	@Test
	public void verifyQualityIsNotNegative() {
		items = new Item[] { new Item("+5 Dexterity Vest", 10, 0) };
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(9, app.items[0].sellIn);
		assertEquals(0, app.items[0].quality);
	}

	@Test
	public void decreaseQualityAndSellInAgedBrie() {
		items = new Item[] { new Item("Aged Brie", 2, 0) };
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(1, app.items[0].sellIn);
		assertEquals(1, app.items[0].quality);
	}

	@Test
	public void decreaseQualityTwiceWhenSellInIsNegative() {
		items = new Item[] { new Item("Magic Beer", 0, 10) };
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(-1, app.items[0].sellIn);
		assertEquals(8, app.items[0].quality);
	}

	@Test
	public void qualityShouldNotBeHigherThan50() {
		items = new Item[] { new Item("Aged Brie", 15, 50) };
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(14, app.items[0].sellIn);
		assertEquals(50, app.items[0].quality);
	}

	@Test
	public void sulfurasShouldNotBeSoldOrQualityDecreases() {
		items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(-1, app.items[0].sellIn);
		assertEquals(80, app.items[0].quality);
		assertEquals(-2, app.items[1].sellIn);
		assertEquals(80, app.items[1].quality);
	}

	@Test
	public void backstagePassesCase() {
		items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40) };
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(14, app.items[0].sellIn);
		assertEquals(21, app.items[0].quality);
		assertEquals(9, app.items[1].sellIn);
		assertEquals(42, app.items[1].quality);
		assertEquals(4, app.items[2].sellIn);
		assertEquals(43, app.items[2].quality);
	}

	@Test
	public void backstageQualityShouldBe0WhenSellInIs0() {
		items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 40) };
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.items[0].sellIn);
		assertEquals(0, app.items[0].quality);
	}

	@Test
	public void backstageQualityShouldBe0WhenSellInIs2() {
		items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1) };
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(4, app.items[0].sellIn);
		assertEquals(4, app.items[0].quality);
	}

	@Test
	public void conjuredShouldDegradeTwiceFaster() {
		items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(2, app.items[0].sellIn);
		assertEquals(4, app.items[0].quality);
	}

	@Test
	public void conjuredShouldDegradeTwiceFasterWhenSellInLessThan0() {
		items = new Item[] { new Item("Conjured Mana Cake", 0, 6) };
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(-1, app.items[0].sellIn);
		assertEquals(2, app.items[0].quality);
	}

	@Test
	public void normalItem() {
		items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(4, app.items[0].sellIn);
		assertEquals(6, app.items[0].quality);
	}
}
