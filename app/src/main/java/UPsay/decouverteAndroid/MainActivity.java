package UPsay.decouverteAndroid;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void dessin(View view){
        TextView editText = (TextView) findViewById(R.id.monTexte);
        editText.setText("YES !!!");
        setContentView(R.layout.gestionaire2);
    }

    public void on_off(View view){
        Toast.makeText(view.getContext(),	 "Il	 faut	 saisir	 une	 heure",
                Toast.LENGTH_SHORT).show();
    }
}