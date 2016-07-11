package edu.desu.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        String message = createOrderSummary(price);
        displayMessage(message);
    }
    /**
     * Calculates the price of the order.
     *
     * //@param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int anything) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + anything);
    }
    /**
     * This method displays the given price on the screen.
     */
    //    TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
    //orderSummaryTextView.setText("Name: Kaptain Kunal" + "\n quantity"  + "\nTotal " + NumberFormat.getCurrencyInstance().format(number)+ "\nThank You!");
    //}
    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public String createOrderSummary(int number) {
        String chris = "Name: Kaptain Kunal\nQuantity: "+ quantity + "\nTotal:"+ NumberFormat.getCurrencyInstance().format(number)+"\nThank you!";
        return chris;

    }

    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}