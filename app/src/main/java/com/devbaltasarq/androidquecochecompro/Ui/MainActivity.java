package com.devbaltasarq.androidquecochecompro.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.devbaltasarq.androidquecochecompro.Core.Coche;
import com.devbaltasarq.androidquecochecompro.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar modelo
        this.coche = new Coche();

        // Listeners
        final Button BT_TIPO = this.findViewById( R.id.btTipo );
        final Button BT_FAMILIAR = this.findViewById( R.id.btFamiliar );
        final Button BT_EXTRAS = this.findViewById( R.id.btExtras );
        final Button BT_COMENTARIOS = this.findViewById( R.id.btComentarios );

        BT_TIPO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setTipo();
            }
        });

        BT_FAMILIAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setFamiliar();
            }
        });

        BT_EXTRAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setExtras();
            }
        });

        BT_COMENTARIOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setComentarios();
            }
        });

        // Actualizar UI
        this.muestraModelo();
    }

    private void setTipo()
    {
        AlertDialog.Builder dlg = new AlertDialog.Builder( this );

        dlg.setItems(
                new String[]{ "Berlina", "SUV" },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.coche.setSuv( ( i == 1 ) );
                        MainActivity.this.muestraModelo();
                    }
                }
        );

        dlg.create().show();
    }

    private void setFamiliar()
    {
        AlertDialog.Builder dlg = new AlertDialog.Builder( this );

        int chkItem = 0;

        if ( this.coche.esFamiliar() ) {
            chkItem = 1;
        }

        dlg.setSingleChoiceItems(
                new String[]{ "Con maletero", "Familiar" },
                chkItem,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.coche.setFamiliar( ( i == 1 ) );
                        MainActivity.this.muestraModelo();
                    }
                }
        );

        dlg.setPositiveButton( "Ok", null );
        dlg.create().show();
    }

    private void setExtras()
    {
        AlertDialog.Builder dlg = new AlertDialog.Builder( this );

        dlg.setMultiChoiceItems(
                new String[]{"Aire acondicionado", "Navegador"},
                new boolean[]{ this.coche.getAireAcondicionado(),
                               this.coche.getNavegador() },
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if ( i == 0 ) {
                            MainActivity.this.coche.setAireAcondicionado( b );
                        }
                        else
                        if ( i == 1 ) {
                            MainActivity.this.coche.setNavegador( b );
                        }

                        MainActivity.this.muestraModelo();
                    }
                }
        );

        dlg.setPositiveButton( "Ok", null );
        dlg.show();
    }

    private void setComentarios()
    {
        AlertDialog.Builder dlg = new AlertDialog.Builder( this );
        final EditText ED_COMENTARIOS = new EditText( this );

        dlg.setTitle( "Comentarios" );
        dlg.setView( ED_COMENTARIOS );

        dlg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.coche.setComentarios(
                        ED_COMENTARIOS.getText().toString()
                );
                MainActivity.this.muestraModelo();
            }
        });

        dlg.show();
    }

    private void muestraModelo()
    {
        final TextView LBL_MODELO = this.findViewById( R.id.lblModelo );

        LBL_MODELO.setText( coche.toString() );
        Toast.makeText( this, this.coche.toString(), Toast.LENGTH_LONG ).show();
    }

    private Coche coche;
}
