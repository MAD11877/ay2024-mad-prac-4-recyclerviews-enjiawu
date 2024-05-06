package sg.edu.np.mad.madpractical4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Creating List of 20  users
        ArrayList<User> userArrayList = new ArrayList<>();
        Random random = new Random();

        for(int i = 1; i <= 20; i++){
            Boolean followingRandom = random.nextBoolean();

            User user = new User("User"+String.valueOf(random.nextInt(100000)),"Description"+String.valueOf(random.nextInt(100000)),i,followingRandom);
            userArrayList.add(user);
        }


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        UserAdapter userAdapter =  new UserAdapter(this, userArrayList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);

        /**
         *
         *
         AlertDialog.Builder builder = new AlertDialog.Builder(this);

         builder.setTitle("Profile");
         builder.setMessage("MADness");
         builder.setCancelable(true);

         builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener(){
         public void onClick(DialogInterface dialog, int id){
         Intent goToMainActivity = new Intent (ListActivity.this, MainActivity.class);
         Random random = new Random();
         goToMainActivity.putExtra("randomNumber",String.valueOf(random.nextInt(100000))); //Both must be string values
         startActivity(goToMainActivity);
         }
         });
         builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
         public void onClick(DialogInterface dialog, int id) {
         dialog.dismiss();
         }
         }
         );

         recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
        );**/

    }
}