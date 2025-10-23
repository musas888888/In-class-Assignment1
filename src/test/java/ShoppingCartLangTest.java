import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartLangTest {

    private void assertBundleHasKeys(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);
        assertNotNull(rb, "Bundle should load: " + locale);

    }

    @Test
    void loadsEnglishUS() { assertBundleHasKeys(new Locale("en","US")); }

    @Test
    void loadsFinnishFI() { assertBundleHasKeys(new Locale("fi","FI")); }

    @Test
    void loadsSwedishSE() { assertBundleHasKeys(new Locale("sv","SE")); }

    @Test
    void loadsJapaneseJP() { assertBundleHasKeys(new Locale("ja","JP")); }
}

