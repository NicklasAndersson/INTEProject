/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inte.projekt;

import org.junit.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author andre
 */
public class TestDiscount {

    private Product p;
    private Discount d;
    private DiscountPerProduct dd;


    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @Test
    public void testDiscountOnProduct() {
        p = new Product(1, new BigDecimal(100), "bread", "sweetbread");
        d = new Discount(new BigDecimal(0.3), p);
        assertEquals(new BigDecimal(100), p.getPrice());
        assertEquals(new BigDecimal(70), d.getPriceWithDiscount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDiscount() {
        p = new Product(1, new BigDecimal(100), "bread", "sweetbread");
        d = new Discount(new BigDecimal(-0.2), p);
        assertTrue(d.getDiscountAmount().compareTo(BigDecimal.ZERO) > 0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxDiscount() {
        p = new Product(1, new BigDecimal(100), "bread", "sweetbread");
        d = new Discount(new BigDecimal(0.71), p);
        assertTrue(d.getDiscountAmount().compareTo(new BigDecimal(0.7)) >= 0);

    }

    @Test
    public void testDiscountAmount() {
        p = new Product(1, new BigDecimal(100), "bread", "sweetbread");
        d = new Discount(new BigDecimal(0.6), p);
        assertEquals(new BigDecimal(0.4), d.getDiscountAmount());
        d.setDiscountAmount(new BigDecimal(0.4));
        assertEquals(new BigDecimal(0.6), d.getDiscountAmount());

    }

    @Test
    public void testResetDiscountAmount() {
        p = new Product(1, new BigDecimal(100), "bread", "sweetbread");
        d = new Discount(new BigDecimal(0.6), p);
        assertEquals(new BigDecimal(40), d.getPriceWithDiscount());
        d.resetDiscountAmount();
        assertEquals(new BigDecimal(100), d.getPriceWithDiscount());
    }

    @Test
    public void testDiscountAmount2() {
        p = new Product(1, new BigDecimal(100), "bread", "sweetbread");
        dd = new DiscountPerProduct(p, new BigDecimal(0.3));
        assertEquals(new BigDecimal(0.3), dd.getDiscountAmount());

    }

    @Test
    public void testPriceWithDiscount() {
        p = new Product(1, new BigDecimal(100), "bread", "sweetbread");
        dd = new DiscountPerProduct(p, new BigDecimal(0.3));
        assertEquals(new BigDecimal(70.00), dd.getPriceWithDiscount());

    }


    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
