import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.FindBy


class IssuesPage(private val driver: WebDriver) {
    private val url = "http://localhost:8080/issues"

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(id = "id_l.I.ui.newIssueLink")
    lateinit var newIssue: WebElement

    @FindBy(xpath = "//*[contains(text(), 'Issues')]")
    lateinit var issues: WebElement

    @FindBy(xpath = "//*[contains(text(), 'Welcome')]")
    lateinit var welcome: WebElement

    @FindBy(id = "id_l.W.ni.ei.eit.summary")
    lateinit var issueSummary: WebElement

//    @FindBy(className = @param:test)
//    lateinit var issueName: WebElement




    fun open() = driver.get(url)
}