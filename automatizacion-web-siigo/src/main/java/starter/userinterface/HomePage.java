package starter.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

public class HomePage {

    public static final Target SUCCESS_LOGIN_MESSAGE = Target.the("Verify login success").located(ByShadow.cssSelector("div[class='company-header-title']","siigo-header-molecule[class='data-siigo-five9 hydrated']"));
    public static final Target CREATE = Target.the("Click button Crear").located(ByShadow.cssSelector("div[class='wc--siigo dsm-siigo']","siigo-header-molecule[class='data-siigo-five9 hydrated']","siigo-button-atom[text='Crear']"));
    public static final Target CLIENTS = Target.the("Click option Clientes").located(ByShadow.cssSelector("a[data-value='Clientes']","siigo-header-molecule[class='data-siigo-five9 hydrated']"));

}
