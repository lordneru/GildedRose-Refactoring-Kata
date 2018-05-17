package com.gildedrose;

class GildedRose {

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
			} else if (item.name.toLowerCase().contains("sulfuras")) {
				processSulfurasItem(item);
			} else if (item.name.toLowerCase().contains("conjured")) {
				processConjuredItem(item);
			} else {
				processNormalItem(item);
			}
		}
	}

	private void processNormalItem(Item item) {
		if (item.quality > 0) {
			item.quality--;
			if (item.sellIn < 0) {
				item.quality--;
			}
		}
	}

	private void processSulfurasItem(Item item) {
		// Do nothing more
	}

	private void processAgedBrie(Item item) {
		incrementItemQuality(item);
	}

	private void processBackstageItem(Item item) {
		if (item.sellIn == 0) {
			item.quality = 0;
			return;
		}
		incrementItemQuality(item);

		if (item.sellIn <= 10) {
			incrementItemQuality(item);
		}
		if (item.sellIn <= 5) {
			incrementItemQuality(item);
		}
	}

	private void processConjuredItem(Item item) {
		if (item.quality > 0 && item.sellIn < 0) {
			item.quality = item.quality - 4;
		} else {
			item.quality = item.quality - 2;
		}
	}

	private void incrementItemQuality(Item item) {
		item.quality = Math.min(50, item.quality + 1);
	}

	// public void updateQualityLegacy() {
	// for (int i = 0; i < items.length; i++) {
	// if (!items[i].name.equals("Aged Brie")
	// && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
	// if (items[i].quality > 0) {
	// if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
	// items[i].quality = items[i].quality - 1;
	// }
	// }
	// } else {
	// if (items[i].quality < 50) {
	// items[i].quality = items[i].quality + 1;
	//
	// if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
	// if (items[i].sellIn < 11) {
	// if (items[i].quality < 50) {
	// items[i].quality = items[i].quality + 1;
	// }
	// }
	//
	// if (items[i].sellIn < 6) {
	// if (items[i].quality < 50) {
	// items[i].quality = items[i].quality + 1;
	// }
	// }
	// }
	// }
	// }
	//
	// if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
	// items[i].sellIn = items[i].sellIn - 1;
	// }
	//
	// if (items[i].sellIn <= 0) {
	// if (!items[i].name.equals("Aged Brie")) {
	// if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
	// if (items[i].quality > 0) {
	// if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
	// items[i].quality = items[i].quality - 1;
	// }
	// }
	// } else {
	// items[i].quality = items[i].quality - items[i].quality;
	// }
	// } else {
	// if (items[i].quality < 50) {
	// items[i].quality = items[i].quality + 1;
	// }
	// }
	// }
	// }
	// }
}