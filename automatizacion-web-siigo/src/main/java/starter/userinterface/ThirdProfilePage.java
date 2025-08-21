package starter.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ThirdProfilePage {
    public static final Target THIRD_PROFILE = Target.the("Third profile").located(By.xpath("//div[@id='main']/div/app-third-party-view/div/div[1]/div[1]/h2"));
    public static final Target NAME_AND_LAST_NAME = Target.the("Name and las name").located(By.xpath("//div[@class='field spaceLongName']/p"));
    public static final Target IDENTIFICATION_EXPECTED = Target.the("Expected identification").located(By.xpath("//p[@class='text-rigth-header sub-head-size']"));
    public static final Target ACTIVE_STATUS = Target.the("Status in activo").located(By.xpath("//span[@class='text green']"));
}
