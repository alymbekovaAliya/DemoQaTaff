package com.demoqa.pages.adidas;

import com.demoqa.drivers.DriverManager;
import com.demoqa.enums.Brands;
import com.demoqa.enums.Category;
import com.demoqa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LeftSideMenu extends BasePage {


    public LeftSideMenu chooseCategory(Category category, String into) {
        WebElement categ = DriverManager.getDriver().findElement(By.xpath("//a[@href='#"+ category.getCategory() +"']"));
        WebElement introToCategory = DriverManager.getDriver().findElement(By.xpath("//div[@id='"+ category.getCategory() +"']//a[normalize-space()='"+ into +"']"));

        actions.click(categ).click(introToCategory);

        return this;
    }

    public LeftSideMenu chooseBrands(Brands brands) {
        WebElement brand = DriverManager.getDriver().findElement(By.xpath("//a[@href='/brand_products/"+ brands.getName() +"']"));
        actions.click(brand);
        return this;
    }
}
