import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
 * */
import javax.media.rtp.GlobalReceptionStats
import javax.swing.JTable.ModelChange
import java.util.concurrent.ThreadLocalRandom
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
baseURL = "http://advisera.devtvornica.org"

randomNum = ThreadLocalRandom.current().nextLong(1000000000, 9999999999 + 1).toString()

displayName = "User " + randomNum

emailAddress = "user" + randomNum + "@harakirimail.com"

password = "123qwe"

harakiriMailUser = "user" + randomNum

/**
 * 3. Otvaranje preglednika i lokacije
 * */
WebUI.openBrowser("")

WebUI.navigateToUrl(baseURL + "/sign-up")

WebUI.maximizeWindow()

/**
 * 4. Popunjavanje podataka i završetak registracije
 * */
WebUI.setText(findTestObject('Object Repository/XPath', [('a') : '//input[@name="display_name"]']), displayName)

WebUI.setText(findTestObject('Object Repository/XPath', [('a') : '//input[@name="email"]']), emailAddress)

WebUI.setText(findTestObject('Object Repository/XPath', [('a') : '//input[@name="password"]']), password)

WebUI.setText(findTestObject('Object Repository/XPath', [('a') : '//input[@name="password_confirmation"]']), password)

WebUI.click(findTestObject('Object Repository/XPath', [('a') : '(//button[starts-with(@class,\'button primary\') and contains(text(),\'JOIN NOW\')])[1]']))

WebUI.verifyElementPresent(findTestObject('Object Repository/XPath', [('a') : '(//p[contains(text(),\'Successfully registered\')])[1]']), 0)


/**
 * 5. Otvaranje harakirimail servisa, otvaranje registracijskog email-a i kopiranje linka
 * */
WebUI.navigateToUrl('https://harakirimail.com/inbox/' + harakiriMailUser)

WebUI.click(findTestObject('Object Repository/XPath', [('a') : '(//div[contains(text(),\'Please activate your Expert Advice Community account\')])[1]']))

verifyAccountLink = WebUI.getAttribute(findTestObject('Object Repository/XPath', [('a') : '(//a[contains(text(),\'Verify account\')])[1]']), "href")

WebUI.navigateToUrl(verifyAccountLink)

/**
 * 6. Potvrda da je registracija odrađena do kraja
 * */

WebUI.verifyElementPresent(findTestObject('Object Repository/XPath', [('a') : '(//p[contains(text(),\'Thank you - your account is now confirmed\')])[1]']), 0)
