package com.example.mitologia_chilota;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class CuentoHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mitologia_chilota.db";
    private final Context context;

    public CuentoHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS cuento (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, historia TEXT NOT NULL, ruta_imagen TEXT)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS cuento";

        db.execSQL(sql);
        onCreate(db);
    }

    public ArrayList listaCuentos(){
        ArrayList<String> cuentos = new ArrayList<String>();

        cuentos.add("{\"id\": 1, \"titulo\": \"El Caleuche\", \"historia\": \"Barco fantasma que aparece y desaparece con una gran facilidad. En días de neblina, quienes han logrado verlo, cuentan que es un barco maravillosamente iluminado y que su tripulación(brujos) cantan y bailan al compás de preciosas melodías con las cuales atraren y encantan a algunos comerciantes para surtirlos de mercaderías. Se cuenta que los comerciantes que han tenico contacto con los brujos se iniciaron con pequeñas cosas y hoy son comerciantes prosperos e importantes en la zona.\n" +
                "\n" +
                "Tambien este barco tiene como misión, transportar a los brujos. Este se puede trasladar tanto bajo como sobre el mar. Al desaparecer en forma inesperada deja en el ambiente un extraño ruido de cadenas y los ecos de la música.\n" +
                "\n" +
                "Muchas personas relacionan al Caleuche con un barco pirata holandés que viajaba por estos mares.\", \"ruta_imagen\": \"caleuche\"}");

        cuentos.add("{\"id\": 2, \"titulo\": \"La Pincoya\", \"historia\": \"Mujer de belleza extraordinaria en la cual se personifica la fertilidad de las costas de Chiloé y sus especias marinas. A ella se le atribuye la escasez o abundancia de peces y mariscos.\n" +
                "\n" +
                "La Pincoya suele aparecer en las costas con el Pincoy (su marido) el cual se sienta a cantar sobre una roca en donde atrae a la Pincoya y la envuelve con su voz melodiosa haciéndola entrar en una danza frenética, sensual y maravillosa. Si baila vuelta hacia el mar habrá mucha abundancia y si bailase vuelta hacia la plata habrá escasez.\n" +
                "\n" +
                "Pescadores la han visto en roqueríos peinando su cabellera larga. Cuando los chilotes naufragan la Pincoya acude a su auxulio.\", \"ruta_imagen\": \"pincoya\"}");

        cuentos.add("{\"id\": 3, \"titulo\": \"La Fiura\", \"historia\": \"Mujer repugnante, horriblemente fea, de pequeña estatura, de aliento hediondo. Habita en los bosques, en las cercanías de los “Hualdes”. Es coqueta, se baña en las vertientes o cascadas, donde se peina con deleite su larga y abundante cabellera con un peine de cristal, usa un vestido colorado muy llamativo. Después del baño se sienta sobre musgo y permanece desnuda durante horas. \n" +
                "\n" +
                "Es el femenino de la perversidad; incansable novia de los solteros. Se deleita haciendo el mal a quienes la rechazan, sean estos animales o seres humanos. Los “Agarra”; para algunos es la hija de la “Condená”, de ahí las expresiones, “lo tentó la condená”, “catai fiura”, “Condenao”. La Fiura tiene gran poder de seducción y una vez saciado su apetito sexual, enloquece al desdichado, El poder de aliento, “Mal de Aire”, puede producir ciática o tullimiento y dejar a los animales descuadrilados, rengueados o quebrados. Si alguien quiere mofarse de alguna persona suele gritarle donde va esa “Fiura”.\", \"ruta_imagen\": \"fiura\"}");

        cuentos.add("{\"id\": 4, \"titulo\": \"El Camahueto\", \"historia\": \"Este ser de la mitología chilota es un ternero parecido a un unicornio por su único cuerno en la frente, que brilla en las noches de luna. \n" +
                "\n" +
                "Quienes dicen haberlo visto, cuentan que es muy ágil, vigoroso, y de gran hermosura. Se dice que nace y se desarrolla donde hay caídas de agua o terrenos pantanosos, su vida aquí dura hasta haber alcanzado los 25 años (edad adulta) para luego, emigrar hacia el mar, En su viaje destruye los sembrados y la naturaleza que esté en su camino.\n" +
                "\n" +
                "Cuando se llega a saber sobre la existencia de un Camahueto en los terrenos de alguna persona, ésta busca a un brujo, el cual laceará al Camahueto con una soga de sargazo y lo llevará al mar tratando de no causar daño en el camino.\n" +
                "\n" +
                "El camahueto no se deja atrapar por los “limpios”, solo aquel que conozca el “arte” podrá atraparlo y siempre y cuando se encuentren en la tierra y en el plenilunio, para así cortarle el cuerno sin el cual se convertirá en un débil y mando como un cordero.\n" +
                "\n" +
                "A su cacho se le atribuyen poderes curativos, por lo que se lo raspa para sanar enfermedades tales como reumatismo, anemia, entre otras. Sus efectos son tan fuertes que si alguien ingiere una sobredosis puede quedar “encahuetado” (esquizofrénico, loco). Y si se mezclan con miel y chicha de manzana devuelve el vigor y la fuerza gastada, quedando como “Potro en primavera”.\n\", \"ruta_imagen\": \"camahueto\"}");

        cuentos.add("{\"id\": 5, \"titulo\": \"Brujo\", \"historia\": \"Es un enemigo de los “limpios”, su poder es de extremada fuerza y su capacidad de convertir o transformar las cosas o las personas es tan increíble que puede asombras hasta a los más incrédulos.\n" +
                "\n" +
                "Los brujos formaron en Chiloé, una institución denominada “Recta Provincia” la cual tiene su “Casa Grande” o “Mayoría”, cerca del pueblo de Quicaví. Es ahí donde hacen los “Aquelarres” tranquilamente sin que nadie los interrumpa, ya que están resguadados por el “Invunche”.\n" +
                "\n" +
                "El Brujo tiene que cumplir con ciertos requisitos para pertenecer a la “Mayoría” y ejercer su “Arte”. Para reconocerlos se tira un puñado de afrecho en el brasero y si alguien estornuda, es porque es brujo, para eliminarlo tendrá que ser sorprendido por alguien en sus fechorías, así morirá antes de un año.\", \"ruta_imagen\": \"brujo\"}");

        cuentos.add("{\"id\": 6, \"titulo\": \"El Invunche\", \"historia\": \"Es aquel ser hipertrofiado que cuida la cueva de los brujos. Es un niño recién nacido que es raptado o donado por algún brujo. Lo crían desnudo en la cueva y lo alimentan con carne humana y leche de gata. Cuando crece, los brujos lo transforman en un monstruo, al deformarlo. Poniéndole una pierna en el espinazo, que impide que se aleje de la cueva.\n" +
                "\n" +
                "Se le permite salir solo cuando tiene que alimentarse, desplazándose en tres patas y emitiendo sonidos guturales, asustando y horrorizando a aquellos que lo oyen. Si un “limpio” lo ve, se transforma o lo enlesa para siempre. Los únicos que pueden mirarlo sin peligro alguno, son los brujos.\n" +
                "\n" +
                "Si de noche le dan de palos a un invunche, significa que va a haber pestes y muertes. La carne de este ser cura cualquier enfermedad y cuando muere uno, los brujos se los “pleitean”.\", \"ruta_imagen\": \"invunche\"}");

        return cuentos;
    }

    public boolean insert(){
        Gson json = new Gson();

        for (int i = 0; i < listaCuentos().size(); i++){
            Cuento c = json.fromJson(listaCuentos().get(i).toString(), Cuento.class);
            String query = "SELECT id FROM cuento WHERE ID = " + c.getId();
            SQLiteDatabase dbSelect = this.getReadableDatabase();

            Cursor cursor = dbSelect.rawQuery(query, null);

            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                SQLiteDatabase dbUpdate = this.getWritableDatabase();
                cursor.moveToFirst();
                ContentValues contentValues = new ContentValues();
                contentValues.put("titulo", c.getTitulo());
                contentValues.put("historia", c.getHistoria());
                contentValues.put("ruta_imagen", c.getRuta_imagen());
                dbUpdate.update("cuento", contentValues, "id = " + c.getId(), null);
            }else if(cursor.getCount() == 0){
                SQLiteDatabase dbInsert = this.getWritableDatabase();
                cursor.moveToFirst();
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", c.getId());
                contentValues.put("titulo", c.getTitulo());
                contentValues.put("historia", c.getHistoria());
                contentValues.put("ruta_imagen", c.getRuta_imagen());
                dbInsert.insert("cuento", null, contentValues);
            }
        }

        return true;
    }

    public ArrayList getCuentos(){
        ArrayList<Cuento> cuentosList = new ArrayList<Cuento>();
        String query = "SELECT id, titulo, historia, ruta_imagen FROM cuento";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Cuento cuento = new Cuento();
                cuento.setId(Integer.parseInt(cursor.getString(0)));
                cuento.setTitulo(cursor.getString(1));
                cuento.setHistoria(cursor.getString(2));
                cuento.setRuta_imagen(cursor.getString(3));

                cuentosList.add(cuento);
            } while (cursor.moveToNext());
        }

        return cuentosList;
    }
}
