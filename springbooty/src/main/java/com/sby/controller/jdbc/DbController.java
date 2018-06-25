package com.sby.controller.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zheng on 2018/6/15.
 */
@RestController
@RequestMapping("/mydb")
public class DbController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/getSchools")
    public List<Map<String, Object>> getDbType(){
        String sql = "select id,name,star,address,teacher_number,student_number,introduction from booty_school";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry = iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }

    @RequestMapping("/school/{id}")
    public Map<String,Object> getSchool(@PathVariable String id){
        Map<String,Object> map = null;

        List<Map<String, Object>> list = getDbType();
        for (Map<String, Object> dbmap : list) {
            Set<String> set = dbmap.keySet();
            for (String key : set) {
                if(key.equals("id")){
                    if(dbmap.get(key).equals(id)){
                        map = dbmap;
                    }
                }
            }
        }
        if(map==null)
            map = list.get(0);
        return map;
    }

}
