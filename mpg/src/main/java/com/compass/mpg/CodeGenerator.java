package com.compass.mpg;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 代码生成器
 *
 * @author liushuozhen
 * @date 2022/08/01
 */
@SuppressWarnings("AlibabaMethodTooLon")
public class CodeGenerator {

    /**
     * 代码生成
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 当前项目的路径
        String projectPath = System.getProperty("user.dir");
        // 生成文件输出根目录
        gc.setOutputDir(projectPath + "/mpg/src/main/java");
        // 作者
        gc.setAuthor("itsaxon");
        // 生成完成后不弹出文件框
        gc.setOpen(false);
        // 文件是否覆盖
        gc.setFileOverride(true);
        //主键策略 实体类主键ID类型
        gc.setDateType(DateType.ONLY_DATE);
        // 是否开启swagger
        gc.setSwagger2(true);
        //【不懂】 活动记录 不需要ActiveRecord特性的请改为false 是否支持AR模式
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        //【不懂】 XML ResultMap xml映射文件的配置
        gc.setBaseResultMap(true);
        //【不懂】 XML columList xml映射文件的配置
        gc.setBaseColumnList(false);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setEntityName("%sEntity");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();

        dsc.setUrl("jdbc:mysql://localhost:3306/itsaxon?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull&serverTimezone=PRC&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("1q2w3e4r");
        mpg.setDataSource(dsc);

        //3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.compass.mpg");
        // 可以不用设置，默认是controller
        pc.setController("");
        // 同上
        pc.setService("service");
        // 同上
        pc.setServiceImpl("service.impl");
        // 默认是mapper
        pc.setMapper("mapper");
        // 默认是entity
        pc.setEntity("model");
        // 默认是默认是mapper.xml
        pc.setXml("");
        // pc.setModuleName("demo"); // 控制层请求地址的包名显示
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/template/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                System.out.println(projectPath);
                // 自定义输出文件名
                return projectPath + "/mpg/src/main/resources/mapper"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 需要生成的表 设置要映射的表名
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动lombok；
        strategy.setEntityLombokModel(true);
        //【不懂】 开启全局大写命名
        strategy.setCapitalMode(false);
        //【不懂】
        // 是否需要开启特定规范字段
        strategy.setLogicDeleteFieldName("del_flag");
        // 自动填充配置
        TableFill gmtCreateTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmtCreateEnable = new TableFill("enable", FieldFill.INSERT);
        TableFill gmtCreateEmpNo = new TableFill("create_emp_no", FieldFill.INSERT);
        TableFill gmtCreateEmpName = new TableFill("create_emp_name", FieldFill.INSERT);
        TableFill gmtUserId = new TableFill("user_id", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("update_time",
                FieldFill.INSERT_UPDATE);
        TableFill gmtModifiedEmpNo = new TableFill("update_emp_no",
                FieldFill.INSERT_UPDATE);
        TableFill gmtModifiedEmpName = new TableFill("update_emp_name",
                FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreateTime);
        tableFills.add(gmtCreateEnable);
        tableFills.add(gmtCreateEmpNo);
        tableFills.add(gmtCreateEmpName);
        tableFills.add(gmtModified);
        tableFills.add(gmtModifiedEmpNo);
        tableFills.add(gmtModifiedEmpName);
        tableFills.add(gmtUserId);
        strategy.setTableFillList(tableFills);
        // 乐观锁
        // 控制：true——生成@RsetController false——生成@Controller
        strategy.setRestControllerStyle(true);
        // 【不知道是啥】
        strategy.setControllerMappingHyphenStyle(true);
        // 表字段注释启动 启动模板中的这个 <#if table.convert>
        strategy.setEntityTableFieldAnnotationEnable(true);
        // 是否删除实体类字段的前缀
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        // 去掉表名mdm_inf_rec_data中的 mdm_ 类名为InfRecData
        strategy.setTablePrefix("t_");

        // 控制层mapping的映射地址 false：infRecData true：inf_rec_data
        strategy.setControllerMappingHyphenStyle(false);
        mpg.setStrategy(strategy);

        //模板生成器
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        TemplateConfig tc = new TemplateConfig();
        tc.setController(null);
        tc.setService("/template/service.java");
        tc.setServiceImpl("/template/serviceImpl.java");
        tc.setEntity("/template/entity.java");
        tc.setMapper("/template/mapper.java");
        tc.setXml(null);
        mpg.setTemplate(tc);

        mpg.execute(); //执行

    }

    /**
     * 控制台
     *
     * @param tip 提示
     * @return {@link String}
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StrUtil.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

}