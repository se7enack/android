package com.dorkcloud.numbershapes;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.util.Log;

public class MainActivity extends ActionBarActivity {


    class Number {

        int number;

        public boolean isSq() {

            double sqRt = Math.sqrt(number);
            if (sqRt == Math.floor(sqRt)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isTri() {

            int x = 1;
            int triNum = 1;

            while (triNum < number) {
                x++;
                triNum = triNum + x;
            }

            if (triNum == number) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void testNumber (View view) {
        EditText usersNumber = (EditText) findViewById(R.id.usersNumber);
        Number myNum = new Number();
        myNum.number = Integer.parseInt(usersNumber.getText().toString());
        System.out.println(myNum.isSq());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
