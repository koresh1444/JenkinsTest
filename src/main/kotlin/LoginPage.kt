import com.automation.remarks.kirk.Browser
import com.automation.remarks.kirk.Page
import org.openqa.selenium.By

class LoginPage(browser: Browser): Page(browser) {

    override val url: String?
        get() = "https://www.facebook.com/login/"

    val loginHeader = element (By.id("header_block"))
    val loginField = element(By.id("email"))
    val passwordField = element(By.id("pass"))
    val enterButton = element(By.id("loginbutton"))


    //    Authed Page

    val dropdownMenu = element(By.id("userNavigationLabel")).firstChild()
    val exitButton = element(By.xpath("//*[@id=\"js_50\"]/div/div/ul/li[12]/a/span/span"))


    fun loginActionOnLoginPage(){
        loginField.clear()
        loginField.sendKeys("testkor1@ukr.net")
        passwordField.sendKeys("Test123456")
        enterButton.click()
    }

}