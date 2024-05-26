import java.util.List;

class Item {
    String name;
    String barcode; //numerical
    int price;
    float discount;

    public Item(String name, String code, int price, float discount) {
        this.name = name;
        this.barcode = code;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String code) {
        this.barcode = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){
        //1
        if (allItems == null){
            //2
            throw new RuntimeException("allItems list can't be null!");
        }
        //3
        float sum = 0;
        //4.1 - 4.4
        for (int i = 0; i < allItems.size(); i++){
            Item item = allItems.get(i);
            //5
            if (item.getName() == null || item.getName().length() == 0){
                //6
                item.setName("unknown");
            }
            //7
            if (item.getBarcode() != null){
                //8
                String allowed = "0123456789";
                char chars[] = item.getBarcode().toCharArray();
                //9.1, 9.2, 9.4
                for (int j = 0; j < item.getBarcode().length(); j++){
                    //9.3
                    char c = item.getBarcode().charAt(j);
                    //10
                    if (allowed.indexOf(c) == -1){
                        //11
                        throw new RuntimeException("Invalid character in item barcode!");
                    }
                    //12
                }
                //13
                if (item.getDiscount() > 0){
                    //14
                    sum += item.getPrice()*item.getDiscount();
                }
                else {
                    //15
                    sum += item.getPrice();
                }
                //16
            }
            else {
                //17
                throw new RuntimeException("No barcode!");
            }
            //18
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){
                //19
                sum -= 30;
            }
            //20
        }
        //21
        if (sum <= payment){
            //22
            return true;
        }
        else {
            //23
            return false;
        }
        //24
    }
}