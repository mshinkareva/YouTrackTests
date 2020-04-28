import io.kotest.core.spec.autoClose
import io.kotest.core.spec.style.StringSpec
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit


class TestLogin : StringSpec() {
    private val driver: WebDriver = autoClose(WebDriverCloseable(ChromeDriver()))
    private val signupPage = LoginPage(driver)

    init {
        driver.manage()?.timeouts()?.implicitlyWait(5, TimeUnit.SECONDS)

        "Test1: Login success" {
            signupPage.run {
                open()
                loginInput.sendKeys("csr")
                password.sendKeys("1")
                loginButton.click()
                WebDriverWait(driver, 10).until { it.currentUrl == "http://localhost:8080/welcome" }

            }
        }

        "Test2: Login without username error" {
            signupPage.run {
                open()
                password.sendKeys("1")
                loginButton.click()
                WebDriverWait(driver, 10).until { errorSeverity.isDisplayed }
            }
        }

        "Test3: Login without password error" {
            signupPage.run {
                open()
                loginInput.sendKeys("csr")
                loginButton.click()
                WebDriverWait(driver, 10).until { errorSeverity.isDisplayed }
            }
        }
    }
}