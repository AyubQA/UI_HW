import Pages.NotificationMessagePage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NotificationMessageTest extends SetUpsForTests {
    private NotificationMessagePage notificationMessagePage;

    @BeforeClass
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        notificationMessagePage = new NotificationMessagePage(driver);
    }

    @Test
    @Description("Проверка уведомлений")
    public void testNotificationMessage() {
        String messageText;
        do {
            notificationMessagePage.clickLinkClickHere();
            messageText = notificationMessagePage.getNotificationMessage();
            if (!messageText.contains("Action successful")) {
                notificationMessagePage.closeNotification();
            }
        } while (!messageText.contains("Action successful"));
        System.out.println("Уведомление успешно показано: " + messageText);
    }
}
