import com.automation.remarks.kirk.Browser
import com.automation.remarks.kirk.Page
import org.openqa.selenium.By

class ProfilePage(browser: Browser): Page(browser) {
//    override val url: String?
//        get() = "https://www.facebook.com/alex.fortest.581"


    val userMessenger = element(By.xpath("//div[contains(text(), 'Messenger')]"))
    val friendSection = element(By.xpath("//a[contains(text(), 'Друзья')]"))
    val infoSection = element(By.xpath("//li[2]/a[contains(text(), 'Информация')]"))
    val photoSection = element(By.xpath("//a[contains(text(), 'Фото')]"))


}
