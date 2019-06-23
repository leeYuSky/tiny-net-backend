package edu.tju.scs.tinynetbackend.common;


import edu.tju.scs.tinynetbackend.controller.RecordController;
import edu.tju.scs.tinynetbackend.model.po.RecordWithBLOBs;
import edu.tju.scs.tinynetbackend.service.RecordService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecordList {

    private static List<RecordInfo>  list = new ArrayList<RecordInfo>();

    public static boolean check(RecordWithBLOBs record)
    {
        String name=record.getOwner();
        for (RecordInfo i:list)
        {
            if(i.getOwner().equals(name))
                return false;
        }
        return true;
    }
    public static boolean checkNum()
    {
        update();
        if(list.size()<5)
            return true;
        else
            return false;
    }

    public static void update()
    {
        for (RecordInfo i:list)
        {
            Process p=i.getProcess();
            if(FileHelper.checkFinish(i.getOwner(),i.getName()))
            {
                list.remove(i);

                RecordService.addOutput(i.getName(),FileHelper.getOurput(i.getOwner(),i.getName()));
            }

        }
    }

    public static void add(RecordWithBLOBs record)
    {
        FileHelper.newRecord(record);
        FileHelper.setIO(record);
        RecordInfo recordInfo=new RecordInfo(record.getName(),record.getOwner());
        recordInfo.setRuntime(Runtime.getRuntime());

        try {
            recordInfo.setProcess(recordInfo.getRuntime().exec(FileHelper.getExe(record.getOwner(),record.getName()),null,new File(FileHelper.getDir(record.getOwner(),record.getName()))));

            System.out.println("is run");

            BufferedInputStream in = new BufferedInputStream(recordInfo.getProcess().getInputStream());
            BufferedOutputStream outputStream =new BufferedOutputStream(recordInfo.getProcess().getOutputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in,"GB2312"));
            BufferedWriter outp = new BufferedWriter(new OutputStreamWriter(outputStream));
            outp.write("1111");
            outp.flush();
            String lineStr;

            while ((lineStr = inBr.readLine()) != null)
                //获得命令执行后在控制台的输出信息

                System.out.println(lineStr);// 打印输出信息
            //检查命令是否执行失败。
            if (recordInfo.getProcess().waitFor() != 0) {
                if (recordInfo.getProcess().exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束
                    System.err.println("命令执行失败!");
            }
            inBr.close();
            in.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        list.add(recordInfo);
    }


}
