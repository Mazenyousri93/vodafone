package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class baseTests {

    // WebDriver instance to handle browser interactions
    public static WebDriver driver;

    // FileReader to read properties file
    public static FileReader file;

// static block to define properties file location and handle file not found exception
    static {
        try {
            file = new FileReader("src/test/resources/properties/prop.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

// instantiate properties file
    public static Properties prop = new Properties();

// constructor to handle exceptions
    public baseTests() throws IOException {

    }

    // Method to set up WebDriver and load the application URL
    public static void setUp() throws IOException {

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Load properties from the file
        prop.load(file);

        // Navigate to the specified URL
        driver.get(prop.getProperty("URL"));

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    // Method to close the WebDriver
    public static void tearDown(WebDriver driver) {
        driver.close();
    }
}