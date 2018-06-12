package org.yuan.demo.shop.error;

public class ShopException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private ShopMessage shopMessage;

    private ShopException(ShopMessage shopMessage) {
        this.shopMessage = shopMessage;
    }

    public ShopMessage getShopMessage() {
        return shopMessage;
    }
    
    public static ShopException error(ShopMessage shopMessage) {
        return new ShopException(shopMessage);
    }
}
