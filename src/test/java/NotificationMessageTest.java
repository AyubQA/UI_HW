import Pages.NotificationMessagePage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

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
        if (!messageText.contains("Action successful")) {
            notificationMessagePage.closeNotification();
            String newMessageText = notificationMessagePage.getNotificationMessage();
            assertThat(newMessageText).as("Уведомление не содержит текст 'Action successful'. Актуальный текст: %s", newMessageText)
                    .contains("Action successful");
        } else {
            assertThat(messageText).as("Уведомление не содержит текст 'Action successful'. Актуальный текст: %s", messageText)
                    .contains("Action successful");
        }
    }
}
