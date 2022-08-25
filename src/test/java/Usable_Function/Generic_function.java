package Usable_Function;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Generic_function {

    public static WebDriver driver;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFCell cell,f;
    public static XSSFRow row;
    public static Set<String> s1;
    public static Iterator<String> i1;
    //1.
    public static String mainwindow,firefox= "geck",edge="msedge",chrome="chrome" ;
    static int size;
    public static int iter;
    public static boolean value1;
    public static WebElement val, element;
    static String ere,ptr,value,input;
    static WebElement ele,l,from,to,temp;
    public static int col;
    public static String CellData,path;
    public static String filepath,str;

    static File file = new File("config/serenity.properties");
    static Properties prop = new Properties();
    public static String getURL() {
        String URL= prop.getProperty("LOGIN_URL");
        if(URL!=null) return URL ;
        else throw new RuntimeException ("URL is not specified in the Config.properties");
    }
//1.
    public WebDriver browser_launch() throws IOException {
        FileInputStream fileInput;
        fileInput = new FileInputStream(file);
        prop.load(fileInput);
        path = getDriverPath().trim();
        if(path.contains(firefox))
        {
            System.setProperty("webdriver.gecko.driver",getDriverPath());
            driver = new FirefoxDriver();
        }
        else if (path.contains(edge)) {
            System.setProperty("webdriver.edge.driver", getDriverPath());
            driver = new EdgeDriver();
        }
        else
        {

//			System.setProperty("webdriver.chrome.driver",getDriverPath());
//			//driver = new ChromeDriver();
//			ChromeOptions options = new ChromeOptions();
//
//			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//			driver = new ChromeDriver(options);


            System.setProperty("webdriver.chrome.driver",getDriverPath());
//			driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

            options.addArguments("--disable-web-security");
            options.addArguments("--no-proxy-server");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);


            driver = new ChromeDriver(options);


        }
        driver.navigate().to(getURL());
        driver.manage().window().maximize();
        //((JavascriptExecutor)driver).executeScript("window.open()");
        //ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(1));
//		driver.get(getmedicareURL());
        //driver.switchTo().window(tabs.get(0));
        return driver;
    }




    //basic
    public static String getcsv() {
        path = prop.getProperty("Test_csv");
        if(path!=null) return path ;
        else throw new RuntimeException (" csv path is not specified in the Config.properties");
    }

    public static int Dataiter(){
        iter = Integer.parseInt(prop.getProperty("Data_iteration"));
        return iter;
    }
    /* Reading chrome driver path from config.properties file */
    public static String getDriverPath() {
        String driverpath= prop.getProperty("Driverpath");
        if(driverpath!=null) return driverpath ;
        else throw new RuntimeException ("Driverpath is not specified in the Config.properties");
    }
    /* Reading Excel file path  from config.properties   */
    public static String getFilepath() {
        String filepath= prop.getProperty("Filepath");
        if(filepath!=null) return filepath.trim();
        else throw new RuntimeException ("Filepath is not specified in the Config.properties");
    }
    /* To find object locator value of a particular fieldname passing to this function by loading */
    public static String OR_reader(String fieldname) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(getFilepath().trim()),Charset.forName("ISO-8859-1"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        for (CSVRecord csvRecord : csvParser) {
            String name = csvRecord.get(0);
            String val = csvRecord.get(2);
            if(name.equalsIgnoreCase(fieldname))
            {
                return val;
            }
        }
        return null;
    }

    /* Click operation for a particular fieldname that is passing to this function through finding locator value of fieldname using OR_reader function*/
    public static void click(String string) throws IOException  {
        driver.findElement(By.xpath(OR_reader(string))).click();
    }
    public static String td_reader(String fieldname,int index) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(getcsv().trim()),Charset.forName("ISO-8859-1"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        for (CSVRecord csvRecord : csvParser) {
            String name = csvRecord.get(0);
            String val = csvRecord.get(1);
            if(name.equalsIgnoreCase(fieldname))
            {
                String[] values = val.split(",");
                return values[index];
            }
        }
        return null;
    }


    /* To read test data value of a particular fieldname passing to this function from csv file */
    public static String td_reader(String fieldname) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(getcsv().trim()),Charset.forName("ISO-8859-1"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        for (CSVRecord csvRecord : csvParser) {
            String name = csvRecord.get(0);
            String val = csvRecord.get(1);
            if(name.equalsIgnoreCase(fieldname))
            {
                return val;
            }
        }
        return null;
    }
    private static String getDir() {
        // TODO Auto-generated method stub
        return null;
    }
//////////////////////////////////////
    //for registration
public WebDriver browsers_launch() throws IOException {
    FileInputStream fileInput;
    fileInput = new FileInputStream(file);
    prop.load(fileInput);
    path = getDriverPath().trim();
    if(path.contains(firefox))
    {
        System.setProperty("webdriver.gecko.driver",getDriverPath());
        driver = new FirefoxDriver();
    }
    else if (path.contains(edge)) {
        System.setProperty("webdriver.edge.driver", getDriverPath());
        driver = new EdgeDriver();
    }
    else
    {

//			System.setProperty("webdriver.chrome.driver",getDriverPath());
//			//driver = new ChromeDriver();
//			ChromeOptions options = new ChromeOptions();
//
//			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//			driver = new ChromeDriver(options);


        System.setProperty("webdriver.chrome.driver",getDriverPath());
//			driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);


        driver = new ChromeDriver(options);


    }
    driver.navigate().to(getURLS());
    driver.manage().window().maximize();
    //((JavascriptExecutor)driver).executeScript("window.open()");
    //ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    //driver.switchTo().window(tabs.get(1));
//		driver.get(getmedicareURL());
    //driver.switchTo().window(tabs.get(0));
    return driver;
}

    public static String getURLS() {
        String URL= prop.getProperty("URLS");
        if(URL!=null) return URL ;
        else throw new RuntimeException ("URL is not specified in the Config.properties");
    }
    @SuppressWarnings("deprecation")
    // Note : @SuppressWarnings annotation disables certain compiler warnings.
    public static void browser_wait(int time) {
        driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
    }
    public static void hover_verify() throws InterruptedException {
        // verify hover ssn id card working
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/div[2]/div[2]/form/div/div[1]/div[2]/p"));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();
        Thread.sleep(2000);
    }
    public static void registration_heading() throws IOException {
        str= driver.findElement(By.xpath(OR_reader("new_user_reg"))).getText();
        System.out.println(str);
        Assert.assertEquals(str,td_reader("new_user_reg"));
    }
    public static void scroll_down_tc() throws InterruptedException, IOException {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//*[@id=\"scroll-dialog-description\"]/div/div/div/ol[16]/li/ol/li[12]/a"));
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        driver.findElement(By.xpath(OR_reader("tc_ok")));
        click("tc_ok");
    }
    public static void scroll_down_privacy() throws InterruptedException, IOException {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"scroll-dialog-description\"]/div/div/ol/li[8]/span"));
        je.executeScript("arguments[0].scrollIntoView(true);",element1);
        driver.findElement(By.xpath(OR_reader("pp_ok")));
        click("pp_ok");
    }
    // generate an email id
    // screenshot

        public static  void takeScreenShot(String fileName) throws IOException {
            File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(getDir()+fileName+".png"));
        }
        public static void scrolldown() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,-350)", "");
        }


}
