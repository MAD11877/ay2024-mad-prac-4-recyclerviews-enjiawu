package sg.edu.np.mad.madpractical4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    ArrayList<User> data;
    Context context;

    public UserAdapter(Context context, ArrayList<User> input){
        this.context = context;
        this.data = input;
    }

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // you used the wrong layout file
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
        return new UserViewHolder(item);
    }

    public void onBindViewHolder(UserViewHolder holder, int position){
        User user = data.get(position);
        holder.name.setText(user.name);
        holder.description.setText(user.description);

        holder.imageViewSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle(user.name);
                builder.setMessage(user.description);
                builder.setCancelable(true);

                builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent goToMainActivity = new Intent (context, MainActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("User", (Serializable) user);
                        goToMainActivity.putExtras(bundle); //Both must be string values
                        context.startActivity(goToMainActivity);
                    }
                });
                builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                }
                );

                AlertDialog alert = builder.create();
            }
        });
    }

    public int getItemCount() {
        return data.size();
    }

}
