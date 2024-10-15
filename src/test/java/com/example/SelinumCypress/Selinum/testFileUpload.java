package com.example.SelinumCypress.Selinum;

@Test
public void testFileUpload() {
    driver.get("http://example.com/upload");

    // Locate the file input field and upload a file
    WebElement uploadElement = driver.findElement(By.id("fileUpload"));
    uploadElement.sendKeys("/path/to/file.png");

    // Submit the form
    driver.findElement(By.id("submit")).click();

    // Validate successful upload
    Assert.assertTrue(driver.findElement(By.id("uploadSuccess")).isDisplayed());
}
