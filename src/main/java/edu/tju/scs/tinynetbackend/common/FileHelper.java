package edu.tju.scs.tinynetbackend.common;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.tinynetbackend.model.po.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileHelper {

    public static String getOurput(String username,String recordname)
    {
        String path="/"+username+"/"+recordname+"/IO/OUT0";
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

    public  static  String readFile(String path)
    {
        String ret="";
        try{

                File tempfile = new File(path);
                FileInputStream in = new FileInputStream(tempfile);
                Scanner scanner = new Scanner(in);
                while (scanner.hasNext()) {
                    ret = ret + scanner.nextLine() + '\n';
                }
                in.close();


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  ret;

    }

    public static String getInput(String temp)
    {
        String ret="";
        JSONObject jsonpObject= JSON.parseObject(temp);
        JSONObject json = JSON.parseObject(jsonpObject.get("deviceData").toString());
        int len;


        ret+="AbschilleParameter.txt:|";


        ret+="BatteryParameter.txt:";
        JSONObject batterydata = JSON.parseObject(json.get("battery").toString());
        if(batterydata!=null)
        {
            batterydata = JSON.parseObject(batterydata.get("data").toString());
            List<Battery> batterys  = JSON.parseArray(batterydata.get("battery_ids").toString(),Battery.class);
            // List<Battery> batterys = JSON.parseArray(batterydata.get("battery_ids").toString());
            len=batterys.size();
            for(int i=0;i<len;i++)
            {
                ret+=batterys.get(i).toString1();
                ret+=batterydata.get("battery_soc_init").toString()+'\n';
                ret+=batterydata.get("battery_soc_upper_limit").toString()+'\n';
                ret+=batterydata.get("battery_soc_lower_limit").toString()+'\n';
                ret+=batterydata.get("battery_total_flow").toString()+'\n';
                ret+=batterydata.get("battery_back_flow").toString()+'\n';
                ret+=batterys.get(i).toString2()+'\n';
            }
        }

        //System.out.println(batterydata.toString());
        ret+="|";

        ret+="ConverterParameter.txt:|";

        ret+="Coolload.txt:|";

        ret+="CoolstorageParameter.txt:|";

        ret+="DieselParameter.txt:";
        JSONObject generatordata = JSON.parseObject(json.get("generator").toString());
        if(generatordata!=null)
        {
            generatordata = JSON.parseObject(generatordata.get("data").toString());
            List<Generator> generators  = JSON.parseArray(generatordata.get("generator_ids").toString(), Generator.class);
            len=generators.size();
            for(int i=0;i<len;i++)
            {
                ret+=generators.get(i).toString1();
                if(generators.get(i).getType().equals("汽油"))
                {
                    ret+=generatordata.get("qiyou_price").toString()+'\n';
                }
                else
                {
                    ret+=generatordata.get("chaiyou_price").toString()+'\n';
                }
                ret+=generators.get(i).toString2()+'\n';
            }
            //System.out.println(batterydata.toString());
            ret+="|";
            for(int i=0;i<len;i++)
            {
                ret+="DieselPowerCurve"+Integer.toString(i)+".txt:";
                ret+=generators.get(i).toString3();
                ret+="|";
            }
        }
        else
        {
            ret+="|";
        }


        ret+="ElecairconditionParameter.txt:|";

        ret+="ElecboilerParameter.txt:|";

        ret+="ElectricitychillerParameter.txt:|";
        //Todo
        ret+="GAParameter.txt:";
        try{
            ret+=readFile("D:/IN0/GAParameter.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';


        ret+="GasboilerParameter.txt:|";

        ret+="GasPowerCurve.txt:|";

        ret+="GasturebineParameter.txt:|";

        ret+="Heatload.txt:|";

        ret+="HeatstorageParameter.txt:|";

        ret+="HydroTurbineParameter.txt:";
        JSONObject turbinedata = JSON.parseObject(json.get("turbine").toString());
        if(turbinedata!=null)
        {
            turbinedata = JSON.parseObject(turbinedata.get("data").toString());
            List<Turbine> turbines  = JSON.parseArray(turbinedata.get("turbine_ids").toString(),Turbine.class);
            // List<Battery> batterys = JSON.parseArray(batterydata.get("battery_ids").toString());
            len=turbines.size();
            for(int i=0;i<len;i++)
            {
                ret+=turbines.get(i).toString1()+'\n';
            }
        }
        ret+="|";

        ret+="PhotovoltaicParameter.txt:";
        JSONObject photovoltaicdata = JSON.parseObject(json.get("photovoltaic").toString());
        if(photovoltaicdata!=null)
        {
            photovoltaicdata = JSON.parseObject(photovoltaicdata.get("data").toString());
            List<Photovoltaic> photovoltaics  = JSON.parseArray(photovoltaicdata.get("photovoltaic_ids").toString(),Photovoltaic.class);
            // List<Battery> batterys = JSON.parseArray(batterydata.get("battery_ids").toString());
            len=photovoltaics.size();
            for(int i=0;i<len;i++)
            {
                ret+=photovoltaics.get(i).toString1();
                ret+=photovoltaicdata.get("photovoltaic_sq").toString()+'\n';
                ret+=photovoltaicdata.get("photovoltaic_wd").toString()+'\n';
                ret+=photovoltaicdata.get("photovoltaic_jd").toString()+'\n';
                ret+=photovoltaics.get(i).toString2()+'\n';
            }
        }
        ret+="|";

        ret+="PowerPriload.txt:";
        try{
            ret+=readFile("D:/IN0/PowerPriload.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        ret+="PumpParameter.txt:|";

        ret+="PurchasePrice_Grid.txt:|";

        ret+="SellingPrice_Grid.txt:|";

        ret+="SolarRadiation.txt:";
        try{
            ret+=readFile("D:/IN0/SolarRadiation.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';
        //Todo 这个还有些问题，这些参数页面里现在还找不到
        ret+="SourceParameter.txt:";
        try{
            ret+=readFile("D:/IN0/SourceParameter.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        //Todo 参数有点多，慢慢往里边填
        ret+="SystemParameter.txt:";
        try{
            ret+=readFile("D:/IN0/SourceParameter.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        ret+="WasteheatboilerParameter.txt:|";

        ret+="SystemParameter.txt:";
        try{
            ret+=readFile("D:/IN0/WaterFlow.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        ret+="SystemParameter.txt:";
        try{
            ret+=readFile("D:/IN0/Weekend.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        ret+="Weekend_Cool.txt:|";

        ret+="Weekend_Heat.txt:|";

        ret+="windSpeed.txt:";
        try{
            ret+=readFile("D:/IN0/windSpeed.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        ret+="WindTurbineParameter.txt:";
        JSONObject wind_turbinesdata = JSON.parseObject(json.get("wind_turbines").toString());
        if(wind_turbinesdata!=null)
        {
            wind_turbinesdata = JSON.parseObject(wind_turbinesdata.get("data").toString());
            List<Wind_Turbines> wind_turbines  = JSON.parseArray(wind_turbinesdata.get("wind_turbines_ids").toString(), Wind_Turbines.class);
            len=wind_turbines.size();
            for(int i=0;i<len;i++)
            {
                ret += wind_turbinesdata.get("fscldjdmgd").toString() + '\n';
                ret += wind_turbinesdata.get("hbgd").toString() + '\n';
                ret += wind_turbinesdata.get("dmcccd").toString() + '\n';
                ret += wind_turbines.get(i).toString1() + '\n';
            }
            //System.out.println(batterydata.toString());
            ret+="|";
            for(int i=0;i<len;i++)
            {
                ret+="WTPowerCurve"+Integer.toString(i)+".txt:";
                ret+=wind_turbines.get(i).toString2();
                ret+="|";
            }
        }
        else
        {
            ret+="|";
        }

        ret+="WorkingDays.txt:";
        try{
            ret+=readFile("D:/IN0/WorkingDays.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        ret+="WorkingDays_Cool.txt:|";

        ret+="WorkingDays_Heat.txt:|";

        return ret;
    }

    public static boolean checkFinish(String username,String recordname)
    {
        String path="/"+username+"/"+recordname+"/IO/OUT0";
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
        String path="/"+record.getOwner()+"/"+record.getName();
        try {
            copyDir("D:\\MicroGrid - zhongche1214\\bin",path);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void createUser(String username)
    {
        String newPath = "/"+username;
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
        return "/"+username+"/"+recordname+"/DesignElectricPower_Test.exe";
    }

    public static String getDir(String username,String recordname)
    {
        return "/"+username+"/"+recordname;
    }

    public static void setIO(RecordWithBLOBs record)
    {
        String username=record.getOwner();
        String recordname=record.getName();
        String path="/"+username+"/"+recordname+"/IO";
        String input=record.getInput();
        String file[] = input.split("\\|");
        try {
            (new File(path)).mkdir();
            (new File(path+"/IN0")).mkdir();
            (new File(path+"/OUT0")).mkdir();
            System.out.println(file.length);
            for(int i=0;i<file.length;i++)
            {
                //System.out.println(file[i]);
                String temp[]=file[i].split(":");
                System.out.println(temp.length);
                if(temp.length==2)
                {
                    System.out.println(i);
                    File newfile = new File(path+"/IN0/"+temp[0]);
                    FileOutputStream out = new FileOutputStream(newfile);

                    out.write(temp[1].getBytes());
                    out.close();
                }
                else if(temp.length==1)
                {


                    System.out.println(i);
                    File newfile = new File(path+"/IN0/"+temp[0]);
                    FileOutputStream out = new FileOutputStream(newfile);

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
