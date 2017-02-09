package app.logic;

import java.util.Arrays;

class StringToGameOptionConverter {

    static GameOption convert(String stringOption) throws IllegalArgumentException {
        return Arrays.stream(GameOption.values())
                .filter(e -> e.name().equalsIgnoreCase(stringOption)).findAny().orElseThrow(
                        () -> new IllegalArgumentException("Invalid game option")
                );
    }

}