package com.example.SelinumCypress.Selinum;

@Test
public void selectDropdownOption() {
    driver.get("http://example.com/dropdown");

    WebElement dropdown = driver.findElement(By.id("dropdown"));
    Select select = new Select(dropdown);
    select.selectByVisibleText("Option 2");

    // Validate that the correct option is selected
    Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
}
