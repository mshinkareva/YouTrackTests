import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.WebDriverWait


class LoginPage(private val driver: WebDriver) {
    private val url = "http://localhost:8080/loginForm"

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(id = "id_l.L.login")
    lateinit var loginInput: WebElement

    @FindBy(id = "id_l.L.password")
    lateinit var password: WebElement

    @FindBy(id = "id_l.L.loginButton")
    lateinit var loginButton: WebElement

    @FindBy(className = "errorSeverity")
    lateinit var errorSeverity: WebElement



    fun open() = driver.get(url)
}