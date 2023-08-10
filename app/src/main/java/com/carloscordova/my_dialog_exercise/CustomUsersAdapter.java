package com.carloscordova.my_dialog_exercise;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
class CustomUserAdapter extends RecyclerView.Adapter<CustomUserAdapter.UserViewHolder> {
    private List<User> userList;
    public CustomUserAdapter(List<User> userList) {
        this.userList = userList;
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.bind(user);
    }
    @Override
    public int getItemCount() {
        return userList.size();
    }
    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewEmail, textViewName, textViewAge;
        UserViewHolder(View itemView) {
            super(itemView);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewAge = itemView.findViewById(R.id.textViewAge);
        }
        void bind(User user) {
            textViewEmail.setText(user.getEmailUser());
            textViewName.setText(user.getNameUser());
            textViewAge.setText(String.valueOf(user.getAgeUser()));
        }
    }


}
