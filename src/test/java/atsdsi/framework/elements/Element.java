package atsdsi.framework.elements;

/**
 * Created by Sergii Rudenko on 05.04.2017.
 */
import org.openqa.selenium.WebElement;

public class Element {
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    // универсальные методы для всех элементов
}
