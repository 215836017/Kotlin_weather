package com.fzq.kotlin_weather;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import sun.misc.BASE64Encoder;


public class Test {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println("time: " + time);
        HashMap<String, String> map = new HashMap<>();
        map.put("location", "hangzhou");
        map.put("username", "HE1804141148361464");
        map.put("t", time+"");
        try {
            String signature = getSignature(map, Constants.heFeng_key);

            System.out.println("signature: " + signature);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// location=hangzhou&username=HE1804141148361464&t=1477455132&sign=458c682400df47efb841a69154d7677d
    /**
     *  加密签名方式如下：
     1. 将请求参数格式化为“key=value”格式，如“k1=v1”、“k2=v2”、“k3=v3”；
     2. 去除请求参数中值为空的参数
     3. 去除请求参数中参数为 sign 的参数 ( 签名参数不参与签名算法 )
     4. 将第3步剩余的键值对以字典序升序排列，并用 & 符号连接，如 a=1&b=2&m=3&w=4
     5. 将第4步得到的字符串后拼接上API密钥, 假设密钥为 abc , 则 结果为: a=1&b=2&m=3&w=4abc
     6. 将第5步得到的字符串进行MD5加密 ( 注 ：字符集为 UTF-8 )，得到签名结果
     7. 将第6步得到的签名结果 作为参数添加至请求中，参数名为 sign, 即 sign=xxxxxxx
     */

    /**
     * 和风天气签名生成算法-JAVA版本
     *
     * @param  params 请求参数集，所有参数必须已转换为字符串类型
     * @param secret                 secret 签名密钥（用户的认证key）
     * @return 签名
     * @throws IOException
     */
    public static String getSignature(HashMap<String, String> params, String secret) throws IOException {
        // 先将参数以其参数名的字典序升序进行排序
        Map<String, String> sortedParams = new TreeMap<>(params);
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();

        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起

        StringBuilder baseString = new StringBuilder();
        for (Map.Entry<String, String> param : entrys) {
            //sign参数 和 空值参数 不加入算法
            if (param.getValue() != null && !"".equals(param.getKey().trim()) && !"sign".equals(param.getKey().trim()) && !"key".equals(param.getKey().trim()) && !"".equals(param.getValue().trim())) {
                baseString.append(param.getKey().trim()).append("=").append(param.getValue().trim()).append("&");
            }
        }
        if (baseString.length() > 0) {
            baseString.deleteCharAt(baseString.length() - 1).append(secret);
        }

        // 使用MD5对待签名串求签
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(baseString.toString().getBytes("UTF-8"));
            return new BASE64Encoder().encode(bytes);
        } catch (GeneralSecurityException ex) {
            throw new IOException(ex);
        }
    }
}
