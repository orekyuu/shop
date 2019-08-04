package net.orekyuu.shop.core.domain.model.floor;

/**
 * 販売フロア
 */
public enum Floor {
    全年齢向け_同人("home", false),
    全年齢向け_コミック("comic", false),
    全年齢向け_PCソフト("soft", false),
    成人向け_同人("maniax", true),
    成人向け_成人コミック("books", true),
    成人向け_美少女ゲーム("pro", true);

    final String id;
    final boolean adult;


    Floor(String id, boolean adult) {
        this.id = id;
        this.adult = adult;
    }
}
