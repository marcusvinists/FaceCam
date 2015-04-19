package sistemaintegrado.facecam;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class FaceCam1 extends ActionBarActivity {

    //Criando minhas variaveis botao
    Button btnTakeaPhoto;
    ImageView imgTakenPhoto;
    private static final int CAM_REQUEST = 1313;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_cam1);

        //Chamando  meu botão camera
        btnTakeaPhoto = (Button) findViewById(R.id.button);
        imgTakenPhoto  = (ImageView) findViewById(R.id.imageView1);

        btnTakeaPhoto.setOnClickListener(new btnTakenPhotoClicker());
    }

    //método adicionado para setonclicklistener funcionar
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAM_REQUEST){
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            imgTakenPhoto.setImageBitmap(thumbnail);
        }

    }

    //Classe da Camera para iniciar atividade
    class btnTakenPhotoClicker implements Button.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraintent, CAM_REQUEST);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
