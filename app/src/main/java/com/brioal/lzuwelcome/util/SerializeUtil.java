package com.brioal.lzuwelcome.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化与反序列工具
 * Created by Brioal on 2016/8/16.
 */

public class SerializeUtil {

    //序列化
    public static boolean serialize(Context context, String fileName, String key, Object person) {
        try {
            SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    byteArrayOutputStream);
            objectOutputStream.writeObject(person);
            String serStr = byteArrayOutputStream.toString("ISO-8859-1");
            serStr = java.net.URLEncoder.encode(serStr, "UTF-8");
            editor.putString(key, serStr);
            editor.commit();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //反序列化
    public static Object deSerialization(Context context, String fileName, String key) {
        try {
            SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
            String str = preferences.getString(key, "");
            String redStr = java.net.URLDecoder.decode(str, "UTF-8");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                    redStr.getBytes("ISO-8859-1"));
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    byteArrayInputStream);
            Object person = objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return person;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
