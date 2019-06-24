package com.ganesh.materialdesignpro2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    FrameLayout frameLayout;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=findViewById(R.id.mainframe);
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(frameLayout,"fab is clicked",Snackbar.LENGTH_LONG).show();
            }
        });
        toolbar=findViewById(R.id.materialToolbar);
        toolbar.setTitle("SnackBarDemo");
        toolbar.setSubtitle("By Ganesh");
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setElevation(10f);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                int i=item.getItemId();
                switch(i)
                {
                    case R.id.simple_snackbar:
                        showSimpleSnackBar();
                        break;
                    case R.id.action_snackbar:
                        showActionSnackBar();
                        break;
                    case R.id.styled_snackbar:
                        showStyledSnackBar();
                        break;
                }

                return true;
            }
        });

    }

    private void showStyledSnackBar() {
    }

    private void showActionSnackBar() {
       Snackbar snackbar=Snackbar.make(frameLayout,"File deleted",Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Snackbar.make(frameLayout,"File Recovered",Snackbar.LENGTH_LONG).show();
            }
        }).show();
    }

    private void showSimpleSnackBar() {
        Snackbar.make(frameLayout,"Simple SnackBar example",Snackbar.LENGTH_LONG).show();
    }
}
