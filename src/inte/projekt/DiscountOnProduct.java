package inte.projekt;

import java.math.BigDecimal;
import java.util.List;

public class DiscountOnProduct implements DiscountInterface {
    private String id;
    private int productId;
    private BigDecimal discountProcentage;


    public DiscountOnProduct(String id, int productId, BigDecimal discountProcentage) {
        if (discountProcentage.compareTo(BigDecimal.ZERO) > 0 && discountProcentage.compareTo(new BigDecimal(0.7)) <= 0) {
            this.discountProcentage = discountProcentage;
            this.productId = productId;
            this.id = id;
        } else {
            throw new IllegalArgumentException("ken dum jävel");
        }

    }

    @Override
    public boolean checkDiscount(List<Product> productsFromReceipt, boolean isMember) {
        return false;
        //TODO
    }

    @Override
    public boolean checkDiscount(List<Product> productsFromReceipt) {
        return true;
        //TODO
    }

    @Override
    public BigDecimal getDiscountSum(List<Product> productsFromReceipt) {
        BigDecimal temp = new BigDecimal(0);
        for (Product p : productsFromReceipt) {
            if (p.getId() == productId) {
                temp = temp.add(p.getPrice().multiply(this.discountProcentage));
            }
        }

        return temp.setScale(0, BigDecimal.ROUND_HALF_UP);


    }

    @Override
    public List<Product> getAffectedProducts(List<Product> productsFromReceipt) {
        return productsFromReceipt;
    }

    public BigDecimal getPriceWithDiscount(List<Product> productsFromReceipt) {
        BigDecimal temp = BigDecimal.ZERO;
        for (Product p : productsFromReceipt) {
            if(p.getId() == productId){
                temp = temp.add(p.getPrice().multiply(BigDecimal.ONE.subtract(this.discountProcentage)));
            }
        }

        return temp.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public BigDecimal getDiscountAmount() {
        return null;
    }

}
