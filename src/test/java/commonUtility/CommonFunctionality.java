package commonUtility;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


//**
//common class used as helper for customize the Report like
// Take Screenshots and Set it in screenshots folder
// Called by TestBase class in tests package. 
//**

public class CommonFunctionality {


//** Take Screeshot Method used in case the The test is the test is failed.

    public static void captureScreenshot(WebDriver driver , String screenshotname)
    {
        Path dest = Paths.get("./screenShots",screenshotname+".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Excpetion while taking screenshot"+ e.getMessage());
        }
    }

}
