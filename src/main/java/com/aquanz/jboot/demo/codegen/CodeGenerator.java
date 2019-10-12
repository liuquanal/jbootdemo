package com.aquanz.jboot.demo.codegen;

import com.jfinal.kit.PathKit;
import io.jboot.codegen.model.JbootBaseModelGenerator;
import io.jboot.codegen.model.JbootModelGenerator;
import io.jboot.codegen.service.JbootServiceImplGenerator;
import io.jboot.codegen.service.JbootServiceInterfaceGenerator;

/**
 * 代码生成器
 *
 * @author a.q.z 2019/10/12 下午11:53
 */
public class CodeGenerator {
    public static void main(String[] args) {
        String modelPackage = "com.aquanz.jboot.demo.codegened.model"; //生成的Model的包名
        String baseModelPackage = "com.aquanz.jboot.demo.codegened.modelbase"; //生成的BaseModel的包名

        //Model存放的路径，一般情况下是 /src/main/java 下，如下是放在 test 目录下
        String modelDir = PathKit.getWebRootPath() + "/src/main/java/" + modelPackage.replace(".", "/");
        String baseModelDir = PathKit.getWebRootPath() + "/src/main/java/" + baseModelPackage.replace(".", "/");

        System.out.println("start generate...");
        System.out.println("generate dir:" + modelDir);

        //开始生成 Model 和 BaseModel 的代码
        new JbootBaseModelGenerator(baseModelPackage, baseModelDir).setGenerateRemarks(true).generate();
        new JbootModelGenerator(modelPackage, baseModelPackage, modelDir).generate();

        String servicePackage = "com.aquanz.jboot.demo.codegened.service"; // service 层的接口包名
        String serviceImplPackage = "com.aquanz.jboot.demo.codegened.service.provider"; // service 层的接口实现类包名

        //设置 service 层代码的存放目录
        String serviceOutputDir = PathKit.getWebRootPath() + "/src/main/java/" + servicePackage.replace(".", "/");
        String serviceImplOutputDir = PathKit.getWebRootPath() + "/src/main/java/" + serviceImplPackage.replace(".", "/");

        //开始生成代码
        new JbootServiceInterfaceGenerator(servicePackage, serviceOutputDir, modelPackage).generate();
        new JbootServiceImplGenerator(servicePackage, serviceImplOutputDir, modelPackage).setImplName("provider").generate();
    }
}
