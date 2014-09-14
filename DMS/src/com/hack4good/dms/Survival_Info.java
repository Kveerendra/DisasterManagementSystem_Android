package com.hack4good.dms;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Survival_Info extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survival__info);
	}
String filename;

private File createImageFile() throws IOException {
    // Create an image file name
    //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = filename;
    File storageDir = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES);
    File image = File.createTempFile(
        imageFileName,  /* prefix */
        ".jpg",         /* suffix */
        storageDir      /* directory */
    );

    // Save a file: path for use with ACTION_VIEW intents
    mCurrentPhotoPath = "file:" + image.getAbsolutePath();
    System.out.println("mCurrent "+mCurrentPhotoPath);
    return image;
}
String mCurrentPhotoPath;

static final int REQUEST_TAKE_PHOTO = 1;

private void dispatchTakePictureIntent() {
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    // Ensure that there's a camera activity to handle the intent
    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
        // Create the File where the photo should go
        File photoFile = null;
        try {
            photoFile = createImageFile();
        } catch (IOException ex) {
            // Error occurred while creating the File
           
        }
        // Continue only if the File was successfully created
        if (photoFile != null) {
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(photoFile));
            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        }
    }
}


	public void submit(View view) {
		String disaster_name = ((EditText)findViewById(R.id.Disaster_Name)).getText().toString();
		String Person_Name = ((EditText)findViewById(R.id.Person_Name)).getText().toString();
		String age = ((EditText)findViewById(R.id.age)).getText().toString();
		String Sex = ((EditText)findViewById(R.id.Sex)).getText().toString();
		String Rescued_Location = ((EditText)findViewById(R.id.Rescued_Location)).getText().toString();
		String Current_Location = ((EditText)findViewById(R.id.Current_Location)).getText().toString();
		String contact_number = ((EditText)findViewById(R.id.contact_number)).getText().toString();
		OKHttp.submitSurvivalInfo(disaster_name,Person_Name,age,Sex,Rescued_Location,Current_Location,contact_number);
		filename =Person_Name+"_"+age;
		dispatchTakePictureIntent();
			Intent i = new Intent(this, Volunteer_Menu.class);
			startActivity(i);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.survival__info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
