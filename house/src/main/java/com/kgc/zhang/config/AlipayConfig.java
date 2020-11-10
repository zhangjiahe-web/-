package com.kgc.zhang.config;

import java.io.FileWriter;
import java.io.IOException;
/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id ="2016102200738541";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCr7/5LCuYWQE6aqIddAihXD9wDgGZHrcMVW1OMm/gUGpzd1XoxKTLd8HQwiHg2uRKy5kYNi4TYjLbwZcDDH2hv93HavlRCuWjfOuPAmHwE+a0EVHmmZ06OGnmpHTf3RiNOmp9vVlATuHJFfoeHbIa7eP1eYJopYEacb7LzXMZVDopHCo6Z2HjjIh8IYTH/tj+JZXVWo9lCxNlF78/0kMOfhACjegtrCe/3Itv1tvhdju5bGX12upteaaQYxZmae60ZUDC+XICBXwytp8Di+fI4gLi3Zh7nei6XvOlXL0I+L6URUNQynhvNErn5bol0OQF6eakjsXdxGaFbDtS6tSfpAgMBAAECggEBAJZclhVIXbk92b/0/BQBjAe/TdgeFNRAiGeH64P+7i+eqmpxg5+0eNCQtPuwjPjGVyzupnq39aBvRpjrU20QbYPlcMMsSYHkpWr7FCvc7jBnrMAppA07MP6i9pxHeiccRko6fI2gfP0SA5T0t09eQGF4yJMdhhQDJx0treCX1LaSRRYppZkOjUsmeC4uFBz6axanqpRW4+10XWbT6snvuHGCvAAo0YxUoSXiw8holfKfd2wGvKHLqD8KY9s45a1tlBBYaf7vPpFNm8GnQxNkrjNZIndlHQQ49erXf/gmGoLAioHfEvnIrjAstulsYETH430X2W51QtgWEHegcSoBglECgYEA5nsOVY9K8EVz4wnYk1/SheA3JW1CqDgfo6FCqFbocDp4qDJtuX0s+S1QIXXrc/sO9SWO0Gb7JJP0qRjEBtiEiP+ipKgO1diojRNyhvGVyFh00SKM2nhkT0eXM7QLTDRJBRH7HyMNb13/UPvCv9uewOykH2eIHHr5/5MW9MRDFHUCgYEAvvmJsFJBkkY2+NNaWQdWAWZ0Nwg3NTZBxJ31ANq/Dhsw6+ombeBq5nSwMGIybaX41nS9hsZpjkhW0TqrHcOwOt4PCTBcbUVOQRuLrRLcgLUscgLUZZNJxAyZmVHoosn5JbFdrlbMEUHEG6GqJ2+yIB8UrnIIlzl+xlDOWCskByUCgYEAvWo8aYyN5dDuYJRi7Rs/BM80Awo8UctuFSgehAKInFMxfemTy3FYWKAozpb+nh6iOE5ZhGRd2b3OwHmeAJJIud59aBzFtHGOdAKbiNNaaYBo4McoQxPWPGF1ngRFlKcTq5sPapOAIxp5DbEaaFqxqZPRfg20CtP2SVg08YuqJVECgYEAjdv7RXi0sJ1rtEX7dOqYHo4mgcKej+5vyEe1eR8EkMvt+TCDv1bW0b2YKzimUQDa6SLqrjSwsDpYEy/LcF6uh+vvq1m7Logu6vo1NSkvloP+MeqcL5/LSdA6QMOxVUtGwZMRDbH4AFGkBQp/xK+Z13Z+/F5Et2DEJThdLu1M4+kCgYEAuyRlOHCJ3tckjJbth383FzX57Ap9J125fclkDgYozOQojmY7nMl0CGxFgm5tjJ3qDcHfBBGHMCVcYKC6rFr8GbpmTJWGfX9l0MP6eD+drUmtih5NcggVgzJmP9Fn9xhLlG97z8rp2DR3xiSJboPgxhbfaiBmpa2jFHKulfm5kgo=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq+/+SwrmFkBOmqiHXQIoVw/cA4BmR63DFVtTjJv4FBqc3dV6MSky3fB0MIh4NrkSsuZGDYuE2Iy28GXAwx9ob/dx2r5UQrlo3zrjwJh8BPmtBFR5pmdOjhp5qR0390YjTpqfb1ZQE7hyRX6Hh2yGu3j9XmCaKWBGnG+y81zGVQ6KRwqOmdh44yIfCGEx/7Y/iWV1VqPZQsTZRe/P9JDDn4QAo3oLawnv9yLb9bb4XY7uWxl9drqbXmmkGMWZmnutGVAwvlyAgV8MrafA4vnyOIC4t2Ye53oul7zpVy9CPi+lEVDUMp4bzRK5+W6JdDkBenmpI7F3cRmhWw7UurUn6QIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/mytopaidlist";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	

	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

