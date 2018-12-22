//package csku.hotel;
//
//import csku.Income.Income;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.Assert.assertEquals;
//
//
//public class UnitTestIncome {
//    Income income;
//
//    @BeforeEach
//    void init(){
//        income = new Income ();
//        income.moneyIn(3000);
//    }
//
//    @Test
//    public void testCurrentincome(){
//        assertEquals(3000,income.baLance());
//    }
//
//    @Test
//    public void testNormalCaseofspendmoney(){
//        assertEquals(500,income.moneyOut(500));
//        assertEquals(2500,income.baLance());
//    }
//
//    @Test
//    public void addMoneytoaccount(){
//        assertEquals(700,income.moneyIn(700));
//        assertEquals(3700,income.baLance());
//    }
//
//    @Test
//    public void lastSpend(){
//        assertEquals(2000,income.moneyOut(2000));
//        assertEquals(2000,income.getMonOut());
//    }
//
//    @Test
//    public void paymoneyMorethanhave(){
//        assertEquals(3000,income.moneyOut(3100));
//
//    }
//
//
//
//}
