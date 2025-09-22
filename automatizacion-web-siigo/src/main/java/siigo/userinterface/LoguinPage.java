package siigo.userinterface;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoguinPage {
    public static final Target USER = Target.the("Send email").located(By.xpath("//input[@id='siigoSignInName']"));
    public static final Target PASSWORD = Target.the("Send pasword").located(By.xpath("//input[@id='siigoPassword']"));
    public static final Target GET_INTO = Target.the("Click ingresar").located(By.id("siigoNext"));
    public static final Target INVALID_CREDENTIALS_MESSAGE = Target.the("Expected menssage invalid").located(By.xpath("//div[@id='siigoError']//p[contains(text(),'Usuario o contraseña')]"));
}
