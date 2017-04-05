package atsdsi.framework.elements;
import org.openqa.selenium.WebElement;

import atsdsi.framework.pages.Page;

/**
 * Created by Sergii Rudenko on 05.04.2017.
 */

public class Title extends Element {

    public Title(WebElement webElement) {
        super(webElement);
    }

    public void printOut() {

            System.out.print(webElement.toString());

    }


}