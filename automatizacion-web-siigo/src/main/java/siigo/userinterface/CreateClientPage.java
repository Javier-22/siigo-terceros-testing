package siigo.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;

public class CreateClientPage {
   public static final Target CLICK_TYPE = Target.the("Click type").located(ByShadow.cssSelector("div[class='mdc-select__anchor mdc-ripple-upgraded']","div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > siigo-dropdownlist-web:nth-child(1)"));
   public static final Target IDENTIFICATION = Target.the("Input identification").located(ByShadow.cssSelector(".mdc-text-field__input.input-identification","siigo-identification-input-web[class='hydrated']"));
    public static final Target NAMES = Target.the("Input name").located(ByShadow.cssSelector("input[class='mdc-text-field__input']","div:nth-child(1) > siigo-textfield-web:nth-child(1)"));
    public static final Target LAST_NAME = Target.the("Input lasName").located(ByShadow.cssSelector("input[class='mdc-text-field__input']","div:nth-child(2) > siigo-textfield-web:nth-child(1)"));
    public static final Target COMERCIAL = Target.the("Input comercial").located(ByShadow.cssSelector("input[class='mdc-text-field__input']","div:nth-child(3) > div:nth-child(4) > siigo-textfield-web:nth-child(1)"));
    public static final Target ADRESS = Target.the("input addres").located(ByShadow.cssSelector("input[class='mdc-text-field__input']","div:nth-child(3) > div:nth-child(6) > siigo-textfield-web:nth-child(1)"));



    public static final Target CITY = Target.the("City input in shadow")
            .located(ByShadow.cssSelector(
                    "input[class='mdc-text-field__input']",
                    "div:nth-child(3) > div:nth-child(5) >  siigo-autocomplete-web:nth-child(1)"
            ));

    public static final Target CITY_CLICK= Target.the("City input in shadow")
            .located(ByShadow.cssSelector(
                    "#labelAutocompleteSelectItemcity",
                    "div:nth-child(3) > div:nth-child(5) >  siigo-autocomplete-web:nth-child(1)"
            ));

    public static final Target SELECT_CITY= Target.the("City input in shadow")
            .located(ByShadow.cssSelector(
                    "#divTDAutocompletecity1",
                    "div:nth-child(3) > div:nth-child(5) >  siigo-autocomplete-web:nth-child(1)"
            ));



    public static final Target TYPE_IDENTIFICATION = Target.the("Select type identification").located(ByShadow.cssSelector("div[class='mdc-select__anchor mdc-ripple-upgraded']","div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > siigo-dropdownlist-web:nth-child(1)"));

    public static Target typeOfIdentification(String label) {
        String dataValueContains = String.format("\"label\":\"%s\"", label);
        return Target.the("List item with label " + label)
                .located(ByShadow.cssSelector(
                        String.format("li.mdc-list-item[data-value*='%s']", dataValueContains),
                        "div:nth-child(1) > div:nth-child(2) > siigo-dropdownlist-web:nth-child(1)"
                ));
    }

    public static Target typeOfPerson(String label) {
        String dataValueContains = String.format("\"label\":\"%s\"", label);
        return Target.the("List item with label " + label)
                .located(ByShadow.cssSelector(
                        String.format("li.mdc-list-item[data-value*='%s']", dataValueContains),
                        "div:nth-child(1) > div:nth-child(1) > siigo-dropdownlist-web:nth-child(1)"
                ));
    }



    public static final Target SAVE = Target.the("Click button Guardar").located(By.xpath("//button[normalize-space()='Guardar']"));

}
