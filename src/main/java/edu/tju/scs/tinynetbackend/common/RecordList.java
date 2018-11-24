package edu.tju.scs.tinynetbackend.common;


import edu.tju.scs.tinynetbackend.controller.RecordController;
import edu.tju.scs.tinynetbackend.domain.Record;
import edu.tju.scs.tinynetbackend.domain.RecordWithBLOBs;

import java.io.File;
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

                RecordController.addOutput(i.getName(),FileHelper.getOurput(i.getOwner(),i.getName()));
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

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        list.add(recordInfo);
    }


}
