import Pages.NotificationMessagePage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationMessageTest extends SetUpsForTests {
    private NotificationMessagePage notificationMessagePage;

    @BeforeEach
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        notificationMessagePage = new NotificationMessagePage(driver);
    }

    @RepeatedTest(10)
    @Description("Проверка уведомлений")
    public void testNotificationMessage() {
        notificationMessagePage.clickLinkClickHere();
        String messageText = notificationMessagePage.getNotificationMessage();
        assertTrue(messageText.contains("Action successful"), "Уведомление не содержит текст 'Action successful'. Актуальный текст: " + messageText);
    }
}
