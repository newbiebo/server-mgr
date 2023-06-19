package org.simple.sm.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @author wangbo
 * Mybatis Plus Generator
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        //0 Code Generator Object
        AutoGenerator mpg = new AutoGenerator();

        //1 Global Configuration
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("newbiebo");
        //Do you want to open the resource manager
        gc.setOpen(false);
        //Do you want to generate a file to overwrite the original file
        gc.setFileOverride(true);
        gc.setServiceName("%sService");
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);

        //2 Configure Data Source
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.SQLITE);
        dsc.setUrl("jdbc:sqlite:D:\\code\\github\\java\\ServerMannager\\src\\main\\resources\\db\\server-manager.db");
        dsc.setDriverName("org.sqlite.JDBC");
        mpg.setDataSource(dsc);

        //3 Generate Package Settings
        PackageConfig pc = new PackageConfig();
        pc.setParent("org.simple.sm.db.sqlite");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        mpg.setPackageInfo(pc);

        //4 Configuration Policy
        StrategyConfig strategy = new StrategyConfig();
        //Set the table to be mapped
        strategy.setInclude("remind_me_job_info");
        //Naming of underlined humps
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setLogicDeleteFieldName("is_delete");

        //4.1 Auto Fill Policy
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE );
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
        mpg.setStrategy(strategy);

        // Execution Constructor
        mpg.execute();
    }
}
