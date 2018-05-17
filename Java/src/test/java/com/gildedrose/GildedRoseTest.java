package com.gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GildedRoseTest{
	
	private String name;
	private int sellInValue;
	private int qualityValue;
	private int expectedSellIn;
	private int expectedQuality;
	
	public GildedRoseTest(String name, int sellInValue, int qualityValue, int expectedSellIn, int expectedQuality) {
		super();
		this.name = name;
		this.sellInValue = sellInValue;
		this.qualityValue = qualityValue;
		this.expectedSellIn = expectedSellIn;
		this.expectedQuality = expectedQuality;
	}

	@Parameters(name = "{0}: sellIn {1} and quality {2}. Expected sellIn {3} and quality {4}")
	public static List<Object> data() {
		return Arrays.asList(
				new Object[] {"+5 Dexterity Vest", 10, 20, 9, 19},
				new Object[] {"+5 Dexterity Vest", 10, 0, 9, 0},
				new Object[] {"Aged Brie", 2, 0, 1, 1},
				new Object[] {"Magic Beer", 0, 10, -1, 8},
				new Object[] {"Aged Brie", 15, 50, 14, 50},
				new Object[] {"Sulfuras, Hand of Ragnaros", 0, 80, -1, 80},
				new Object[] {"Sulfuras, Hand of Ragnaros", -1, 80, -2, 80},
				new Object[] {"Backstage passes to a TAFKAL80ETC concert", 15, 20, 14, 21},
				new Object[] {"Backstage passes to a TAFKAL80ETC concert", 10, 40, 9, 42},
				new Object[] {"Backstage passes to a TAFKAL80ETC concert", 5, 40, 4, 43},
				new Object[] {"Backstage passes to a TAFKAL80ETC concert", 1, 40, 0, 0},
				new Object[] {"Backstage passes to a TAFKAL80ETC concert", 5, 1, 4, 4}, 
				new Object[] {"Conjured Mana Cake", 3, 6, 2, 4},
				new Object[] {"Conjured Mana Cake", 0, 6, -1, 2}, 
				new Object[] {"Elixir of the Mongoose", 5, 7, 4, 6});
	}
	
	GildedRose app;

	@Test
	public void processingSellInAndQualityItems() {
		Item[] items= new Item[] {new Item(name, sellInValue, qualityValue)};
		app = new GildedRose(items);
		app.updateQuality();
		assertEquals(expectedSellIn, app.items[0].sellIn);
		assertEquals(expectedQuality, app.items[0].quality);
	}
}
