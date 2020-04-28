import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.WebDriverWait


class RegistrationPage(private val driver: WebDriver) {
    private val url = "http://localhost:8080/registerUserForm"

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(id = "id_l.R.user_fullName")
    lateinit var fullName: WebElement

    @FindBy(id = "id_l.R.user_login")
    lateinit var loginName: WebElement

    @FindBy(id = "id_l.R.password")
    lateinit var passwordField: WebElement

    @FindBy(id = "id_l.R.confirmPassword")
    lateinit var passwordConfirm: WebElement

    @FindBy(id = "id_l.R.user_email")
    lateinit var userEmail: WebElement

    @FindBy(id = "id_l.R.register")
    lateinit var registerBtn: WebElement

    @FindBy(className = "errorSeverity")
    lateinit var errorSeverity: WebElement


    fun open() = driver.get(url)
}