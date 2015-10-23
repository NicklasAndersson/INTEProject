package inte.projekt;

import java.math.BigDecimal;
import java.util.List;

public class DiscountOnCategory implements DiscountInterface {

    private String category;
    private BigDecimal amount = BigDecimal.ZERO;

    public DiscountOnCategory(String category, BigDecimal amount) {
        this.category = category;
        this.amount = amount;
    }

    @Override
    public boolean checkDiscount(List<Product> productsFromReceipt, boolean isMember) {
        return false;
    }

    @Override
    public boolean checkDiscount(List<Product> productsFromReceipt) {
        for (Product p : productsFromReceipt) {
            if (p.getCategory().equals(category)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public BigDecimal getDiscountSum(List<Product> productsFromReceipt) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Product p : productsFromReceipt) {
            if (p.getCategory().equals(category)) {
                sum = sum.add(getDiscountAmount());
            }
        }
        return sum;
    }

    @Override
    public List<Product> getAffectedProducts(List<Product> productsFromReceipt) {
        return null;
    }

    @Override
    public String getID() {
        return category;
    }

    @Override
    public BigDecimal getDiscountAmount() {
        return amount;
    }

    public String toString() {
        return getID() + "\t" + getDiscountAmount() + "kr\n";
    }
}
