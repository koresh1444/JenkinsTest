import com.automation.remarks.kirk.Browser
import com.automation.remarks.kirk.Page
import org.openqa.selenium.By

class MainPage(browser: Browser): Page(browser) {

    override val url: String?
        get() = "https://www.facebook.com/"

//    Unauthed Page
    val loginField = element(By.name("email"))
    val passwordField = element(By.id("pass"))
    val enterButton = element(By.id("loginbutton"))
    val popUpPassField = element(By.xpath("//div/input[@id = 'pass']"))

    val firstNameField = element(By.name("firstname"))
    val lastNameField = element(By.name("lastname"))
    val firstEmailConfirmField = element(By.name("reg_email__"))
    val seconfEmailConfirmField = element(By.name("reg_email_confirmation__"))
    val regPassword  = element(By.name("reg_passwd__"))
    val chooseManSexOptionEn = element(By.xpath("//label[contains(text(), 'Male')]"))
    val chooseManSexOptionRu = element(By.xpath("//label[contains(text(), 'Мужчина')]"))
    val registrationButton = element(By.name("websubmit"))
    val confirmAge = element(By.xpath("//button[contains(text(), 'Да')]"))
    val dontConfirmAge = element(By.xpath("//a[contains(text(), 'No')]"))


//    Authed Page
    val userProfileButton = element(By.xpath("//div[contains(text(), 'Alex Fortest')]"))
    val dropdownMenu = element(By.className("_5lxt"))
    val exitButton = element(By.xpath("//span[contains(text(), 'Выйти')]"))

//    Page after logout

    val userAccount = element(By.xpath("//div[contains(text(), 'Alex')]"))
    val otherLoginWindow = element(By.xpath("//button[contains(text(), 'Вход')]"))



    fun loginAction() {
        try {
            loginField.clear()
            loginField.sendKeys("testkor1@ukr.net")
            passwordField.sendKeys("Test123456")
            enterButton.click()
        }
        catch (ex: Exception) {

        }
    }
    fun logoutAction(){
        try {

        dropdownMenu.click()
        exitButton.click()
        }
        catch (ex: Exception){

        }
    }

    fun clickUserAccount(){
        userAccount.click()
    }

    fun registrationAction(){
        firstNameField.sendKeys("Alexfss")
        lastNameField.sendKeys("Korers")
        firstEmailConfirmField.sendKeys("testkor1@ukr.net")
        seconfEmailConfirmField.sendKeys("testkor1@ukr.net")
        regPassword.sendKeys("Test123456")
        try {
            chooseManSexOptionEn.click()
        }
        catch (ex :Exception){
            chooseManSexOptionRu.click()
        }


        registrationButton.click()

    }
}