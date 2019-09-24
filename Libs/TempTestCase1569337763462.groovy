import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())


RunConfiguration.setExecutionSettingFile('C:\\Users\\workFlow\\AppData\\Local\\Temp\\Katalon\\Test Cases\\Screenshots\\20190924_170923\\execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runTestCaseRawScript(
'''import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
/**
 * 1. Import paketa koji su potrebni za odradu screenshota
 * */ import javax.imageio.ImageIO as ImageIO
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import ru.yandex.qatools.ashot.AShot as AShot
import ru.yandex.qatools.ashot.Screenshot as Screenshot
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy as ViewportPastingStrategy

/**
 * 2. Varijable testa
 * */
not_run: datotekaZaSpremanje = 'C:\\\\Responsive\\\\'

not_run: rezolucijeZaProvjeru = [320, 480, 768, 1024, 1280, 1366, 1440, 1920, 3840]

/**
 * 3. Otvaranje preglednika na određenoj lokaciji
 * */
not_run: WebUI.openBrowser('https://factory.hr')

/**
 * 4. Stvaranje driver objekta (WebDriver instanca koja je prethodno pokrenuta WebUI.openBrowser metodom)
 * */
not_run: WebDriver driver = DriverFactory.getWebDriver()

/**
 * 5. Fiksiranje headera u vrhu dokumenta i prihvaćanje kolačića
 * */
not_run: WebUI.executeJavaScript('document.querySelector(\\'.standard\\').style.position=\\'relative\\';', null, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.executeJavaScript('var elem = document.querySelector(\\'body > app-root:nth-child(3) > div:nth-child(2) > app-home:nth-child(2) > app-header-alt:nth-child(2) > header:nth-child(1)\\'); elem.parentNode.removeChild(elem);', 
    null, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.executeJavaScript('var elem = document.querySelector(\\'header.active\\'); elem.parentNode.removeChild(elem);', 
    null, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.click(findTestObject('Object Repository/XPath', [('a') : '(//a[starts-with(@class,\\'link\\') and contains(text(),\\'I get it!\\')])[1]']))

/**
 * 6. Odrada screenshota
 * */
not_run: for (def rezolucija : rezolucijeZaProvjeru) {
    /**
	* 7. Postavljanje rezolucije viewporta
	* */
    WebUI.setViewPortSize(rezolucija, 900)

    /**
	 * 8. Pauza za renderiranje view-a
	 * */
    Thread.sleep(500)

    /**
	 * 9. Postavljanje lokacije i naziva screenshota
	 * */
    lokacijaINaziv = (((datotekaZaSpremanje + 'Screenshot_Rezolucije_') + rezolucija) + '.png')

    /**
	 * 10. Stvaranje screenshot objekta (Screenshot instanca nad kojom se izvršava pomak od jedne visine viewporta svakih 100ms te se svaki pomak po redu spaja u jedan screenshot)
	 * */
    Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(100)).takeScreenshot(driver)

    /**
	 * 11. Spremanje spojenog screenshota na prethodno definiranu lokaciju i pod prethodno definiranim nazivom (lokacijaINaziv)
	 * */
    ImageIO.write(screenshot.getImage(), 'PNG', new File(lokacijaINaziv))
}

WebUI.click(findTestObject('Object Repository/XPath', [('a') : '(//a[starts-with(@class,\\'link\\') and contains(text(),\\'I get it!\\')])[1]']))

''', 'Test Cases/Screenshots', new TestCaseBinding('Test Cases/Screenshots',[:]), FailureHandling.STOP_ON_FAILURE , false)
    
