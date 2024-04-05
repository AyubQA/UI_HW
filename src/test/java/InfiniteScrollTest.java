import Pages.InfiniteScrollPage;
import Pages.SetUP.SetUpsForTests;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InfiniteScrollTest extends SetUpsForTests {
    @Test
    public void testInfiniteScrollToText() {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        InfiniteScrollPage infiniteScrollPage = new InfiniteScrollPage(driver);

        infiniteScrollPage.scrollToText("Eius");
        boolean isTextVisible = infiniteScrollPage.isTextVisible("Eius");

        // Использование AssertJ для утверждения
        assertThat(isTextVisible).as("Текст 'Eius' не найден или не в поле зрения после прокрутки.").isTrue();
    }
}
