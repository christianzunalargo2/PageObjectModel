import com.Quizlet.Pages.QuizletPage;
import com.Quizlet.Pages.SingInPage;
import com.Quizlet.Pages.SingOutPage;
import com.Quizlet.Pages.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuizletTests extends BaseDriver{
    WebDriver driver;
    private QuizletPage quizletPage;
    private SingInPage singInPage;
    private WelcomePage welcomePage;
    private SingOutPage singOutPage;

    @BeforeClass
    public void beforeClass() {
        driver = getDriver();
    }

    @Test
    public void testQuizletTabTitle() {
        quizletPage = new QuizletPage(driver);
        
        String title  = quizletPage.getQuizletTitle();
        assertEquals(title, "Learning tools & flashcards, for free | Quizlet");
    }

    @Test(dependsOnMethods = {"testQuizletTabTitle"})
    @Parameters({"username", "password"})
    public void testQuizletLogin(String username, String password) {
        singInPage = quizletPage.clickLogIn();
        welcomePage = singInPage.login(username, password);
        assertNotNull(welcomePage);
    }

    @Test(dependsOnMethods = {"testQuizletLogin"})
    public void testQuizletLogOut() {
        welcomePage.clickAvatarDropDown();
//        singOutPage = welcomePage.clickLogOut();
//        assertNotNull(singOutPage);
//        String logOutHeader = singOutPage.getLogOutHeaderText();
//        assertEquals(logOutHeader, "YOU'VE LOGGED OUT SUCCESSFULLY.", "log out header not found");
    }
}
