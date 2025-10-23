import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {

    public static BigDecimal lineTotal(BigDecimal price, int qty) {
        return price.multiply(BigDecimal.valueOf(qty));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Lang (en/fi/sv/ja): ");
        String lang = sc.nextLine().toLowerCase();
        System.out.print("Country (US/FI/SE/JP): ");
        String country = sc.nextLine().toUpperCase();

        Locale locale = new Locale(lang, country);
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);
        NumberFormat currency = NumberFormat.getCurrencyInstance(locale);

        System.out.print(rb.getString("askItemCount") + " ");
        int n = Integer.parseInt(sc.nextLine());

        BigDecimal total = BigDecimal.ZERO;

        for (int i = 1; i <= n; i++) {
            System.out.print(String.format(rb.getString("enterPrice"), i) + " ");
            BigDecimal price = new BigDecimal(sc.nextLine());

            System.out.print(String.format(rb.getString("enterQty"), i) + " ");
            int qty = Integer.parseInt(sc.nextLine());

            total = total.add(lineTotal(price, qty));
        }

        System.out.println(String.format(rb.getString("total"), currency.format(total)));
    }
}
