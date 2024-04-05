import Pages.ContextMenuPage;
import Pages.SetUP.SetUpsForTests;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContextMenuTest extends SetUpsForTests {
    @Test
    public void testContextMenu() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);

        contextMenuPage.rightClickOnBox();
        String alertText = contextMenuPage.getAlertText();
        contextMenuPage.acceptAlert();

        assertThat(alertText).as("Alert text is not as expected").isEqualTo("You selected a context menu");
    }
}
