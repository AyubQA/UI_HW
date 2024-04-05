import Pages.DragAndDropPage;
import Pages.SetUP.SetUpsForTests;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DragAndDropTest extends SetUpsForTests {
    @Test
    public void testDragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

        dragAndDropPage.dragAtoB();

        assertThat(dragAndDropPage.getColumnAText()).as("Элемент A не поменялся местами с элементом B").isEqualTo("B");
        assertThat(dragAndDropPage.getColumnBText()).as("Элемент B не поменялся местами с элементом A").isEqualTo("A");
    }
}
