package techproed.tests;

import org.testng.annotations.*;

public class Day19_TestNGAnnotations {
/*
        @Test : Test case olusturmak icin kullanilir
        @Before ve @After : 5 Before 5 After annotations var
        suite > tests > group > method
        @BeforeSuite : Her bir test suite'den once 1 sefer calisir
        @AfterSuite : Her bir test suite'den sonra 1 sefer calisir
        @BeforeTest : Her bir Test'den once(TEST CASE ILE KARISTIRILMAMALI) 1 sefer calisir
        @AfterTest : Her bir Test'den sonra(TEST CASE ILE KARISTIRILMAMALI) icin 1 sefer calisir
        @BeforeClass : Her bir class'dan once 1 sefer calisir
        @AfterClass : Her bir class'dan sonra 1 sefer calisir
        @BeforeMethod : Her bir @Test annotation'indan once tek sefer calisir. JUnit'deki Before karsiligidir
        @AfterMethod : Her bir @Test annotation'indan sonra tek sefer calisir. JUnit'deki After karsiligidir
        -----------------------------------------------------------------------------------------------------
        @Ignore : @Test case'leri atlamak icin kullanilir
        @Test(enabled = false) : @Test case'leri kullanima kapatmak icin kullanilir
        -----------------------------------------------------------------------------------------------------
        TestNG'de test case'ler isim sirasina gore calisir
        @Test(priority = 1) : Test caseleri onceliklendirmek icin kullanilir
        NOTE : default priority'nin degeri 0'a esittir
 */
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before Groups");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @Test(priority = 1)
    public void test7() {
        System.out.println("Test 7");
    }
    @Test @Ignore
    public void test2() {
        System.out.println("Test 2");
    }
    @Test(enabled = false)
    public void test3() {
        System.out.println("Test 3");
    }
    @Test(priority = 4)
    public void test4() {
        System.out.println("Test 4");
    }
    @Test(priority = 2)
    public void test5() {
        System.out.println("Test 5");
    }
    @Test
    public void test6() {
        System.out.println("Test 6");
    }
}
