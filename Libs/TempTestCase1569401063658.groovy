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


RunConfiguration.setExecutionSettingFile('C:\\Users\\workFlow\\AppData\\Local\\Temp\\Katalon\\Test Cases\\AdviseraCommunityJoinNow\\20190925_104423\\execution.properties')

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
 * 1. Import paketa koji su potrebni za odradu testa
 * */ import javax.media.rtp.GlobalReceptionStats as GlobalReceptionStats
import javax.swing.JTable.ModelChange as ModelChange
import java.util.concurrent.ThreadLocalRandom as ThreadLocalRandom
import static java.lang.Math.toIntExact

/*
 * Registracija
 * Odlazak na lokaciju
 * Popunjavanje podataka
 * Otvaranje email-a i dohvaćanje linka
 * Otvaranje lokacije
 * Potvrda da smo ulogirani
 * 
 * */
/**
 * 2. Varijable testa
 * */
not_run: baseURL = 'http://advisera.devtvornica.org'

not_run: randomNum = ThreadLocalRandom.current().nextLong(1000000000, 9999999999 + 1).toString()

not_run: displayName = ('User ' + randomNum)

not_run: emailAddress = (('user' + randomNum) + '@harakirimail.com')

not_run: password = '123qwe'

not_run: harakiriMailUser = ('user' + randomNum)

/**
 * 3. Otvaranje preglednika i lokacije
 * */
not_run: WebUI.openBrowser('')

not_run: WebUI.navigateToUrl(baseURL + '/sign-up')

not_run: WebUI.maximizeWindow()

/**
 * 4. Popunjavanje podataka i završetak registracije
 * */
not_run: WebUI.setText(findTestObject('Object Repository/XPath', [('a') : '//input[@name="display_name"]']), displayName)

not_run: WebUI.setText(findTestObject('Object Repository/XPath', [('a') : '//input[@name="email"]']), emailAddress)

not_run: WebUI.setText(findTestObject('Object Repository/XPath', [('a') : '//input[@name="password"]']), password)

not_run: WebUI.setText(findTestObject('Object Repository/XPath', [('a') : '//input[@name="password_confirmation"]']), password)

not_run: WebUI.click(findTestObject('Object Repository/XPath', [('a') : '(//button[starts-with(@class,\\'button primary\\') and contains(text(),\\'JOIN NOW\\')])[1]']))

not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/XPath', [('a') : '(//p[contains(text(),\\'Successfully registered\\')])[1]']), 
    0)

/**
 * 5. Otvaranje harakirimail servisa, otvaranje registracijskog email-a i kopiranje linka
 * */
not_run: WebUI.navigateToUrl('https://harakirimail.com/inbox/' + harakiriMailUser)

not_run: WebUI.click(findTestObject('Object Repository/XPath', [('a') : '(//div[contains(text(),\\'Please activate your Expert Advice Community account\\')])[1]']))

not_run: WebUI.scrollToElement(findTestObject('Object Repository/XPath', [('a') : '(//img[@src=\\'http://advisera.devtvornica.org/wp-content/plugins/advisera-press/assets/images/logo-normal.png\\')])[1]']), 
    0)

not_run: Thread.sleep(1000)

not_run: verifyAccountLink = WebUI.getAttribute(findTestObject('Object Repository/XPath', [('a') : '(//a[contains(text(),\\'Verify account\\')])[1]']), 
    'href')

not_run: WebUI.navigateToUrl(verifyAccountLink)

/**
 * 6. Potvrda da je registracija odrađena do kraja
 * */
not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/XPath', [('a') : '(//p[contains(text(),\\'Thank you - your account is now confirmed\\')])[1]']), 
    0)

WebUI.scrollToElement(findTestObject('Object Repository/XPath', [('a') : '(//img[@src=\\'http://advisera.devtvornica.org/wp-content/plugins/advisera-press/assets/images/logo-normal.png\\')])[1]']), 
    0)

''', 'Test Cases/AdviseraCommunityJoinNow', new TestCaseBinding('Test Cases/AdviseraCommunityJoinNow',[:]), FailureHandling.STOP_ON_FAILURE , false)
    
