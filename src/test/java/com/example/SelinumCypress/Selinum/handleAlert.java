package com.example.SelinumCypress.Selinum;

@Test
public void handleAlert() {
    driver.get("http://example.com/alert");

    // Trigger the alert
    driver.findElement(By.id("triggerAlert")).click();

    // Switch to alert
    Alert alert = driver.switchTo().alert();
    String alertText = alert.getText();

    // Validate the alert text and accept it
    Assert.assertEquals(alertText, "Are you sure?");
    alert.accept();
}
