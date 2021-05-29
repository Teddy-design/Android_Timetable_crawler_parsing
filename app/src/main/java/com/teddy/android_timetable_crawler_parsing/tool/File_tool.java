package com.teddy.android_timetable_crawler_parsing.tool;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class File_tool {

    public static String read_file(String name, Context context) {
        String FILENAME = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS) + File.separator + name;
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();
        try {
            fis = new FileInputStream(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            sb.append(line);
            while ((line = br.readLine()) != null) {
                sb.append("\n");
                sb.append(line);
            }
            br.close();
            isr.close();
            fis.close();
        } catch (FileNotFoundException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
        return sb.toString();
    }


    public static void save_file(String name, String text, Context context) {
        String FILENAME = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS) + File.separator + name;
        File file = new File(FILENAME);
        if (!file.exists()) {
            File dir = new File(Objects.requireNonNull(file.getParent()));
            dir.mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fos = null;
        StringBuilder sb = new StringBuilder();
        try {
            fos = new FileOutputStream(file);
            OutputStreamWriter isr = new OutputStreamWriter(fos);
            BufferedWriter br = new BufferedWriter(isr);

            br.write(text);
            br.flush();
            br.close();
            isr.close();
            fos.close();
        } catch (IOException e) {
            Log.d("save:", "false");
        }
    }

}
