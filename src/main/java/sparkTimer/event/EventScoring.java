package sparkTimer.event;

public enum EventScoring {
    TOP10, // 10...1
    TOP8,  // 10, 8, 6, 5...1
    TOP6,  // 10, 8, 6, 4, 2, 1
    TOP3DUAL,  // 3, 2, 1
    TOP3TRI,  // 5, 3, 1
    TOP3QUAD,  // 5, 3, 1
    PLACE_WISE
}
