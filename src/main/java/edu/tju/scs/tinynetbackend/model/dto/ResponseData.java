package edu.tju.scs.tinynetbackend.model.dto;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ResponseData {

    @Getter
    @Setter
    Map<String,Object> data = new HashMap<>();

    public ResponseData(){

    }

    public ResponseData addData(@NonNull String key, @NonNull Object value){
        try {
            data.put(key,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public Object getData(@NonNull String key){
        try {
            return data.getOrDefault(key,null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResponseData deleteData(@NonNull String key){
        try {
            data.remove(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public static void main(String[] args){
        ResponseData responseData = new ResponseData();
        responseData.addData(null,null);

    }
}
