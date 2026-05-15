package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners implements ITestListener {

    public void onStart(ITestContext arg)
    {
        System.out.println("Starts Test execution.... -" +arg.getName());
        System.out.println();
    }
    //This belongs to ITestListener and will execute after starting of Test set/batch
    public void onFinish(ITestContext arg)
    {
        System.out.println("Finish Test execution.... -" +arg.getName());
        System.out.println();

    }

    //This belongs to ITestListener and will execute before the main test start i.e. @Test
    public void onTestStart(ITestResult arg0)
    {
        System.out.println("Starts Test.... -" +arg0.getName());
        System.out.println();

    }

    //This belongs to ITestListener and will execute when a test is skipped
    public void onTestSkipped(ITestResult arg0)
    {
        System.out.println("Skipped Test.... -" +arg0.getName());
        System.out.println();

    }

    //This belongs to ITestListener and will execute when a test is passed
    public void onTestSuccess(ITestResult arg0)
    {
        System.out.println("Passed Test.... -" +arg0.getName());
        System.out.println();
    }

    //This belongs to ITestListener and will execute when a test is failed
    public void onTestFailure(ITestResult arg0)
    {
        System.out.println("Failed Test.... -" +arg0.getName());
        System.out.println();
    }

}
