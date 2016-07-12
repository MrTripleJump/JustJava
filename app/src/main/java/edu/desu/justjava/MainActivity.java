package edu.desu.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        EditText editText = (EditText) findViewById(R.id.editText);
        String name = editText.getText().toString();
        CheckBox orderSummaryCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean whippedcream = orderSummaryCheckbox.isChecked();
        int price = calculatePrice(whippedcream);
        String message = createOrderSummary(price, whippedcream, name);
        displayMessage(message);
    }
    /**
     * Calculates the price of the order.
     *
     * //@param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(boolean whippedcream) {
        int basePrice = 5;

        if(whippedcream){
            basePrice = basePrice + 1;
        }
        return quantity * basePrice;
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
        displayQuantity(quantity);

        if (quantity==100){
            Toast.makeText(MainActivity.this, "Quantity can not be more than 100", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            quantity=quantity+1;
        }
    }
    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(MainActivity.this, "Quantity must be more than 1", Toast.LENGTH_SHORT).show();
            return;
        } else {
            quantity = quantity - 1;
            displayQuantity(quantity);

        }
    }

    public String createOrderSummary(int number ,boolean whippedcream, String name) {
        String chris = "Name: Kaptain Kunal\n"+"Add whipped cream? "+ whippedcream+"\nQuantity:" + quantity + "\nTotal:"+ NumberFormat.getCurrencyInstance().format(number)+"\nThank you!";
        return chris;

    }

    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}