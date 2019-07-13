# Ud3_Ejemplo1
_Ejemplo 1 de la Unidad 3._ 

Creamos un _Intent_ implícito y abrimos la página web de Google. 
El _Intent_ es implícito ya que no nos importa qué navegador abra la página.

Para ello añadimos un botón a nuestro _layout_ (_activity_main.xml_):

```
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/abrir_google"
        android:id="@+id/boton"
        android:onClick="abrirIntent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```
 Al botón le asignamos en el atributo _onClick_ el nombre del método que lanzará el _Intent_, _abrirIntent_.
 
El método está implementado en el fichero _MainActivity.java_:

```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Método que lanza un intent implícito a la web de Google.
     * @param view
     */
    public void abrirIntent(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com"));

        // Verificamos si existe una aplicación para gestionarlo.
        if(intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

}
```

Podemos ver como al _Intent_ le pasamos la acción a realizar y los datos en un objeto _Uri_ y antes de lanzarlo verificamos
si existe una aplicación que pueda gestionarlo.
