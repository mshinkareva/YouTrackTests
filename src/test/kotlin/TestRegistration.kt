import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.autoClose
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit
import org.openqa.selenium.support.ui.WebDriverWait




class TestRegistration : StringSpec() {
    private val driver: WebDriver = autoClose(WebDriverCloseable(ChromeDriver()))
    private val registrationPage = RegistrationPage(driver)
    private val username = "test_" + System.currentTimeMillis().toString()

    init {
        driver.manage()?.timeouts()?.implicitlyWait(5, TimeUnit.SECONDS)

        "Test1: Registration" {
            registrationPage.run {
                open()
                fullName.sendKeys(username)
                loginName.sendKeys(username)
                passwordField.sendKeys("1")
                passwordConfirm.sendKeys("1")
                userEmail.sendKeys(username + "@mail.ru")
                registerBtn.click()
                WebDriverWait(driver, 10).until { it.currentUrl == "http://localhost:8080/welcome" }
            }
        }

        "Test2: Registration without Full Name" {
            registrationPage.run {
                open()
                loginName.sendKeys(username)
                passwordField.sendKeys("1")
                passwordConfirm.sendKeys("1")
                userEmail.sendKeys(username + "@mail.ru")
                registerBtn.click()
                WebDriverWait(driver, 10).until { errorSeverity.isDisplayed }
            }
        }

        "Test3: Registration without Login Name" {
            registrationPage.run {
                open()
                fullName.sendKeys(username)
                passwordField.sendKeys("1")
                passwordConfirm.sendKeys("1")
                userEmail.sendKeys(username + "@mail.ru")
                registerBtn.click()
                WebDriverWait(driver, 10).until { errorSeverity.isDisplayed }
            }
        }

        "Test4: Registration without password: Error Password can't be empty" {
                registrationPage.run {
                    open()
                    fullName.sendKeys(username)
                    loginName.sendKeys(username)
                    userEmail.sendKeys(username+"@mail.ru")
                    registerBtn.click()
                    WebDriverWait(driver, 10).until { errorSeverity.isDisplayed }
                }
            }

        "Test5: Registration without password confirmation: Error Password can't be empty" {
            registrationPage.run {
                open()
                fullName.sendKeys(username)
                loginName.sendKeys(username)
                passwordConfirm.sendKeys("1")
                userEmail.sendKeys(username+"@mail.ru")
                registerBtn.click()
                WebDriverWait(driver, 10).until { errorSeverity.isDisplayed }
            }
        }
        "Test6: Registration without mail" {
            registrationPage.run {
                open()
                fullName.sendKeys(username)
                loginName.sendKeys(username)
                passwordField.sendKeys("1")
                passwordConfirm.sendKeys("1")
                registerBtn.click()
                WebDriverWait(driver, 10).until { errorSeverity.isDisplayed }
            }
        }
    }

}

