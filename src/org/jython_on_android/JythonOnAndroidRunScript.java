package org.python.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Html;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.EditText;

public class JythonOnAndroidRunScript extends Activity {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        try {
          ApplicationInfo ai = getPackageManager().getApplicationInfo(
              getPackageName(), PackageManager.GET_META_DATA
              );
          Bundle bundle = ai.metaData;
          String myValue = bundle.getString("org.python.util.JythonOnAndroidRunScript.script");
          Log.d("Jython-on-Android", myValue);
        } catch (Exception e) {
             Log.e("Jython-on-Android", 
                 "Failed to load meta-data, NameNotFound: " + e.getMessage());
        } 
    }

    public void println(String line) { }

}

