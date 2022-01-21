package indigo_testing.shireburn.com.step_definitions;


import indigo_testing.shireburn.com.utilities.Driver;
import indigo_testing.shireburn.com.utilities.MyScreenRecorder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        try {
            MyScreenRecorder.deleteRecorded();
        }catch (Exception e){
            System.out.println(e);
        }

        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        scenario.write("Complete scenario: "+ scenario.getName());
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
        MyScreenRecorder.stopRecording();

    }
}
