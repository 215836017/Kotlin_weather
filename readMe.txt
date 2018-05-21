1. 使用了和风天气的API，已经注册号了用户，并且在网页上已经测试过了几条数据没有问题

2. 在Kotlin项目中，基本是网络请求还没走通。。。。

2018.04.15

1. 学习了在Kotlin中使用OKhttp3， 用法和在Java中基本相同。

2. 学习了在Kotlin中使用Retrofit， 用法和在Java中基本相同

2018.04.17

1.主要是针对于数据类做了一些修改（com.fzq.kotlin_weather.json2bean包中）

2018.04.22

1. 主要添加了一些工具类。

2018.05.10


1.分别使用OkHttp3和Retrofit通过了网络测试，并从和风天气API获取了想要的数据

2. 添加了一些数据类，而且都是Kotlin中的数据类

3. 使用Retrofit中的GSON转换为数据类失败，目前使用Google的GSON转换是成功的（具体就是TestNetwork.kt中的testRetrofitGet方法）

2018.05.16


1. 成功完成了一个Fragment中Forecast，Hourly，Now三种数据的请求，并使用GSON转换后在界面上显示

2. 因为Hourly请求时返回的结果为permission denied， 所以请求走了，但是界面的适配的数据是假数据。

3. 目前效果还算可以接受，效果图见：xiaoguo-20180521.png

2018.05.21