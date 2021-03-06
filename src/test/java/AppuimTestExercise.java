import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static junit.framework.TestCase.assertNotNull;

public class AppuimTestExercise {

    private AndroidDriver<WebElement> driver;

    @Before
    public void setUp() throws Exception {
        // set up appium
        //File appDir = new File(System.getProperty("user.dir"), "../../../apps/TestApp/build/release-iphonesimulator");
        //File app = new File(appDir, "TestApp.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "5555");
        capabilities.setCapability("appActivity", ".ApiDemos");
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("automationName", "UiAutomator2");
        //capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //values = new ArrayList<Integer>();
    }
    

    //    @Test
//    public void testClick() throws InterruptedException {
//        Thread.sleep(1000);
//     driver.findElementByXPath("//*[@text='App']").click();
//     /* 滑动屏幕 */
//        Thread.sleep(5000);
//      new TouchAction(driver).press(500,500).moveTo(0,300).release().perform();
//      Thread.sleep(5000);
//         }
//
//    @Test
//    public void testLogs() throws InterruptedException {
//        System.out.println(driver.manage().logs().getAvailableLogTypes()); //输出内容为[logcat, client]
//        for(Object l:driver.manage().logs().get("logcat").getAll().toArray()){
//        System.out.println(l);
//        }
//    }
//
//    @Test
//    public void testPerformance() throws Exception {
//        System.out.println(driver.getSupportedPerformanceDataTypes()); //会输出【cpuinfo, memoryinfo, batteryinfo, networkinfo】
//        System.out.println(driver.getPerformanceData("io.appium.android.apis","memoryinfo",10));
//    }
//
//
//    @Test
//    public void testScrollTo(){
//        driver.findElementByAccessibilityId("Views").click();
//        AndroidElement list= (AndroidElement) driver.findElement(By.id("android:id/list"));
//        MobileElement radioGroup=list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text(\"Radio Group\"));"));
//        assertNotNull(radioGroup.getLocation());
// }
    @Test
    public void testToast() throws InterruptedException {
        //这步可能会需要滚动屏幕找到元素
        Thread.sleep(5000);
        driver.findElementByXPath("//*[@text='Views']").click();
        Thread.sleep(2000);
        for (int i = 0; i < 3; i++) {
            new TouchAction(driver).press(500, 700).waitAction().moveTo(0, 300).release().perform();
            //new TouchAction(driver).press(500,700).waitAction()
            Thread.sleep(2000);
        }
        driver.findElementByXPath("//*[contains(@text,'Popup')]").click();
        Thread.sleep(5000);
        System.out.println(driver.getPageSource());
        driver.findElementByXPath("//*[@content-desc='Make a Popup!']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='Search']").click();
        Thread.sleep(2000);
        System.out.println(driver.findElementByXPath("//*[@class='android.widget.Toast']").getText());
    }
//    @Test
//    public void testScrollTo1(){
//        driver.findElementByAccessibilityId("Views").click();
//        MobileElement webview = driver.findElement(By.id("android:id/list"))
//                .findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
//                        + "new UiSelector().text(\"WebView\"));"));
//        webview.click();
//        System.out.println(driver.getContextHandles());
//        for(AndroidElement e : driver.findElementsByXPath("//*")){
//            System.out.println(e.getTagName());
//            System.out.println(e.getText());
//        }
//        driver.context(driver.getContextHandles().toArray()[1].toString());
//        for(AndroidElement e : driver.findElementsByXPath("//*")){
//            System.out.println(e.getTagName());
//            System.out.println(e.getText());
//        }
//
//        Thread.sleep(10000);
//    }

//    @Test
//    public void testRotate() throws Exception {
//        driver.rotate(ScreenOrientation.LANDSCAPE);
//        driver.rotate(ScreenOrientation.PORTRAIT);
//        driver.findElementByXPath("//*[@text='App']").click();
//        Thread.sleep(1000);
//        driver.findElementByXPath("//*[@text='Alarm']").click();
//        driver.navigate().back();//效果为直接退出app//driver.openNotifications();Thread.sleep(5000);
//    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
