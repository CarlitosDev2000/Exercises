package com.carloscordova.my_dialog_exercise;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class UserListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_layout);
        List<User> userList = getIntent().getParcelableArrayListExtra("userList");
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        CustomUserAdapter adapter = new CustomUserAdapter(userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
