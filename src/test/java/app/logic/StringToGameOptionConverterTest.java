package app.logic;

import java.lang.Object;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringToGameOptionConverterTest {

    @DataProvider(name = "correctOptionsDataProvider")
    private Object[][] correctOptionsDataProvider() {
        return new Object[][] {{"rock"}, {"paper"}, {"scissors"}};
    }

    @Test(dataProvider = "correctOptionsDataProvider")
    public void correctConversionTest(String option) {
        GameOption result = StringToGameOptionConverter.convert(option);
        assertEquals(result, GameOption.valueOf(option.toUpperCase()));
    }

    @DataProvider(name = "incorrectOptionsDataProvider")
    private Object[][] incorrectOptionsDataProvider() {
        return new Object[][] {{"rocka"}, {"apaper"}, {"scisssors"}};
    }

    @Test(dataProvider = "incorrectOptionsDataProvider", expectedExceptions = IllegalArgumentException.class)
    public void incorrectConversionTest(String option) {
        StringToGameOptionConverter.convert(option);
    }

}