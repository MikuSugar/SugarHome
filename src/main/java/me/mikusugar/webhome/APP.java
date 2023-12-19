package me.mikusugar.webhome;

import com.alibaba.fastjson.JSONObject;
import com.github.jknack.handlebars.internal.Files;
import me.mikusugar.webhome.pojo.InputConfig;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author mikusugar
 */
@SuppressWarnings("IOStreamConstructor")
public class APP {
    public static void main(String[] args) throws IOException {
        final InputConfig inputConfig = InputConfig.parseArgs(args);
        System.out.println("读取的配置文件为:" + inputConfig);
        String jsonStr = Files.read(new File(inputConfig.getJson()), StandardCharsets.UTF_8);
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        //模板所在目录，相对于当前classloader的classpath。
        resolver.setPrefix("");
        //模板文件后缀
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        //构造上下文(Model)
        Context context = new Context();
        context.setVariable("results", jsonObject);

        //渲染模板
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(inputConfig.getOut()), StandardCharsets.UTF_8);
        System.out.println("writer = " + writer.getEncoding());

        //这个example.html 放在resources 下面.
        // 这样会生成一个result.html文件,结果都已经放进去了.
        engine.process("example", context, writer);
        writer.close();
        engine.clearTemplateCache();
    }
}
