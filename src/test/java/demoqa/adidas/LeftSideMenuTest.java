package demoqa.adidas;

import com.demoqa.enums.Brands;
import com.demoqa.enums.Category;
import com.demoqa.pages.BasePage;
import demoqa.BaseTest;
import org.testng.annotations.Test;

public class LeftSideMenuTest extends BaseTest {

    @Test
    public void  test() {
        browserManager.open("https://www.automationexercise.com/");
        leftSideMenu.chooseBrands(Brands.HM).chooseCategory(Category.WOMEN, "Dress");
    }
}
