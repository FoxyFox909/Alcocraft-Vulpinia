package me.auroraluciri.alcocraftvulpinia.blocks.mugs.beer;

public enum BeerEnum {
    CHORUS_ALE,
    DIGGER_BITTER,
    DROWNED_ALE,
    GRONGLE_LAMBIC,
    ICE_BEER,
    KVASS,
    LEPRECHAUN_CIDER,
    MAGNET_PILSNER,
    NETHER_PORTER,
    NETHER_STAR_LAGER,
    NIGHT_RAUCH,
    SUN_PALE_ALE,
    WITHER_STOUT;

    public int getAlcoContent() {
        return switch (this) {
            case CHORUS_ALE:
                yield 100;
            case DIGGER_BITTER:
                yield 150;
            case DROWNED_ALE:
                yield 125;
            case GRONGLE_LAMBIC:
                yield 200;
            case ICE_BEER:
                yield 150;
            case KVASS:
                yield 20;
            case LEPRECHAUN_CIDER:
                yield 100;
            case MAGNET_PILSNER:
                yield 100;
            case NETHER_PORTER:
                yield 150;
            case NETHER_STAR_LAGER:
                yield 400;
            case NIGHT_RAUCH:
                yield 200;
            case SUN_PALE_ALE:
                yield 100;
            case WITHER_STOUT:
                yield 150;
        };
    }


}
