package com.company.services;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class Driver {

    private ArrayList<QuestionObject> questionObjects;
    private ArrayList<AnswerObject> answerObjects;
    public static WebDriver driver;
    public DriverUtil driverUtil;
    public List<List<String>> results = new ArrayList<>();
    private int index;

    public void setUp() {
        index = 0;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        //options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driverUtil = new DriverUtil(driver);
        //driver.get("http://www.get-myip.com/");
    }

    public void getStartPage() {
        driver.get("https://www.uniturm.de/studienwahltest-studiumsfinder/start");
    }

    public void setupParcticipant(String gender, String age) {
        driverUtil.selectOption("gender", gender);
        driverUtil.selectOption("age",age);
        driverUtil.selectOption("city","28");
        driverUtil.selectOption("education_type_id", "4");
        this.wait(1000);
        driver.findElement(By.className("nextPage")).click();
    }

    public void startRating(){
        for(AnswerObject answerObject : answerObjects){
            try {
                getStartPage();
                if(index == 0){
                    setupParcticipant("m","20");
                }
                setRating(answerObject.answers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setRating(HashMap<Integer, Integer> answerObject) throws InterruptedException {
        //First Page
        for(int i=0; i<10; i++){
            setAnswer(answerObject, i);
        }
        driverUtil.scrollToElement(getXPathForQuestionResult(questionObjects.get(19).code, answerObject.get(questionObjects.get(19).number)));
        for(int i=10; i<20; i++){
            setAnswer(answerObject, i);
        }
        this.wait(1000);
        driver.findElement(By.className("nextPage")).click();
        //Second Page
        for(int i=20; i<30; i++){
            setAnswer(answerObject, i);
        }
        driverUtil.scrollToElement(getXPathForQuestionResult(questionObjects.get(39).code, answerObject.get(questionObjects.get(39).number)));
        for(int i=30; i<40; i++){
            setAnswer(answerObject, i);
        }
        this.wait(1000);
        driver.findElement(By.className("nextPage")).click();
        //Third Page
        for(int i=40; i<45; i++){
            setAnswer(answerObject, i);
        }
        this.wait(1000);
        driver.findElement(By.className("nextPage")).click();
        //Fourth Page
        for(int i=45; i<55; i++){
            setAnswer(answerObject, i);
        }
        driverUtil.scrollToElement(getXPathForQuestionResult(questionObjects.get(64).code, answerObject.get(questionObjects.get(64).number)));
        for(int i=55; i<65; i++){
            setAnswer(answerObject, i);
        }
        this.wait(1000);
        driver.findElement(By.className("nextPage")).click();
        //Fifth Page
        for(int i=65; i<75; i++){
            setAnswer(answerObject, i);
        }
        driverUtil.scrollToElement(getXPathForQuestionResult(questionObjects.get(84).code, answerObject.get(questionObjects.get(84).number)));
        for(int i=75; i<85; i++){
            setAnswer(answerObject, i);
        }
        this.wait(1000);
        driver.findElement(By.className("nextPage")).click();
        //Last Page
        for(int i=85; i<95; i++){
            setAnswer(answerObject, i);
        }
        this.wait(1000);
        driverUtil.scrollToElement("//*[@class=\"ButtonShadow\"]");
        driver.findElement(By.className("ButtonShadow")).click();
        this.wait(3000);
        getResults();
    }

    private void setAnswer(HashMap<Integer, Integer> answerObject, int i){
        if(questionObjects.get(i).inverted){
            driver.findElement(By.xpath(getXPathForQuestionResult(questionObjects.get(i).code, invert(answerObject.get(questionObjects.get(i).number))))).click();
        }else {
            driver.findElement(By.xpath(getXPathForQuestionResult(questionObjects.get(i).code, answerObject.get(questionObjects.get(i).number)))).click();
        }
    }

    private String getXPathForQuestionResult(int number, int value){
        return "//input[@name=\"question["+number+"]\"][@value=\""+value+"\"]";
    }

    private int invert(int toInvert){
        if(toInvert == 1){
            return 5;
        }else if(toInvert == 2){
            return 4;
        }else if(toInvert == 4){
            return 2;
        }else if(toInvert == 5){
            return 1;
        }else{
            return 3;
        }
    }

    private void getResults(){
        String major1 = driver.findElement(By.xpath("//*[@id=\"right-part\"]/div/div[2]/ul/li[1]")).getText();
        String major2 = driver.findElement(By.xpath("//*[@id=\"right-part\"]/div/div[2]/ul/li[2]")).getText();
        String major3 = driver.findElement(By.xpath("//*[@id=\"right-part\"]/div/div[2]/ul/li[3]")).getText();
        List<String> temp = new ArrayList<String>();
        temp.add(Integer.toString(index));
        temp.add(major1);
        temp.add(major2);
        temp.add(major3);
        //temp.addAll(getOtherAnswers());
        index++;
        results.add(temp);
    }

    private ArrayList<String> getOtherAnswers(){
        ArrayList<String> result = new ArrayList<>();
        AnswerObject temp = answerObjects.get(index);
        if(answerObjects.get(index).otherAnswers.get(0).equals("Ja")){
            result.add("Student: Ja");
            result.add("Studiengang: "+temp.otherAnswers.get(4));
            result.add("Zufriedenheit: "+temp.otherAnswers.get(1));
            result.add(temp.otherAnswers.get(2));
        }else{
            result.add("Student: Nein");
            result.add("Studiengang: "+temp.otherAnswers.get(3));
            result.add(temp.otherAnswers.get(5));
        }
        return  result;
    }

    public long getWaitTime() {
        double temp = (2000 + Math.random() * 10000);
        long waitTime = (long) temp;
        return waitTime;
    }

    public void closeDriver() {
        driver.close();
    }

    public void setMappingList(ArrayList<QuestionObject> questionObjects) {
        this.questionObjects = questionObjects;
    }

    public void setAnswerObjects(ArrayList<AnswerObject> answerObjects){ this.answerObjects = answerObjects; }

    public void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
