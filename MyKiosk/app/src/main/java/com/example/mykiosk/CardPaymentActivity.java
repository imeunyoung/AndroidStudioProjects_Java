package com.example.mykiosk;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mykiosk.model.Card;
import com.example.mykiosk.model.Order;
import com.example.mykiosk.model.Payment;

public class CardPaymentActivity extends AppCompatActivity {
    Button inputCardBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_payment);

        Intent intent = getIntent();
        int totalPrice = intent.getIntExtra("totalPrice", 0);
        boolean isTakeout=intent.getBooleanExtra("isTakeout",false);
        inputCardBtn=(Button)findViewById(R.id.input_card_btn);


        inputCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card card= new Card(12345678,30000); //사용자의 카드 임의로 설정
                Payment cardPay = new Payment(card, totalPrice, isTakeout);
                // 아니요를 선택한 경우에 대한 처리
                String isPay = cardPay.pay(); //카드 결제
                Log.d("isPay", isPay);

                TextView paymentResultText = findViewById(R.id.payment_result_text);
                if (isPay.equals("결제 성공")) {
                    paymentResultText.setText("결제가 완료되었습니다.");
                    Intent intent= new Intent(CardPaymentActivity.this,OrderFinishActivity.class);
                    intent.putExtra("orderNumber",Payment.orderNumber);
                    startActivity(intent);

                } else {
                    paymentResultText.setText("결제에 실패하였습니다.");
                }
            }
        });



    }
}
