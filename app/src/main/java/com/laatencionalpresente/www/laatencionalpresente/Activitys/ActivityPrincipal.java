package com.laatencionalpresente.www.laatencionalpresente.Activitys;

/*
 * Esta clase es el Activity Drawer, sera nuestra clase principal, aqui se veran todos los cursos.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.laatencionalpresente.www.laatencionalpresente.R;

import static com.laatencionalpresente.www.laatencionalpresente.Utils.Datos.estaLogado;

public class ActivityPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    
    Menu nav_Menu;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        
        nav_Menu = navigationView.getMenu();
        
        
        //ocultarNavs();
        
    }
    
    private void ocultarNavs(){
        //esto comprueba si hay usuario logado. y oculta las opciones pertinentes.
    
        nav_Menu.findItem(R.id.nav_login).setVisible(true);
        nav_Menu.findItem(R.id.nav_area_cliente).setVisible(true);
        nav_Menu.findItem(R.id.nav_perfil).setVisible(true);
        
        if(estaLogado){
            nav_Menu.findItem(R.id.nav_login).setVisible(false);
        }else {
            nav_Menu.findItem(R.id.nav_area_cliente).setVisible(false);
            nav_Menu.findItem(R.id.nav_perfil).setVisible(false);
        
           
        }
    }
    
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_principal, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        
        //noinspection SimplifiableIfStatement
        if (id == R.id.idiomaEsp) {
            return true;
        } else if (id == R.id.idiomaIng) {
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
    
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent i = null;
        
        if (id == R.id.nav_area_cliente) {
    
             i =new Intent(ActivityPrincipal.this,ActivityAreaPersonal.class);
           
        } else if (id == R.id.nav_perfil) {
    
            i =new Intent(ActivityPrincipal.this,ActivityAreaPersonal.class);
            
        } else if (id == R.id.nav_login) {
    
            i =new Intent(ActivityPrincipal.this,ActivityAreaPersonal.class);
            
        } else if (id == R.id.nav_contacto) {
    
            i =new Intent(ActivityPrincipal.this,ActivityAreaPersonal.class);
            
        }
    
        startActivity(i);
        
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        
        
        return true;
    }
}
