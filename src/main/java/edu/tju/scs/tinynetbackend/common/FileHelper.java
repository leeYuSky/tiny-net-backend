package edu.tju.scs.tinynetbackend.common;

import edu.tju.scs.tinynetbackend.po.Record;
import edu.tju.scs.tinynetbackend.po.RecordWithBLOBs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileHelper {

    public static String getOurput(String username,String recordname)
    {
        String path="./"+username+"/"+recordname+"/IO/OUT0";
        String ret="";
        try {

            File file = new File(path);
            String[] filePath = file.list();
            for (int i = 0; i < filePath.length; i++)
            {

                File tempfile = new File(path+"/"+filePath[i]);
                FileInputStream in = new FileInputStream(tempfile);
                ret=ret+filePath[i]+";";
                Scanner scanner = new Scanner(in);
                while (scanner.hasNext())
                {
                    ret=ret+scanner.nextLine()+'\n';
                }

                in.close();
                if(i!=filePath.length-1)
                    ret=ret+'|';

            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  ret;
    }

    public static boolean checkFinish(String username,String recordname)
    {
        String path="./"+username+"/"+recordname+"/IO/OUT0";
        String[] filePath=null;
        try {

            File file = new File(path);
            filePath = file.list();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if(filePath.length>0)
            return true;
        else
            return false;
    }

    public static void newRecord(Record record)
    {
        String path="./"+record.getOwner()+"/"+record.getName();
        try {
            copyDir("D:/optimization",path);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void createUser(String username)
    {
        String newPath = "./"+username;
        try {
            if (!(new File(newPath)).exists()) {
                (new File(newPath)).mkdir();
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String getExe(String username,String recordname)
    {
        return "./"+username+"/"+recordname+"/DesignElectricPower_Test.exe";
    }

    public static String getDir(String username,String recordname)
    {
        return "./"+username+"/"+recordname;
    }

    public static void setIO(RecordWithBLOBs record)
    {
        String username=record.getOwner();
        String recordname=record.getName();
        String path="./"+username+"/"+recordname+"/IO";
        String input=record.getInput();
        String file[] = input.split("|");
        try {
            (new File(path)).mkdir();
            (new File(path+"/IN0")).mkdir();
            (new File(path+"/OUT0")).mkdir();

            for(int i=0;i<file.length;i++)
            {
                String temp[]=file[i].split(":");
                if(temp.length==2)
                {
                    File newfile = new File(path+"/IN0/"+temp[0]);
                    FileOutputStream out = new FileOutputStream(newfile);

                    out.write(temp[1].getBytes());
                    out.close();
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public static void copyDir(String sourcePath, String newPath) throws IOException {
        File file = new File(sourcePath);
        String[] filePath = file.list();

        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();
        }

        for (int i = 0; i < filePath.length; i++) {
            if ((new File(sourcePath + file.separator + filePath[i])).isDirectory()) {
                if(filePath[i].equals("IO"))
                    continue;

                copyDir(sourcePath  + file.separator  + filePath[i], newPath  + file.separator + filePath[i]);
            }

            if (new File(sourcePath  + file.separator + filePath[i]).isFile()) {
                copyFile(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

        }
    }


    public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);;

        byte[] buffer=new byte[2097152];
        int readByte = 0;
        while((readByte = in.read(buffer)) != -1){
            out.write(buffer, 0, readByte);
        }

        in.close();
        out.close();
    }
}
