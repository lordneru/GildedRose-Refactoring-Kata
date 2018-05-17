package com.gildedrose;

class GildedRose {

	private static final int SELL_IN_DATE = 0;
	private static final int MIN_QUALITY_VALUE = 0;
	private static final int MAX_QUALITY_VALUE = 50;
	
	protected Item[] items;
	
	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			item.sellIn--;
			if (item.name.equals("Aged Brie")) {
				processAgedBrie(item);
			} else if (item.name.toLowerCase().contains("backstage")) {
				processBackstageItem(item);
			} else if (item.name.toLowerCase().contains("conjured")) {
				processConjuredItem(item);
			} else if (!item.name.toLowerCase().contains("sulfuras")) {
				processNormalItem(item);
			}
		}
	}

	private void processNormalItem(Item item) {
		int decrementValue = 1;
		if (item.sellIn < SELL_IN_DATE) {
			decrementValue++;
		}
		decrementItemQuality(item, decrementValue);
	}

	private void processAgedBrie(Item item) {
		incrementItemQuality(item, 1);
	}

	private void processBackstageItem(Item item) {
		if (item.sellIn == SELL_IN_DATE) {
			item.quality = MIN_QUALITY_VALUE;
			return;
		}
		int amountToIncrement = 1;
		if (item.sellIn <= 10) {
			amountToIncrement += 10 / item.sellIn;
		}
		incrementItemQuality(item, amountToIncrement);
	}

	private void processConjuredItem(Item item) {
		int amountToDecrement = 1;
		if (item.sellIn < SELL_IN_DATE) {
			amountToDecrement = 4;
		} else {
			amountToDecrement = 2;
		}
		decrementItemQuality(item, amountToDecrement);
	}

	private void incrementItemQuality(Item item, int amountToIncrement) {
		item.quality = Math.min(MAX_QUALITY_VALUE, item.quality + amountToIncrement);
	}

	private void decrementItemQuality(Item item, int amountToDecrement) {
		item.quality = Math.max(MIN_QUALITY_VALUE, item.quality - amountToDecrement);
	}
}