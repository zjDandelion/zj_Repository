package com.zj.util;

import java.util.HashMap;
import java.util.Map;

public class BankNameUtil {
  public static Map<String, String> maps;
  static{
    maps=new HashMap<String, String>();
    maps.put("ICBC", "工商银行");
    maps.put("CCB", "建设银行");
    maps.put("ABC", "农业银行");
    maps.put("GDB", "广东发展");
    maps.put("BOC", "中国银行");
    maps.put("PSBC", "中国邮政");
    maps.put("CIB", "兴业银行");
    maps.put("CEB", "光大银行");    
    maps.put("CMB", "招商银行");
    maps.put("SPDB", "浦发银行");    
    maps.put("BOB", "北京银行");
    maps.put("CMBC", "民生银行");   
    maps.put("BCOM", "交通银行");
    maps.put("CITIC", "中信银行");    
    maps.put("HXB", "华夏银行");
    maps.put("NJCB", "南京银行");    
    maps.put("PAB", "平安银行");
    maps.put("BJRCB", "北京农商");
    maps.put("BEA", "东亚银行");
    maps.put("SHB", "上海银行");
    maps.put("NBCB", "宁波银行");
    maps.put("CZB", "浙商银行");
    maps.put("SDB", "深圳发展");
    maps.put("HZB", "杭州银行");
    maps.put("CBHB", "渤海银行");
    maps.put("HSB", "徽商银行");
    maps.put("SRCB", "上海农村商业");
  }
}
