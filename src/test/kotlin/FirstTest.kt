
import com.automation.remarks.kirk.Kirk.Companion.drive
import com.automation.remarks.kirk.Kirk.Companion.open
import com.automation.remarks.kirk.core.sleep
import org.apache.commons.logging.LogFactory
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import org.openqa.selenium.By



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class FirstTest {

    private val log = LogFactory.getLog(FirstTest::class.java)
//    @Before fun setup(){
//        System.setProperty("webdriver.ie.driver", "C:\\Users\\oleksandr_korshun\\IdeaProjects\\aqa_cdp_Q1Q2_2018_Oleksandr_KorshunProject\\src\\main\\resources\\IEDriverServer.exe")
//        InternetExplorerDriver(InternetExplorerOptions())
//    }

    @Test fun `test1 login`(){

      drive {
          to (::MainPage){
              loginAction()
              log.info("Test message")
          }
      }
    }

    @Test fun `test2 Logout`(){
        drive {
            to (::MainPage){
                loginAction()
                sleep(2000)
                assert(userProfileButton.isDisplayed)
                logoutAction()
                assert(userAccount.isDisplayed)
            }
        }
    }

    @Test fun `test3 LoginAfterLogout`(){
        open(::MainPage){
            loginAction()
            sleep(2000)
            logoutAction()
            clickUserAccount()
            popUpPassField.sendKeys("Test123456")
            assert(userProfileButton.isDisplayed)
        }
    }

    @Test fun `test4 LoginViaRegistrationForm`(){
        open(::MainPage){
            registrationAction()
            confirmAge.click()
            sleep(5000)
            assert(userProfileButton.isDisplayed)
            logoutAction()
        }
    }

    @Test fun `test5 LoginViaLoginPage`(){
        open(::LoginPage){
            loginActionOnLoginPage()
            sleep(5000)
        }
    }

    @Test fun `test6 GetProfilePage`(){
        drive {
            to (::MainPage){
                loginAction()
                userProfileButton.click()
                assert(currentUrl.equals("https://www.facebook.com/alex.fortest.581"))
            }
        }
    }

    @Test fun `test7 GetProfileInfoPage`(){
        drive {
            to(::MainPage) {
                loginAction()
                userProfileButton.click()
                to(::ProfilePage){
                    infoSection.click()
                    sleep(1000)
                    assert(element(By.id("medley_header_about")).isDisplayed)
                    }
                }
            }
        }

    @Test fun `test8 GetProfileFriendsPage`(){
        drive {
            to (::MainPage){
                loginAction()
                userProfileButton.click()
                        to(::ProfilePage) {
                            friendSection.click()
                            sleep(1000)
                            assert(element(By.id("medley_header_friends")).isDisplayed)
                        }
                }
            }
        }

    @Test fun `test9 GetProfilePhotosPage`(){
        drive {
            to(::MainPage) {
                loginAction()
                        to(::ProfilePage) {
                            userProfileButton.click()
                            photoSection.click()
                            sleep(10000)
                            assert(element(By.id("medley_header_photos")).isDisplayed)
                        }
            }
        }
    }

    @Test fun `testt10 GetUserMessengerPage`(){
        drive {
            to(::MainPage) {
                loginAction()
                to(::ProfilePage){
                    userMessenger.click()
                    sleep(3000)
                    assert(currentUrl.equals("https://www.facebook.com/messages"))
                }

            }
        }
    }
}