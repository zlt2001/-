package com.stu_management.common;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/storage?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimeZone=GMT%2B8&allowPublicKeyRetrieval=true", "root", "zlt983948")
                .globalConfig(builder -> {
                    builder.author("zlt") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride()
                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("com.stu_management") // 设置父包名
                                .moduleName("mybatisPlus") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/java")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                                builder.addInclude("user") // 设置需要生成的表名
                        //.addTablePrefix("t_", "c_") // 设置过滤表前缀
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
